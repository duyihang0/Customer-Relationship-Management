package com.bjpowernode.test;

public class Test2 {

	public static void main(String[] args) {
		
		UserServiceImpl usi = new UserServiceImpl();
		UserServiceProxy usp = new UserServiceProxy(usi);
		usp.save();
		

	}

}
