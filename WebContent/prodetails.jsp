<%@page import="cn.boai.pojo.Product"%>
<%@page import="cn.boai.service.zwtservice.impl.ZwtServiceImpl"%>
<%@page import="cn.boai.service.zwtservice.ZwtService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String pro_id=(String)request.getParameter("pro_id");
		ZwtService zs=new ZwtServiceImpl();
		Product pro=zs.queryProductById(pro_id);
		pageContext.setAttribute("pro", pro);
	%>
	${pro.pro_intro }
	<img src="res/static/img/details_imgbig.jpg">
	
</body>
</html>