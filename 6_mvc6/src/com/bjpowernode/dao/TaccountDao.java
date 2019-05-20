package com.bjpowernode.dao;

import java.sql.Connection;

public interface TaccountDao {
	
	//验证账号有没有
	public boolean checkAccount(String account);
	
	//根据账号取余额
	public int getBalanceByAccount(String account);
	
	//根据账号更新余额
	public void updateBalanceByAccount(String account,int balance);
	
}
