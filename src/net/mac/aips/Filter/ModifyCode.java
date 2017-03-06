package net.mac.aips.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ModifyCode implements Filter {
	
	protected FilterConfig filterConfig;
	
	private String targetEncoding = "UTF-8";

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest srequest = (HttpServletRequest) request;
		try {
			srequest.setCharacterEncoding(this.targetEncoding);
			chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		this.targetEncoding = config.getInitParameter("code");
	}

}
