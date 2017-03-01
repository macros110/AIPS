<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="personCount" class="net.mac.aips.bean.Counter" scope="session" />
<jsp:useBean id="totalCount" class="net.mac.aips.bean.Counter" scope="application"/>
<table width="100%" cellspacing=1 bgcolor=#4169E1>
	<tr>
		<td bgcolor=#4682B4 colspan=7 align=center style="color:#FFFFFF;font-size:25px;height:60px;">
			Copyright 2017 &copyMAC 站内统计   访问次数：<jsp:getProperty 
			name="totalCount" property="count"/>	注册人数：<%=0 %>	在线人数：<%=0 %>	您访问次数：<jsp:getProperty 
			name="personCount" property="count"/>
		</td>		
	</tr>
	<tr></tr>
</table>
</body>
</html>