package net.mac.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.log("执行doGet方法");
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.log("执行doPost方法");
		execute(request, response);
	}
	
	@Override
	public long getLastModified(HttpServletRequest req) {
		this.log("执行getLastModified方法");
		return -1;
	}
	
	private void execute(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String reqURI = req.getRequestURI();
		String method = req.getMethod();
		this.log(method);
		String param = req.getParameter("param");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//3WC//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("	<HEAD><TITLE>First Servlet</TITLE></HEAD>");
		out.println("	<BODY>");
		out.println("	以" + method + "方式访问该页面。取到的param参数为:"+param+"<br/>");
		out.println("	<form action='"+reqURI+"' method='get'>"
				+ "<input type='text' name='param' value='param string'>"
				+ "<input type='submit' value='以GET方式提交到页面'"+reqURI+"></form>");
		out.println("	<form action='"+reqURI+"' method='post'>"
				+ "<input type='text' name='param' value='param string'>"
				+ "<input type='submit' value='以POST方式提交到页面'"+reqURI+"></form>");
		out.println("	<script>document.write('本页面最后的更新时间'+document.lastModified);</script>");
		out.println("	</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
