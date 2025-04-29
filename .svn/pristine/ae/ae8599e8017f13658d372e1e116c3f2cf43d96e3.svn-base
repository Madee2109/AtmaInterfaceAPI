package org.bte.bean;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;




@ManagedBean ( name = "ApplicationBean" )
@ApplicationScoped
public class ApplicationBean{

	
	private String applicationName;
	
	private String application_logo;
	public Map<String,String> config = new HashMap<String,String>();
	
	private long session_timeout=0;
	
	private boolean debug_mode = false;
	
	private String inputdateformat;
	private String inputdatetimeformat;
	public ApplicationBean(){
		
		applicationName=FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		application_logo=applicationName+"/login/logo.png";
		//loadCompany();
		
		
		 //loadConfiguration();
			
			 
	}
		public String getApplicationName() {
		return applicationName;
	}


	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	
	public void run() {
		
		
		
	}


	

	public String connectionimage(boolean flag){
		if(flag){
			return "/images/icon-19.png";
		}
		return "/images/offline.jpg";
	}

	


	public long getSession_timeout() {
		return session_timeout;
	}
	public void setSession_timeout(long session_timeout) {
		this.session_timeout = session_timeout;
	}
	public boolean isDebug_mode() {
		return debug_mode;
	}
	public void setDebug_mode(boolean debug_mode) {
		this.debug_mode = debug_mode;
	}
	public String getInputdatetimeformat() {
		return inputdatetimeformat;
	}
	public void setInputdatetimeformat(String inputdatetimeformat) {
		this.inputdatetimeformat = inputdatetimeformat;
	}
	public String getInputdateformat() {
		return inputdateformat;
	}
	public void setInputdateformat(String inputdateformat) {
		this.inputdateformat = inputdateformat;
	}
	public String getApplication_logo() {
		return application_logo;
	}
	public void setApplication_logo(String application_logo) {
		this.application_logo = application_logo;
	}
	
	
}
