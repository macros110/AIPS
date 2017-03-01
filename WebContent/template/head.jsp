<%@page import="java.util.Calendar"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	
	String greeting = "";
	if(hour <= 6){
		greeting = "凌晨好,你该睡觉了。良好的睡眠是美好的一天的开始！";
	}else if(hour <= 9){
		greeting = "早上好！丰富的早晨可帮你持续一天的精力";
	}else if(hour <= 12){
		greeting = "上午好！注意用眼时间！";
	}else if(hour <= 18){
		greeting = "下午好！小心打瞌睡！";
	}else if(hour <= 24){
		greeting = "晚上好！早点休息！";
	}else{
		
	}
%>
<%! //注意这里是 %!
	public void jspInit(){
		//初始化时候用
		this.log("jsp初始化");
	}

	public void jspDestroy(){
		//销毁时候用
		this.log("jsp销毁");
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to AIPS</title>
<link ref='stylesheet' type='text/css' href='css/style.css'>
</head>
<body>
<table width="100%" cellspacing=1 bgcolor=#4169E1>
	<tr>
		<td bgcolor=#4682B4 align= center colspan=7 style="color:#FFFFFF;font-size:40px;height:60px;">
		 <%= greeting %>
		</td>		
	</tr>
	<tr>
		<td bgcolor=#DDDDDD align=center>
			<a href="<%=request.getContextPath() %>/index.jsp">首页</a>
		</td>
		<td bgcolor=#DDDDDD align=center>
			<a href="<%=request.getContextPath() %>/search/search.jsp">搜索</a>
		</td>
		<td bgcolor=#DDDDDD align=center>文档</td>
		<td bgcolor=#DDDDDD align=center>下载</td>
		<td bgcolor=#DDDDDD align=center><%="您尚未登录"%></td>
		<td bgcolor=#DDDDDD align=center>
			<a href="<%=request.getContextPath() %>/user/login.jsp">登录</a>
		</td>
		<td bgcolor=#DDDDDD align=center>
			<a href="<%=request.getContextPath() %>/user/signup.jsp">注册</a>
		</td>
	</tr>
</table>