package com.bjpowernode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.dao.TaccountDao;
import com.bjpowernode.util.DBUtil;

public class TaccountDaoImpl implements TaccountDao{

	@Override
	public boolean checkAccount(String account) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from t_account where account=?";
		boolean flag = true;
		
		try{
			//取得连接
			conn = DBUtil.getConn();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1,account);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				int count = rs.getInt(1);
				if(count!=1){
					flag = false;
				}
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public int getBalanceByAccount(String account) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select balance from t_account where account=?";
		int balance = 0;
		
		try{
			//取得连接
			conn = DBUtil.getConn();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1,account);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				balance = rs.getInt(1);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return balance;
		
	}

	@Override
	public void updateBalanceByAccount(String account, int balance) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update t_account set balance=? where account=?";
		
		try{
			//取得连接
			conn = DBUtil.getConn();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,balance);
			ps.setString(2,account);
			
			ps.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}




















