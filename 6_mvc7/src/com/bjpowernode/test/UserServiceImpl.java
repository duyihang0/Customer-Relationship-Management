package com.bjpowernode.test;

public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		
		System.out.println("添加操作");
	}

	@Override
	public void delete() {
		
		System.out.println("删除操作");

	}

	@Override
	public void update() {
		
		System.out.println("修改操作");
		
	}

	@Override
	public void select() {
		
		System.out.println("查询操作");
		
	}

}
