package org.bte.framework.security;

import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;


public class SessionListDTO {
	
	private String login_id;
	private int user_id;
	private String session_id;
	private String ip_address;
	private HttpSession session;
	private String session_idle_time;
	

	
	private String session_creation_time;
	private String session_max_idle_time;
	private String session_last_accessed_time;
	private String login_name;
	private boolean session_invalidate;
	
	Calendar cal ;
	
	private int login_audit_id;
	public String getSession_creation_time() {
		try {
			session_creation_time="";
			if(session != null){
				cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("IST"));
				cal.setTimeInMillis(session.getCreationTime());
				session_creation_time=(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" 
				            + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":"
				            + cal.get(Calendar.MINUTE));
			}
		} catch (Exception e) {
			
		}
		return session_creation_time;
	}
	public void setSession_creation_time(String session_creation_time) {
		this.session_creation_time = session_creation_time;
	}
	public String getSession_max_idle_time() {
		return session_max_idle_time;
	}
	public void setSession_max_idle_time(String session_max_idle_time) {
		this.session_max_idle_time = session_max_idle_time;
	}
	public String getSession_last_accessed_time() {
		try {
			session_last_accessed_time="";
			if(session != null){
				cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("IST"));
				cal.setTimeInMillis(session.getLastAccessedTime());
				session_last_accessed_time=(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" 
				            + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":"
				            + cal.get(Calendar.MINUTE));
			}
		} catch (Exception e) {
		
		}
		return session_last_accessed_time;
	}
	public void setSession_last_accessed_time(String session_last_accessed_time) {
		this.session_last_accessed_time = session_last_accessed_time;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public boolean isSession_invalidate() {
		return session_invalidate;
	}
	public void setSession_invalidate(boolean session_invalidate) {
		this.session_invalidate = session_invalidate;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	
	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getSession_idle_time() {
		return session_idle_time;
	}
	public void setSession_idle_time(String sessionIdleTime) {
		session_idle_time = sessionIdleTime;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String loginId) {
		login_id = loginId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String sessionId) {
		session_id = sessionId;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ipAddress) {
		ip_address = ipAddress;
	}
	public int getLogin_audit_id() {
		return login_audit_id;
	}
	public void setLogin_audit_id(int login_audit_id) {
		this.login_audit_id = login_audit_id;
	}
	
	

}
