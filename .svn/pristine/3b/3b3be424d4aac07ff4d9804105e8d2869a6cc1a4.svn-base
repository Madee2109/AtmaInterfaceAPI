package org.bte.framework.ws;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.shaded.commons.io.IOUtils;
import org.primefaces.shaded.json.JSONObject;

import  javax.servlet.Filter;



public class BTEWSSecurityFilter implements Filter{
	
	public void  destroy() {
    }
	//
	 public  void init(FilterConfig config) throws ServletException {
		 //log.info("Filter initialized"); 
	 }

	 public void  doFilter(ServletRequest req, ServletResponse res,
	            FilterChain chain) throws IOException, ServletException {
	 
		 
		/*
		 * HttpServletRequest request = (HttpServletRequest) req; HttpServletResponse
		 * response = (HttpServletResponse) res;
		 */ 
	        
	       try {
				//log.info(url);
	    	   
	    	  BTEWSRun.run( req,res);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	 
}
