package com.bjpowernode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private DBUtil(){}
	
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	
	/*
	 * 
	 * getConn方法为  
	 * 		返回新创建的连接/返回已经有的连接
	 * 		
	 * 		返回新创建的连接:ThreadLocal中没有连接的时候 service层
	 *      返回已经有的连接:ThreadLocal有连接的时候  dao层
	 * 
	 */
	public static Connection getConn() throws SQLException{
		
		Connection conn = t.get();
		
		if(conn==null){
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			t.set(conn);
			
		}
		
		return conn;
		
	}
	
	
	
	//关闭资源
	public static void myClose(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		
		/*
		 * 资源关闭的顺序为,按照创建的顺序,逆序关闭
		 */
		
		if(rs!=null){
			rs.close();
		}
		
		if(ps!=null){
			ps.close();
		}
		
		if(conn!=null){
			conn.close();
			/*
			 * t为什么要remove一下???
			 * 
			 * 连接关闭会,将来会回到连接池中
			 * 线程在执行完,会回到线程池中
			 * 都不销毁,如果不执行t.remove,以后如果线程池为我们再一次分配这根线程,上面就已经有conn了
			 * 
			 * 以下代码非常容易忘
			 * 一定要记得加上
			 * 
			 */
			t.remove();
		}
		
		
	}
	
}














