package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/secured-servlet")
public class AuthenticationFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("doFilter method is called in "+ this.getClass().getName());
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String ipAddress = request.getRemoteAddr();
		
		if(username.equals("anitha") && password.equals("simplilearn")) {
			System.out.println("user logged in " + ipAddress + " at " + new Date() );
		    // pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<h3> Sorry, you are not authorized to access this resource </h3>");
		}
				
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init method is called in "+ this.getClass().getName());

	}

}
