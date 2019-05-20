package com.bjpowernode.test;

public class UserServiceProxy implements UserService{

	private UserServiceImpl usi;
	
	public UserServiceProxy(UserServiceImpl usi){
		this.usi = usi;
	}
	
	@Override
	public void save() {
		
		System.out.println("添加人员,日志记录开始");
		usi.save();
		System.out.println("添加人员,日志记录结束");
	}

	@Override
	public void delete() {
		
		
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void select() {
		
		
	}

}
