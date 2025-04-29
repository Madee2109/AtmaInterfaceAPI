package org.bte.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class HiberbateUtilSessionDTO {

	public long threadId;
	public int dbId;
	public String httpSessionId;
	public Session session = null;
	public int sessionCount;
	public int tranCount;
	public boolean rollbackflag;
	private List<String> sessiontravelpath = new ArrayList<String>();
	public HiberbateUtilSessionDTO(long threadId,int dbId,String httpSessionId,Session session){
		
		this.dbId = dbId;
		this.session = session;
		sessionCount = 1;
	}
	public void addsessiontravelpath(String token){
		sessiontravelpath.add(token);
	}
	public List<String> getSessiontravelpath() {
		return sessiontravelpath;
	}
	public void setSessiontravelpath(List<String> sessiontravelpath) {
		this.sessiontravelpath = sessiontravelpath;
	}
	
	
	
}
