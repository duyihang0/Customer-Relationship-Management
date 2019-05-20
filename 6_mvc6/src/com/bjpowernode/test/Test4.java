package com.bjpowernode.test;

import java.lang.reflect.Method;

public class Test4 {

	public static void main(String[] args) throws Exception {
		
		/*Person p = new Person();
		p.say();*/
		
		Class c = Class.forName("com.bjpowernode.test.Person");
		
		Person p = new Person();
		/*
		 * 参数1:方法名
		 * 参数2:方法参数的反射类型对象
		 * 
		 * 
		 * p
		 * method
		 * 
		 */
		Method method = c.getMethod("add",int.class,int.class,String.class);
		/*
		 * 参数1:表示要调用方法的对象
		 * 参数2:表示方法要用到的实参
		 */
		String str = (String) method.invoke(p,1,2,"两个数字相加的和为:");
		
		System.out.println(str);
		

	}

}



































