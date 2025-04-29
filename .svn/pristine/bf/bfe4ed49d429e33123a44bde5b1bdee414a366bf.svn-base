package org.bte.framework.error;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.faces.application.FacesMessage;

import org.apache.log4j.Logger;
import org.bte.bean.JSFFacesUtil;

public class Log {
	 static Logger log = Logger.getLogger(Log.class);
	 public static void info(int message  ){
		 Throwable th = new Throwable();
			String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
			//System.out.println(filepath+"    "+message);
			log.info(filepath+"    "+message);
	 }
	public static void info(String message  ){
		Throwable th = new Throwable();
		String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
		//System.out.println(filepath+"    "+message);
		log.info(filepath+"    "+message);
	}
	public static void error(String message  ){
		Throwable th = new Throwable();
		String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
		//System.out.println(filepath+"    "+message);
		log.info(filepath+"    "+message);
		//System.err.println(filepath+"    "+message);
	}
	
	public static void exception(Exception e){
		
		/*
		 * StringWriter sw = new StringWriter(); e.printStackTrace(new PrintWriter(sw));
		 * log.error(sw.toString());
		 */
	}
	public static void exceptionShow(Exception e){
		
		
		
		Throwable cause = e.getCause();
		
		
		if(cause==null || cause.getMessage()==null){
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			JSFFacesUtil.showMessage(e.getMessage(),sw.toString(),false);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,  e.getMessage(),sw.toString());
	        
	      
	        return;
		}
		JSFFacesUtil.showMessage(e.getMessage(),cause.toString(),false);
       
	}
}
