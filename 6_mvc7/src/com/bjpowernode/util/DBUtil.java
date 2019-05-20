package com.bjpowernode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtil {

	private DBUtil() {
	}

	private static Properties prop = new Properties();

	// 声明数据库连接池对象 dds
	private static DruidDataSource dds = null;

	static {
		
		try {
			// db_server.properties
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db_server.properties"));
			//通过数据库连接池工厂来创建一个数据库连接池
			dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();

	/*
	 * 
	 * getConn方法为 返回新创建的连接/返回已经有的连接
	 * 
	 * 返回新创建的连接:ThreadLocal中没有连接的时候 service层 返回已经有的连接:ThreadLocal有连接的时候 dao层
	 * 
	 */
	public static Connection getConn() throws SQLException {

		Connection conn = t.get();

		if (conn == null) {

			//conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//以后从数据库连接池中取连接
			conn = dds.getConnection();
			
			t.set(conn);

		}

		return conn;

	}

	// 关闭资源
	public static void myClose(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {

		/*
		 * 资源关闭的顺序为,按照创建的顺序,逆序关闭
		 */

		if (rs != null) {
			rs.close();
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			
			//将连接放回到数据库连接池中
			conn.close();
			/*
			 * t为什么要remove一下???
			 * 
			 * 连接关闭会,将来会回到连接池中 线程在执行完,会回到线程池中
			 * 都不销毁,如果不执行t.remove,以后如果线程池为我们再一次分配这根线程,上面就已经有conn了
			 * 
			 * 以下代码非常容易忘 一定要记得加上
			 * 
			 */
			t.remove();
		}

	}

}
