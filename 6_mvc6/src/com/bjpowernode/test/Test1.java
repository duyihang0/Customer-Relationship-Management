package com.bjpowernode.test;

public class Test1 {

	public static void main(String[] args) {
		
		Zhangsan zs = new Zhangsan();
		Lisi ls = new Lisi(zs);
		
		ls.giveFlower();
		

	}

}
