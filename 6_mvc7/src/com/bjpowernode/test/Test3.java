package com.bjpowernode.test;

import java.lang.reflect.Method;

public class Test3 {

	public static void main(String[] args) throws Exception {
		
		/*Person p = new Person();
		p.say();*/
		
		Class c = Class.forName("com.bjpowernode.test.Person");
		
		Person p = new Person();
		/*
		 * 取得Person的say方法
		 * 参数1:方法名
		 * 参数2:方法参数的反射类型对象
		 * 
		 * 现在method相当于say方法
		 * 
		 * p
		 * method
		 * 
		 */
		Method method = c.getMethod("say");
		/*
		 * 调用invoke方法执行say方法
		 * 参数1:表示要调用方法的对象
		 * 参数2:表示方法要用到的实参
		 */
		method.invoke(p);
		
		

	}

}



































