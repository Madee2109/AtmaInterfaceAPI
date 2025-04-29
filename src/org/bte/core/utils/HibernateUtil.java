package org.bte.core.utils;





import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.bte.bean.UserContext;
import org.bte.framework.error.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public final class HibernateUtil {

	private static Logger log = Logger.getLogger(HibernateUtil.class);	
	
	public static HashMap<Long, String> httpSessions = new HashMap<Long, String>();
	public static  HashMap<String, Connection> connectionmap = new HashMap<String, Connection>();
	public static  HashMap<String, SIGNUP_Util_DTO> connectioninformation = new HashMap<String, SIGNUP_Util_DTO>();
	public static HashMap<Long, HiberbateUtilSessionDTO> sessioninformation=new HashMap<Long, HiberbateUtilSessionDTO>();
	public static boolean bPMSwitch=false;
	public static boolean bPMDetails=false;
	public static boolean log_phase_id=true;
	public static boolean restart = false;
	/*public static final String RESET = "\033[0m";
	 public static final String RED = "\033[0;31m"; 
	*/private static int dbSessionID=0;
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
	private static DateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
	public static String getDateformat(Object obj){
		return dateFormat.format((java.util.Date)obj);
	}
	public static String getDateTimeformat(Object obj){
		return datetimeFormat.format((java.util.Date)obj);
	}
	
	public static String escapeSQLlike(String s){
		s = s.replaceAll("\\\\", "\\\\\\\\");
		s = s.replaceAll("'", "\\\\'");
		s = s.replaceAll("\"", "\\\\\"");
		s = s.replaceAll(" ", "%");
		return s;
	}
	public static String escapeSQL(String s){
		s = s.replaceAll("\\\\", "\\\\\\\\");
		s = s.replaceAll("'", "\\\\'");
		s = s.replaceAll("\"", "\\\\\"");
		
		return s;
	}
	public static void logException(Exception e) {
		// TODO Auto-generated method stub
		Log.exception(e);
	}
	/*public static Session sesobject(){
		Session session = null;
		
		try
		{
			if (session == null){
				SessionFactory sessionFactory = new Configuration().configure("localhost.cfg.xml").buildSessionFactory();
				session =sessionFactory.openSession();
				
			
			}
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
		}
		return session;
	}*/
	/*public static Session getNewSession(){
		Session session = null;

		String ServerName="";
		 if(FacesContext.getCurrentInstance()!=null){
			 	FacesContext facesContext=FacesContext.getCurrentInstance();    	     
				UserContext userContext=(UserContext) facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
				
				ServerName=userContext.getServerName();
		 }
			
		 else{
			 ServerName="localhost";
		 }

		if(sessionMap.get(ServerName)!=null){
			try
			{
				session=sessionMap.get(ServerName).openSession();

			}
			catch(Exception e)
			{
				log.info(e.getMessage());
			}
		}
		else{
			session=HibernateUtil.getSession();
			HibernateUtil.closeSession();
			session=sessionMap.get(ServerName).openSession();
		}
		return session;
	}
*/
	/*public static  void closeNewSession(Session session){
		session.close();
	}
*/
	public static synchronized int getNewDBSessionID()
	{
		dbSessionID = dbSessionID + 1;
		return dbSessionID;
	}
	public static void restartDBSession(String ServerName){
		restart = true;
		
		SessionFactory	sessionFactory = null;
		if (connectioninformation.get(ServerName)!=null)
		{
			List<Timer> listOfTimers = connectioninformation.get(ServerName).listOfTimers;
			if(listOfTimers!=null)
			for(Timer tim:listOfTimers){
				tim.cancel();
			}
			
			sessionFactory =connectioninformation.get(ServerName).sessionFactory;
			 for(Map.Entry<Long, HiberbateUtilSessionDTO> ent:sessioninformation.entrySet()){
				 HiberbateUtilSessionDTO sessionDTO=	ent.getValue();
					
				 Session session=sessionDTO.session;
				 long threadid =ent.getKey(); 
				 
				 session.getTransaction().rollback();
					
					log.info("DB Session ID : "+sessionDTO.dbId +" Transaction Final Rollback .Restart");
				 
				 session.cancelQuery();
				
				
					httpSessions.remove(threadid);
					session.flush();
					session.close();
					//currentSession.set(null);
					
					log.info("DB Session ID : "+sessionDTO.dbId +" Closed. Restart ");
					sessioninformation.remove(threadid);
			 }
			 
			sessionFactory.close();
			
			
		}
		try
		{
			 
			
				Configuration config = new Configuration().configure("localhost.cfg.xml");
				config.getProperty("hibernate.connection.username");
				
					sessionFactory = config.buildSessionFactory();
					SIGNUP_Util_DTO signup =new SIGNUP_Util_DTO(
							config.getProperty("hibernate.connection.url")
							,config.getProperty("hibernate.connection.username"),
							config.getProperty("hibernate.connection.password"));
					
					signup.setSessionFactory(sessionFactory);
					log_phase_id=false;
				//sessionMap.put(ServerName, sessionFactory);
				connectioninformation.put(ServerName, signup);
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			return ;		    	
		}
		restart = false;
	}
	public static synchronized  Session getSession()
	{
		String ServerName="localhost";
		String sessionId="";
		 if(FacesContext.getCurrentInstance()!=null){
			 FacesContext facesContext = FacesContext.getCurrentInstance();
				
			 ExternalContext ectx = facesContext.getExternalContext();
				HttpServletRequest request = (HttpServletRequest)ectx .getRequest();
				
				sessionId=request.getSession().getId();
		 }
		 else{
			 sessionId="android";
		 }
		


		
		
		Throwable th = new Throwable();
		String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
		
		
		//log.info("RequestPath:"+ServerName);
		int dbid=0;
		
		if (connectioninformation.get(ServerName)==null)
		{
			try
			{
				 
				restartDBSession(ServerName);
					
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				log.info(e.getMessage());
				return null;		    	
			}
		}
		
		HiberbateUtilSessionDTO sessionDTO=	sessioninformation.get(Thread.currentThread().getId());
		
		Session session = null;
		try
		{
			if (sessionDTO == null)
			{

				try
				{
					
					session =connectioninformation.get(ServerName).sessionFactory.openSession(); // getting new hibernate session from factory
					dbid = getNewDBSessionID(); //getting a new id for the hibernate session
					 sessionDTO= new HiberbateUtilSessionDTO(Thread.currentThread().getId(), dbid, sessionId,session);
					
					sessioninformation.put(Thread.currentThread().getId(), sessionDTO); //associating the hibernate session
					if (httpSessions.containsValue(sessionId)) {
						log.info("Additional Hibernate Session created for Http Session : "+sessionId);
						sessionDTO.addsessiontravelpath("Additional Hibernate Session created for Http Session : "+sessionId);
					}
					else
						httpSessions.put(Thread.currentThread().getId(), sessionId); //setting the http session ID for the thread
				}
				catch(Exception e)
				{
					e.printStackTrace();
					log.info(e.getMessage());
					return null;	
				}

			
				
				log.info("DB Session ID : "+dbid +" Created. "+filepath);
				sessionDTO.addsessiontravelpath("DB Session ID : "+dbid +" Created. "+filepath);
				
			}
			else
			{	
				session = sessionDTO.session;
				sessionDTO.sessionCount++;
				log.info("DB Session ID : "+sessionDTO.dbId +" incremented : "+sessionDTO.sessionCount+" "+filepath);
				sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" incremented : "+sessionDTO.sessionCount+" "+filepath);
			}
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			return null;	
		}
	
		if(session == null) {
			log.error("Hibernate Session is NULL");
		}

		return session;

	}
	

/*	public static void logMonitorData(HibernateUtilPerfMonDTO perfMon)
	{
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest)ectx .getRequest();
		UserContext userContext = (UserContext) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{UserContext}",UserContext.class);
		if(!bPMSwitch)
			return;
		if(!bPMDetails) {
			if (perfMon.getPm_hib_commit_rollback().contains("BEFORE RESTORE_VIEW 1") || perfMon.getPm_hib_commit_rollback().contains("AFTER RENDER_RESPONSE 6"));
			else
				return;
		}

		Session sessionMonitor = HibernateUtil.getNewSession();
		
		int tranCountLocal=0;
		int tranIDLocal = 0;
		int nestedSessionCountLocal=0;
		int sessionID=0;
		int userID = 0;
		
		long currentTimeInMS = Calendar.getInstance().getTimeInMillis();
		
		String perfMonSQL = "insert into tb_hibernate_perfmon (pm_server_name, pm_http_session, pm_hib_dbsessionid, " +
				"pm_hib_trancount, pm_hib_nestedsessions, pm_hib_commit_rollback, pm_class, pm_method, " +
				"pm_lineno, pm_connection_count, pm_request_url, pm_ip_address, pm_tran_id, pm_user_id, pm_machine_name," +
				" pm_org_id, pm_time_in_ms, pm_thread) " +
				"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		sessionMonitor.getTransaction().begin();
		
		if (tranCount.get(Thread.currentThread().getId()) != null) 
			tranCountLocal = tranCount.get(Thread.currentThread().getId());
		if (nestedSessionCount.get(Thread.currentThread().getId()) != null)
			nestedSessionCountLocal = nestedSessionCount.get(Thread.currentThread().getId());
		if (sessionIDLocal.get(Thread.currentThread().getId()) != null)
			sessionID = sessionIDLocal.get(Thread.currentThread().getId());

		if (userContext.getUserPersonID() != null)
			userID = userContext.getUserPersonID();
		
		
		if (perfMon.getPm_hib_commit_rollback().equals("BEFORE RESTORE_VIEW 1")) {
			if (perfMonPhase.get(Thread.currentThread().getId()) != null) {
				if (currentTimeInMS - perfMonPhase.get(Thread.currentThread().getId()) > 2000) {
					tranIDLocal = ++tranID; //not thread safe
					perfMonTran.put(Thread.currentThread().getId(), tranIDLocal);
				}
			}
			else {
				tranIDLocal = ++tranID; //not thread safe
				perfMonTran.put(Thread.currentThread().getId(), tranIDLocal);
			}
				
		}
		tranIDLocal = perfMonTran.get(Thread.currentThread().getId());
		
		if (perfMon.getPm_hib_commit_rollback().equals("AFTER RENDER_RESPONSE 6")) {
			perfMonPhase.put(Thread.currentThread().getId(), currentTimeInMS);
		}

		sessionMonitor.createSQLQuery(perfMonSQL)
				.setString (0, request.getServerName())
				.setString (1, request.getSession().getId())
				.setInteger(2, sessionID)
				.setInteger(3, tranCountLocal)
				.setInteger(4, nestedSessionCountLocal)
				.setString (5, perfMon.getPm_hib_commit_rollback())
				.setString (6, perfMon.getPm_class())
				.setString (7, perfMon.getPm_method())
				.setInteger(8, perfMon.getPm_lineno())
				.setInteger(9, sessionIDLocal.size())
				.setString (10, request.getRequestURL().toString())
				.setString (11, request.getRemoteHost())
				.setInteger(12, tranIDLocal)
				.setInteger(13, userID)
				.setString (14, userContext.getUserMachineName())
				.setInteger(15, userContext.getOrg_id())
				.setLong(16, currentTimeInMS)
				.setLong(17, Thread.currentThread().getId())
				.executeUpdate();
		
		sessionMonitor.getTransaction().commit();
		sessionMonitor.close();
		
		
	}*/
	public static  void beginTransaction() 
	{
		
		HiberbateUtilSessionDTO sessionDTO=	sessioninformation.get(Thread.currentThread().getId());
		
		Session tranSession = sessionDTO.session;
		Throwable th = new Throwable();
		String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
		
		
		if (sessionDTO.tranCount==0){
			tranSession.getTransaction().begin();
			sessionDTO.tranCount++;
			log.info("DB Session ID : "+sessionDTO.dbId +" Transaction Created: "+filepath);
			sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Transaction Created: "+filepath);
			//DynamicInvocationManagerImpl.tranStatus=true;
		}
		else
		{
			sessionDTO.tranCount++;
			log.info("DB Session ID : "+sessionDTO.dbId+" Transaction Continues:"+sessionDTO.tranCount+" "+filepath);
			sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId+" Transaction Continues:"+sessionDTO.tranCount+" "+filepath);
		}
	}

	public static  void commitTransaction() 
	{
		
		HiberbateUtilSessionDTO sessionDTO=	sessioninformation.get(Thread.currentThread().getId());
		Session tranSession = sessionDTO.session;
		
		Throwable th = new Throwable();
		String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
		
		
		if (sessionDTO.tranCount==1){
			if (sessionDTO.rollbackflag ==false)
			{
				tranSession.getTransaction().commit();
				log.info("DB Session ID : "+sessionDTO.dbId +" Transaction Final Commit "+filepath);
				sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Transaction Final Commit "+filepath);
				sessionDTO.tranCount--;
				//DynamicInvocationManagerImpl.tranStatus=true;
			}
			else
			{
				log.info("DB Session ID : "+sessionDTO.dbId +" Transaction Rollback From Commit "+filepath);
				sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Transaction Rollback From Commit "+filepath);
				rollbackTransaction();
			}
		}else if (sessionDTO.tranCount > 1){
			log.info("DB Session ID : "+sessionDTO.dbId +" Transaction Commit:"+sessionDTO.tranCount+" "+filepath);
			sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Transaction Commit:"+sessionDTO.tranCount+" "+filepath);
			sessionDTO.tranCount--;
		}
	}

	public static boolean isrollbackFlag(){
		HiberbateUtilSessionDTO sessionDTO=	sessioninformation.get(Thread.currentThread().getId());
		
		
		return sessionDTO.rollbackflag;
		
	}
	public static  void rollbackTransaction() 
	{
		HiberbateUtilSessionDTO sessionDTO=	sessioninformation.get(Thread.currentThread().getId());
		Session tranSession = sessionDTO.session;
		Throwable th = new Throwable();
		String filepath ="("+th.fillInStackTrace().getStackTrace()[1].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[1].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[1].getMethodName();
		if (sessionDTO.tranCount == 1){
			tranSession.getTransaction().rollback();
			sessionDTO.tranCount--;
			sessionDTO.rollbackflag=false;
			log.error( "DB Session ID : "+sessionDTO.dbId +" Transaction Final Rollback "+filepath);
			sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Transaction Final Rollback "+filepath);
			//DynamicInvocationManagerImpl.tranStatus=false;
		}
		else if (sessionDTO.tranCount > 1)
		{
			sessionDTO.rollbackflag = true;
			log.error("DB Session ID : "+sessionDTO.dbId +" Transaction Rollback:"+sessionDTO.tranCount+" "+filepath);
			sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Transaction Rollback:"+sessionDTO.tranCount+" "+filepath);
			sessionDTO.tranCount--;
		}
	}

	public static  void closeSession() 
	{
		HiberbateUtilSessionDTO sessionDTO=	sessioninformation.get(Thread.currentThread().getId());
		Session session = sessionDTO.session;
		Throwable th = new Throwable();
		String filepath="";
		int i=1;
		if(th.fillInStackTrace().getStackTrace()[1].getClassName().contains("BTECorePackage")){
			i=2;
		}
		 filepath ="("+th.fillInStackTrace().getStackTrace()[i].getClassName()+".java:"+th.fillInStackTrace().getStackTrace()[i].getLineNumber()+") Method "+th.fillInStackTrace().getStackTrace()[i].getMethodName();
		
		
		if (session == null){
			log.info("DB Session ID : session null : "+filepath);
			
			return;
		}

		if (sessionDTO.sessionCount > 1)
		{
			sessionDTO.sessionCount--;
			
			log.info("DB Session ID : "+sessionDTO.dbId +" count decremented : "+sessionDTO.sessionCount+" "+filepath);
			sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" count decremented : "+sessionDTO.sessionCount+" "+filepath);
			return;
		}
		if (sessionDTO.tranCount > 0)
		{
			
			log.info("ERROR : DB Session ID : "+sessionDTO.dbId +" cannot be closed. It has open transaction "+filepath);
			sessionDTO.addsessiontravelpath("ERROR : DB Session ID : "+sessionDTO.dbId +" cannot be closed. It has open transaction "+filepath);
			return;
		}
		
		httpSessions.remove(Thread.currentThread().getId());
		session.flush();
		session.close();
		sessioninformation.remove(Thread.currentThread().getId());
		
		log.info("DB Session ID : "+sessionDTO.dbId +" Closed. "+filepath);
		sessionDTO.addsessiontravelpath("DB Session ID : "+sessionDTO.dbId +" Closed. "+filepath);
	}  

	public static SIGNUP_Util_DTO getSignUpDetail() 
	{
		
		String ServerName="localhost";
		
		if(FacesContext.getCurrentInstance()!=null){
			
		}
		if(ServerName !=null){
			SIGNUP_Util_DTO signup = connectioninformation.get(ServerName);
			return signup;
		}
		return null;
	}
	
	public static Connection getConnection() 
	{
		
		String ServerName="localhost";
		
		 if(FacesContext.getCurrentInstance()!=null){
				
			
				
		 }
		 if(ServerName !=null){
			 Connection connection = connectionmap.get(ServerName);
			 if(connection == null ){
				 SIGNUP_Util_DTO signup = connectioninformation.get(ServerName);
				 try 
					{
					 String url = signup.getProject_db_url();
					 if(signup.getLog_show_sql().equals("true")){
						 url = url+"?logger=com.mysql.jdbc.log.Slf4JLogger&profileSQL=true&autoReconnect=true";
					 }
						connection = DriverManager.getConnection (url,signup.getProject_db_username(),signup.getProject_db_password());
						log.info("connection success"+connection);
						
						connectionmap.put(ServerName, connection);
					} 
					catch(Exception e) 
					{
						log.error("Reports database failed");
					}
			 }
			 return connection;
		 }
		
		return null;
		
	}
	public static boolean historyTable(String table_name , String key,int value){
		return historyTable( table_name, key, value+"");
	}

	public static boolean historyTable(String table_name, String key, String value) {
		/*
		 * 
		 * 
		 * FacesContext facesContext=FacesContext.getCurrentInstance();
		 * if(facesContext!=null){
		 * 
		 * UserContext userContext = null;
		 * 
		 * userContext=(UserContext)
		 * facesContext.getApplication().evaluateExpressionGet(facesContext,
		 * "#{UserContext}", UserContext.class);
		 * 
		 * 
		 * 
		 * 
		 * Session session=HibernateUtil.getSession(); try {
		 * 
		 * HibernateUtil.beginTransaction(); String sql="  INSERT INTO z_"+table_name
		 * +" SELECT 0,"+userContext.getUserPersonID()
		 * +", CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,"+userContext.getLogin_audit_id()
		 * +",s.* FROM "+table_name +" s WHERE "+key+" = "+value; Query qry =
		 * session.createSQLQuery(sql); if(qry.executeUpdate()==0){
		 * 
		 * 
		 * } HibernateUtil.commitTransaction(); HibernateUtil.closeSession(); return
		 * true; } catch(Exception e) { HibernateUtil.rollbackTransaction();
		 * HibernateUtil.closeSession(); e.printStackTrace();
		 * 
		 * return false; } }
		 * 
		 * 
		 */return false;}
	
}