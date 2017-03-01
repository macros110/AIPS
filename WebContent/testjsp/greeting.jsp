<%@page import="java.util.Calendar"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>欢迎页面</title>
		<meta http-equiv="pragma" content="no-cache">		
		<meta http-equiv="cache-control" content="no-cache">		
		<meta http-equiv="expires" content="0">		
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">		
		<meta http-equiv="description" content="This is my page">		
	</head>
	<body>
		<table>
			<tr>
				<td><%= greeting %></td>
			</tr>
		</table>
	</body>
</html>