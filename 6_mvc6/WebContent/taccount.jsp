<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>欢迎进入到转账操作系统</h3>
	<form action="taccount.do" method="post">
		请输入转出账号:<input type="text" name="zcAccount"/><br/><br/>
		请输入转入账号:<input type="text" name="zrAccount"/><br/><br/>
		请输入转账金额:<input type="text" name="zzBalance"/><br/><br/>
		<input type="submit" value="提交"/>
	</form>
	
</body>
</html>