package com.bjpowernode.test;

public class Lisi implements GiveFlower{

	private Zhangsan zs;
	
	public Lisi(Zhangsan zs){
		this.zs = zs;
	}
	
	@Override
	public void giveFlower() {
		
		
		System.out.println("交流1");
		System.out.println("交流2");
		System.out.println("交流3");
		
		zs.giveFlower();
		
		System.out.println("交流4");
		System.out.println("交流5");
		System.out.println("交流6");
		
	}

	
	
}
