package com.bjpowernode.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class TransactionInvocationHandler implements InvocationHandler{

	//zs
	private Object target;
	
	public TransactionInvocationHandler(Object target){
		this.target = target;
	}
	
	/*
	 * 该方法为ls的送花方法
	 * 由两部分代码组成
	 * 一部分为使用真正的实现类调用业务逻辑方法 zs调用送花
	 * 我们现在有zs
	 * 我们现在也有方法  method(zs的送花方法)
	 * 接下来的工作就是使用zs来调用method就可以了
	 * 
	 * 
	 * 一部分为增强代码
	 * 
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Connection conn = null;
		Object obj = null;
		try{
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			
			//zs调用送花
			obj = method.invoke(target, args);
			
			
			
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();;
		}finally{
			DBUtil.myClose(conn,null,null);
		}
		
		
		
		return obj;
	}
	
	//取得代理对象 ls
	public Object getProxy(){
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
		
	}
	
	
}



















