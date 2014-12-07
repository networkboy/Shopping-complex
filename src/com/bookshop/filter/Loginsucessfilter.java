package com.bookshop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.value.CustomValue;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * Servlet Filter implementation class Loginsucessfilter
 */
@WebFilter("/Loginsucessfilter")
public class Loginsucessfilter implements Filter {

	private FilterConfig config=null;
	private String Webroot=null;
	public void init(FilterConfig config) throws ServletException
	{
		this.config=config;
		ServletContext ctx=config.getServletContext();
		Webroot =ctx.getContextPath();
	}
    public Loginsucessfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
       HttpServletRequest request1=(HttpServletRequest)request;
       HttpServletResponse response1=(HttpServletResponse)response;
      
       String uri=request1.getRequestURI();
       request.setCharacterEncoding("GBK");
     
       
       //判断如果没有取到用户信息,就跳转到登陆页面
		CustomValue cv = (CustomValue)((HttpServletRequest) request).getSession().getAttribute("userInfo");

		if(uri.equals(Webroot+"/Login/loginsucess.jsp")&&cv==null){
			((HttpServletResponse)response).sendRedirect(Webroot+"/Mainbook/mainbook.jsp");
		}else{
		   chain.doFilter(request, response);
		}
	}
	
	}

