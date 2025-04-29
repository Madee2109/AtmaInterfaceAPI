package org.bte.framework.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import  javax.servlet.Filter;

import org.apache.log4j.Logger;
import org.bte.framework.error.Log;




public class BTESecurityFilterIndex implements Filter{
	public void  destroy() {
    }
	//
	 public  void init(FilterConfig config) throws ServletException {
		 //log.info("Filter initialized"); 
	 }

	 public void  doFilter(ServletRequest req, ServletResponse res,
	            FilterChain chain) throws IOException, ServletException {
	 
	       HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        try {
	    	   
	    	   response.sendRedirect(request.getContextPath()+"/login/p_login.jsf");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.exception(e);
			
			}
	 }
	
	 
}
