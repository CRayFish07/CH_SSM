package com.Servlet;

import java.io.*;
import javax.servlet.http.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 防止html注入
 * @author chen
 * @version 1.0
 */
public class HtmlFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		HttpServletRequest httpRequest = (HttpServletRequest)req;
		String reqUrl = httpRequest.getServletPath();
		//输入ccurl不做拦截
		if("/coursefile/addCourseFile.do".equals(reqUrl)||"/coursefile/uplordCourseFile.do".equals(reqUrl)||
				"/paper/submitAnswer.do".equals(reqUrl)){
			chain.doFilter(req, res);
		}else{
			try {
				request = (HttpServletRequest) req;
				response = (HttpServletResponse) res;
			} catch (ClassCastException e) {
				throw new ServletException("non-HTTP request or response");
			}
			HtmlHttpServletRequest hrequest = new HtmlHttpServletRequest(request);
			chain.doFilter(hrequest, response);

		}
		
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}

class HtmlHttpServletRequest extends HttpServletRequestWrapper {

	public HtmlHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (value == null)
			return value;
		value = filter(value);
		return value;
	}

	private String filter(String message) {
		if (message == null)
			return (null);

		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());
	}
}