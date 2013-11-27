<%@ page language="java" pageEncoding="GB18030"%>
<%@page import="create.MyWeatherTest;"%>
<%
	String address = request.getParameter("address");
	MyWeatherTest mwt = new MyWeatherTest();
	String content = mwt.getWeatherData(address);
	System.out.println(content);
	out.print(content);
%>
