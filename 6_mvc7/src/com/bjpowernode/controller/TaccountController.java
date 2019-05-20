package com.bjpowernode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.service.TaccountService;
import com.bjpowernode.service.impl.TaccountServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import com.bjpowernode.util.TransactionInvocationHandler;

public class TaccountController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到转账操作");
		
		String zcAccount = request.getParameter("zcAccount");
		String zrAccount = request.getParameter("zrAccount");
		String zzBalanceStr = request.getParameter("zzBalance");
		
		/*//zs
		TaccountServiceImpl tsi = new TaccountServiceImpl();
		
		TransactionInvocationHandler tih = new TransactionInvocationHandler(tsi);
		//取得ls
		TaccountService ts = (TaccountService) tih.getProxy();
		//ts接口对象为代理实现类的形态(ls),所以调用taccont方法,相当于ls调用送花
		ts.taccount(zcAccount, zrAccount, zzBalanceStr);*/
		
		TaccountService ts = (TaccountService) ServiceFactory.getService(new TaccountServiceImpl());
		ts.taccount(zcAccount, zrAccount, zzBalanceStr);
		
		response.sendRedirect(request.getContextPath() + "/success.jsp");
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	
	}

}



































