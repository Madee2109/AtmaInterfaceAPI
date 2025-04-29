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




public class BTESecurityFilter implements Filter{
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
	        String url = request.getServletPath();
	        HttpSession session =  request.getSession();
	       try {
	    	   
	    	   
	    	 	   
		    	 
						LoginDTO id=LoginService.listOfSessions.get(request.getSession().getId());
						if(id==null){
							
							Log.error("SecurityFilter ----------------->"+url+"------>"+request.getSession().getId());
							 response.sendRedirect(request.getContextPath()+"/login/p_login.jsf");
							// LoginService.baseurl.put(request.getSession().getId(),url+"?"+request.getQueryString());
							// req.getRequestDispatcher("/login/p_login.jsf").forward(req, response);
							 return;
						 }else if(url.endsWith(".jsf") || url.endsWith(".xhtml")) {
							
						 }else if(url.equals("/user/home")) {
							 req.getRequestDispatcher("/pages/home.jsf").forward(req, response);
						 }else if(url.equals("/wsrequestview")) {
							 req.getRequestDispatcher("/pages/wsReqView.jsf").forward(req, response);
						 }else if(url.equals("/apilist")) {
							 req.getRequestDispatcher("/pages/apilist.jsf").forward(req, response);
						 }else if(url.equals("/testrun")) {
							 req.getRequestDispatcher("/pages/apirun.jsf").forward(req, response);
						 }else if(url.startsWith("/apidetails/")) {
							 forward(request, response, "/apidetails/", "/pages/apidetail.jsf?service_id=", url);
							 //req.getRequestDispatcher("/pages/apilist.jsf").forward(req, response);
						 }else if(url.startsWith("/apirun/")) {
							 forward(request, response, "/apirun/", "/pages/apirun.jsf?service_ex_id=", url);
							 //req.getRequestDispatcher("/pages/apilist.jsf").forward(req, response);
						 }else {
							// chain.doFilter(req, res);
						 }
						
							 chain.doFilter(req, res);
							
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
	 }
	public void forward(ServletRequest req,HttpServletResponse response,String replace1,String forward1,String url) throws ServletException, IOException {
		
		url = url.replace(replace1, "");
		System.out.println(url);
		url = forward1+url;
		System.out.println(url);
		 req.getRequestDispatcher(url).forward(req, response);
			
	}
	 
}
