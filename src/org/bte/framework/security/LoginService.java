package org.bte.framework.security;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;






import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.apache.log4j.Logger;
import org.bte.bean.UserContext;
import org.bte.core.utils.Constants;
import org.bte.core.utils.HibernateUtil;
import org.bte.core.utils.IDSequenceGenerator;
import org.bte.framework.audit.AuditDTO;
import org.bte.framework.audit.AuditService;
import org.bte.framework.error.ErrorCode;
import org.bte.framework.error.ErrorMessage;
import org.bte.framework.error.ExceptionHandler;
import org.bte.framework.security.EncryptionService;
import org.bte.framework.error.Log;


public class LoginService 
{
	private static Logger log = Logger.getLogger(LoginService.class);	
	public static HashMap<String, LoginDTO> listOfSessions = new HashMap<String, LoginDTO>();
	public static HashMap<String, String> baseurl = new HashMap<String, String>();
	

	public static void  recordNavigation(String viewId, LoginDTO loginDTO,int status) {
		
		if(loginDTO.getNav_pageList().size() > 0)
		{
			
			
			 if(loginDTO.getNav_pageList().get(loginDTO.getNav_pageList().size()-1).equals(viewId)){
				return;
			 }
			 AuditDTO audit=new AuditDTO();
			 audit.setAuditActivity(AuditService.AUDIT_PAGE_REDIRECT);
			 audit.setAuditId(loginDTO.getLogin_person_id());
			 audit.setAuditOperation(AuditService.AUDIT_OP_OTHER);
			 audit.setAuditencid(0);
			 audit.setAuditpersonid(loginDTO.getLogin_person_id());
			 audit.setOrg_id(loginDTO.getOrg_id());
			 audit.setLogin_audit_id(loginDTO.getLogin_audit_id());
			 audit.setAuditUserid(loginDTO.getLogin_person_id());
			 audit.setAudit_information("<table><tr><td>redirect_page</td><td>"+viewId+"</td></tr>"
			 									+ "<tr><td>HTTP Status</td> <td>"+status+"</td></tr>"
			 							+ "</table>");
			 AuditService.save_audit(audit);
		}
		
		 loginDTO.getNav_pageList().push(viewId);
	}
	
	public static String getLastRecordedNavigationData(LoginDTO loginDTO){
		String ret = loginDTO.getNav_pageList().pop();
		 ret = loginDTO.getNav_pageList().pop();
		return ret;
	}
	
	
	public static List<SessionListDTO> getSessList(String companyCode) {
		List<SessionListDTO> sessionList = new ArrayList<SessionListDTO>();
		for(Map.Entry<String, LoginDTO> obj:listOfSessions.entrySet()){
			if(obj.getValue().getCompany_code().equals(companyCode)){
			SessionListDTO sess=new SessionListDTO();
			 sess.setIp_address(obj.getValue().getLogin_ip_address()); 
			
			 sess.setSession(obj.getValue().getSession());
			 sess.setSession_id(obj.getValue().getSession().getId());
			 sess.setLogin_name(obj.getValue().getPersonName());
			 sess.setLogin_audit_id(obj.getValue().getLogin_audit_id());
			 sessionList.add(sess);
			}
		}
		return sessionList;
	}
	/*
	public void setSessList(List<SessionListDTO> sessList) {
		this.sessList = sessList;
	}*/

	public static LoginDTO validateLogin (LoginDTO userLoginDTO)
	{
		List<LoginDTO> loginList = null;
		LoginDTO loginDTO=null;
		
		Session dbSession = HibernateUtil.getSession();
		/*
		 * if(dbSession == null){
		 * ExceptionHandler.putError(ErrorCode.error_code_db_link_failure);
		 * userLoginDTO.setError_msg("Check Company Code"); return null; }
		 */
		try{
			 HibernateUtil.beginTransaction();
		String encPass = EncryptionService.encryptPassword(userLoginDTO.getLogin_password());
		log.info("Password:"+encPass);
		String sqlQuery = "SELECT t.`login_id`, t.`login_person_id` , p.person_title,  p.person_fname, p.person_lname ,person_type"
				+ " FROM tb_user t, tb_person_mtr p"
				+ " where  p.person_id=t.login_person_id "
				+ " and t.login_id='"+userLoginDTO.getLogin_id()+"' and t.login_password='"+encPass+"'";
	//	sqlQuery = sqlQuery+" and r.login_person_department=p.department_id ";
		loginList = dbSession.createSQLQuery(sqlQuery).setResultTransformer(Transformers.aliasToBean(LoginDTO.class)).list();
		
		if (loginList.isEmpty())
		{
			ExceptionHandler.putError(ErrorCode.error_code_login_failed);
			userLoginDTO.setError_msg("Check username and password");
			 HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			return null;
		}
		 
		Iterator<LoginDTO> it = loginList.iterator();
		loginDTO = it.next();
		
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		 HttpSession session=(HttpSession)ectx.getSession(true);
		 HttpServletRequest request = (HttpServletRequest)ectx .getRequest();
		 
	String	 information=ectx.getRequestHeaderMap().get("user-agent");
		 try {
			
				 loginDTO.setLogin_ip_address(request.getRemoteAddr());
				 loginDTO.setLogin_ip_machine(InetAddress.getByName(""+request.getRemoteAddr()).getHostName());
			 
		 
		 }
		 catch (UnknownHostException e) {
				Log.exception(e);
			}
		 if(listOfSessions.get(session.getId())==null){
			 listOfSessions.put(session.getId(), loginDTO);
			
			/* SessionListDTO sess=new SessionListDTO();
			 sess.setIp_address(request.getRemoteAddr()); 
			 sess.setSession(session);
			 sess.setSession_id(session.getId());
			 sess.setLogin_id(loginDTO.getLogin_id());
			 sessionList.add(sess);*/
		 }
		 loginDTO.setCompany_code(userLoginDTO.getCompany_code());
			loginDTO.setSession(session);
			loginDTO.setSession_id(session.getId());
			baseurl.remove(session.getId());
			
		String sql ="INSERT INTO tb_audit_login  (`login_audit_id`, `login_person_id`, `login_date`, `login_session_id`, `login_user_agent`"
				+ ",login_ipaddress,login_machinename,login_geolocation) "
				+ " VALUES (?,?,?,?,?,?,?,?)";
	int	id = IDSequenceGenerator.getNextSequenceInt("tb_audit_login");
	Query qry =	 dbSession.createSQLQuery(sql).setParameter(0, id)
		 									.setParameter(1, loginDTO.getLogin_person_id())
		 									.setParameter(2, new Date())
		 									.setParameter(4, information)
		 									.setParameter(3, session.getId())
		 									.setParameter(5, loginDTO.getLogin_ip_address())
		 									.setParameter(6, loginDTO.getLogin_ip_machine())
		 									.setParameter(7, userLoginDTO.getLogin_geolocation());
		 
		 if(qry.executeUpdate()==0){
			 HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
		 }
		 loginDTO.setLogin_audit_id(id);
		 AuditDTO audit=new AuditDTO();
		 audit.setAuditActivity(AuditService.AUDIT_LOGIN);
		 audit.setAuditId(loginDTO.getLogin_person_id());
		 audit.setAuditOperation(AuditService.AUDIT_OP_OTHER);
		 audit.setAuditencid(0);
		 audit.setAuditpersonid(loginDTO.getLogin_person_id());
		 audit.setOrg_id(loginDTO.getOrg_id());
		 audit.setLogin_audit_id(loginDTO.getLogin_audit_id());
		 audit.setAuditUserid(loginDTO.getLogin_person_id());
		 audit.setAudit_information(information);
		 AuditService.save_audit(audit);
		 
		 HibernateUtil.commitTransaction();
		 HibernateUtil.closeSession();
		}catch(Exception e){
			 HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			Log.exception(e);
		}
		
		return loginDTO;
	}
	
	public static boolean changePassword(String userName, String oldPassword, String newPassword, String trnPwd)
	{
		Session dbSession = HibernateUtil.getSession();
		String encPass="";
		String encTrnPass = "";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UserContext userContext = (UserContext) facesContext.getApplication()
												.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
		log.info("Pass"+oldPassword);
		
			encPass = EncryptionService.encryptPassword(oldPassword);
	
		try{
		String sqlQuery = "select login_id " +
						  "from tb_user " +
						  "where login_id = ? and login_password = ?";
		HibernateUtil.beginTransaction();
		

		List loginList = dbSession.createSQLQuery(sqlQuery)
		                     .setParameter(0, userName)
		                     .setParameter(1, encPass)
		                     .setResultTransformer(Transformers.aliasToBean(LoginDTO.class))
		                     .list();
		
		if (loginList.isEmpty())
		{
			HibernateUtil.commitTransaction();
			 HibernateUtil.closeSession();
			return false;
		}
		
		encPass = EncryptionService.encryptPassword(newPassword);
		if(trnPwd!=null && trnPwd.length()>0)
			encTrnPass = EncryptionService.encryptPassword(trnPwd);
		sqlQuery = "update tb_user set login_password = ?, trn_password= ? where login_id = ?";
		if (dbSession.createSQLQuery(sqlQuery)
				 .setParameter(2, userName)
				 .setParameter(0, encPass).setParameter(1, encTrnPass)
				 .executeUpdate() < 1)
		{
			HibernateUtil.rollbackTransaction();
			 HibernateUtil.closeSession();
			return false;
		}
		HibernateUtil.commitTransaction();
		 HibernateUtil.closeSession();
//		dbSession.close();
		return true;
		}catch(Exception e){
			HibernateUtil.rollbackTransaction();
			 HibernateUtil.closeSession();
			Log.exception(e);
			return false;
		}
	}
	
	
	
	
	
	public static boolean checkPassword(String userName, String userPassword)
	{
		Session dbSession = HibernateUtil.getSession();
		String encPass = EncryptionService.encryptPassword(userPassword);
		try{
		String sqlQuery = "select login_id " +
						  "from tb_user " +
						  "where login_id = ? and login_password = ?";
		
		

		List loginList = dbSession.createSQLQuery(sqlQuery)
		                     .setParameter(0, userName)
		                     .setParameter(1, encPass)
		                     .setResultTransformer(Transformers.aliasToBean(LoginDTO.class))
		                     .list();
		
		if (loginList.isEmpty())
		{
			 HibernateUtil.closeSession();
			return false;
		}
		else
		{
			 HibernateUtil.closeSession();
			return true;
		}
		
		
		}catch(Exception e){
			Log.exception(e);
			 HibernateUtil.closeSession();
			return false;
		}
	}
	public static boolean checkPermission(String url, String id){
		Session dbSession = HibernateUtil.getSession();
		
		
		String sqlQuery = "SELECT u.login_id FROM tb_screen_users t, tb_screen s, tb_user u where t.user_login_id=u.user_login_id and t.screen_id=s.screen_id and s.screen_name='"+url+"' and u.login_id='"+id+"'";
		List ss=dbSession.createSQLQuery(sqlQuery).list();
		if(ss.size()>0 && ss.get(0)!=null && ss!=null){
			if(id==ss.get(0).toString()||id.equals(ss.get(0).toString()))
			{
				 HibernateUtil.closeSession();
				return true;
			}
			else
			{
				 HibernateUtil.closeSession();
				return false;
			}
		}
		
		 HibernateUtil.closeSession();
		return false;
	}
	
	public boolean deleteUser(int user_person_id)
	{
		Session dbSession = HibernateUtil.getSession();
		
		
		try {
			HibernateUtil.beginTransaction();
			String sqlQuery="delete from tb_user where login_person_id="+user_person_id+"";
			SQLQuery qry=dbSession.createSQLQuery(sqlQuery);
			if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return false;
			}
			HibernateUtil.commitTransaction();
			 HibernateUtil.closeSession();
			 return true;
			 
			 
		} catch (Exception e) {
		
			HibernateUtil.rollbackTransaction();
			 HibernateUtil.closeSession();
			Log.exception(e);
			return false;
		}
		
	}
	public static boolean checkValidity(){
		/*
		Session dbSession = HibernateUtil.getSession();
		Date sysDate=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String s1=format.format(sysDate);
		
		if(UserContext.Version.equals("Trial")){
			String sql="Select version_expiry_date from tb_app_version_details where version_id=1";
			List ss=dbSession.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(VersionDetailsDTO.class)).list();
			Iterator it=ss.iterator();
			if(it.hasNext()){
				VersionDetailsDTO ver=(VersionDetailsDTO)it.next();
				try{
					
				if(sysDate.after(format.parse(""+ver.getVersion_expiry_date()))){
					return false;
				}
				}catch(Exception e){
					Log.exception(e);
				}
			}
		}
		
		 HibernateUtil.closeSession();*/
		return true;
	}
	
	public static boolean logout(List<SessionListDTO> list){
		
Session dbSession = HibernateUtil.getSession();
		
		
		try {
			HibernateUtil.beginTransaction();
		
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UserContext userContext = (UserContext) facesContext.getApplication()
												.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
		
		
			String sql ="UPDATE tb_audit_login  SET login_logout_by = ? , login_logout_time = ? "
					+ " WHERE login_audit_id = ?";
			for(SessionListDTO ob:list){
				Query qry =	 dbSession.createSQLQuery(sql).setParameter(2, ob.getLogin_audit_id())
			 									.setParameter(0, userContext.getUserPersonID())
			 									.setParameter(1, new Date());
		
			
				if(qry.executeUpdate()==0){
					HibernateUtil.rollbackTransaction();
					HibernateUtil.closeSession();
					return false;
				}
				
			
				HttpSession sess= ob.getSession();
				
				listOfSessions.remove(sess.getId());
				sess.invalidate();
			}
		HibernateUtil.commitTransaction();
		 HibernateUtil.closeSession();
//		dbSession.close();
		
		}catch(Exception e){
			HibernateUtil.rollbackTransaction();
			 HibernateUtil.closeSession();
			Log.exception(e);
			return false;
		}
	
		
		
		return true;
	}
	
	public static boolean logout(){
		
		Session dbSession = HibernateUtil.getSession();
				
				
				try {
					HibernateUtil.beginTransaction();
				
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				UserContext userContext = (UserContext) facesContext.getApplication()
														.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
				AuditDTO audit=new AuditDTO();
				 audit.setAuditActivity(AuditService.AUDIT_LOGOUT);
				 audit.setAuditId(userContext.getUserPersonID());
				 audit.setAuditOperation(AuditService.AUDIT_OP_OTHER);
				 audit.setAuditencid(0);
				 audit.setAuditUserid(userContext.getUserPersonID());
				 audit.setAuditpersonid(userContext.getUserPersonID());
				 audit.setOrg_id(userContext.getOrg_id());
				 audit.setLogin_audit_id(userContext.getLogin_audit_id());
				 AuditService.save_audit(audit);
				
					String sql ="UPDATE tb_audit_login  SET login_logout_by = ? , login_logout_time = ? "
							+ " WHERE login_audit_id = ?";
					Query qry =	 dbSession.createSQLQuery(sql).setParameter(2, userContext.getLogin_audit_id())
					 									.setParameter(0, userContext.getUserPersonID())
					 									.setParameter(1, new Date());
				
					
					if(qry.executeUpdate()==0){
						HibernateUtil.rollbackTransaction();
						HibernateUtil.closeSession();
						return false;
					}
				HibernateUtil.commitTransaction();
				 HibernateUtil.closeSession();
//				dbSession.close();
				
				}catch(Exception e){
					HibernateUtil.rollbackTransaction();
					 HibernateUtil.closeSession();
					Log.exception(e);
					return false;
				}
			
				
				ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
				 HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
				HttpSession sess= request.getSession();
			 listOfSessions.remove(request.getSession().getId());
			 sess.invalidate();
				return true;
			}
	
	
	public static int getUserCount(){
		log.info("No of users:"+listOfSessions.size());
		return listOfSessions.size();
	}
	
	public static boolean validateTransactionPwd(int userId, String trnPwd) {
		Session session = HibernateUtil.getSession();
		boolean ret = false;
		try{
			String pwd = EncryptionService.encryptPassword(trnPwd);
			String sql = "SELECT user_login_id FROM tb_user where trn_password='"+pwd+"' and login_person_id='"+userId+"' ";
			List list = session.createSQLQuery(sql).list();
			if(list.size()>0)
				ret = true;
			HibernateUtil.closeSession();
		}
		catch(Exception e){
			Log.exception(e);
			HibernateUtil.closeSession();
		}
		return ret;
	}
	public static boolean validateTransaction(String userName, String trnPwd,int tranType,int ref_id)
	 {
		Session session = HibernateUtil.getSession();
		boolean ret = false;
		try{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			UserContext userContext = (UserContext) facesContext.getApplication()
													.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
			HibernateUtil.beginTransaction();
			String pwd = EncryptionService.encryptPassword(trnPwd);
			String sql = "SELECT user_login_id FROM tb_user,tb_user_transaction_authorization a where login_person_id=trn_user_id and trn_trantype="+tranType+" and trn_password='"+pwd+"' and login_id='"+userName+"' ";
			List list = session.createSQLQuery(sql).list();
			if(list.size()>0)
				ret = true;
			
			 String sqlStmt = " INSERT INTO tb_user_transaction_authorization_audit (user_name, tran_type, approval_status, date,login_userid,login_ipaddress,ref_id)" +
				" VALUES (?, ?, ?, ?,?,?,?)";
			 Query  sqlQry = session.createSQLQuery(sqlStmt).setParameter(0, userName)
	     										 .setParameter(1, tranType)
												 .setParameter(2, (ret==true?1:0))
												 .setParameter(3,new Date())
												  .setParameter(4,userContext.getUserPersonID())
												   .setParameter(5,"")
												    .setParameter(6,ref_id);
			 if (sqlQry.executeUpdate() == 0) {
					HibernateUtil.rollbackTransaction();
					HibernateUtil.closeSession();
					return false;
				}									 

	
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			
		}
		catch(Exception e){
			Log.exception(e);
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			
		}
		return ret;
	}
	public static boolean changePassword(LoginDTO newUser)
	{
		String error_msg="";
		boolean returnvalue=false;
		Session dbSession = HibernateUtil.getSession();
		if(newUser.getLogin_password()==null || newUser.getLogin_password().trim().isEmpty()) {
			error_msg = "Please enter the User Name;";
		}
		if(newUser.getLogin_confirm_password()==null || (newUser.getLogin_confirm_password().equals(newUser.getLogin_password())==false)) {
			error_msg = "Passwords are mismatched, Kindly verify";
		}
		
			
		try{
		String sqlQuery = "select login_id " +
						  "from tb_user " +
						  "where  login_password = ? AND login_person_id = " +newUser.getLogin_person_id();
		HibernateUtil.beginTransaction();
		
		List s=dbSession.createSQLQuery(sqlQuery).setParameter(0, EncryptionService.encryptPassword(newUser.getLogin_old_password())).list();
		
		
		if(s.size()==0) {
			error_msg="Check Your Old Password";
		}
		if(error_msg.equals(""))
		{
		

		
	
		sqlQuery = "update tb_user set login_password = ? ,user_last_password_change = ? where login_person_id = "+newUser.getLogin_person_id();
		Query qry = dbSession.createSQLQuery(sqlQuery)
				.setParameter(0, EncryptionService.encryptPassword(newUser.getLogin_password()))
				.setParameter(1, new Date());
			if (qry.executeUpdate()==0)
			{
				HibernateUtil.rollbackTransaction();
				 HibernateUtil.closeSession();
				
			}else {
			returnvalue=true;
			}
		}
		HibernateUtil.commitTransaction();
		 HibernateUtil.closeSession();

		
		}catch(Exception e){
			HibernateUtil.rollbackTransaction();
			 HibernateUtil.closeSession();
			Log.exception(e);
			
		}
		newUser.setError_msg(error_msg);
		return returnvalue;
	}
	public static boolean registerUser(LoginDTO newUser)
	{
		boolean returnvalue=false;
		
	Session	session=HibernateUtil.getSession();
		String encPass;
		
		String error_msg="";
		tb_user userobj=new tb_user();
		
		try
   	 	{
			HibernateUtil.beginTransaction();	
			if(newUser.getLogin_password()==null || newUser.getLogin_password().trim().isEmpty()) {
				error_msg = "Please enter the User Name;";
			}
			if(newUser.getLogin_confirm_password()==null || (newUser.getLogin_confirm_password().equals(newUser.getLogin_password())==false)) {
				error_msg = "Passwords are mismatched, Kindly verify";
			}
			
			
			
			String sql1 ="Select login_id from tb_user where login_person_id != ? AND  login_id='"+newUser.getLogin_id()+"'";
			List s=session.createSQLQuery(sql1).setParameter(0, newUser.getLogin_person_id()).list();
			if(s.size()>0) {
				error_msg="Username Already Exists";
			}
			if(error_msg.equals(""))
			{
				
				
		
				
				encPass = EncryptionService.encryptPassword(newUser.getLogin_password());
				userobj.setUser_login_id(newUser.getLogin_person_id());
				userobj.setLogin_id(newUser.getLogin_id());
				userobj.setLogin_password(encPass);
				userobj.setLogin_person_id(newUser.getLogin_person_id());
				userobj.setTrnPwd(EncryptionService.encryptPassword(newUser.getTrnPwd()));
				session.saveOrUpdate(userobj);		
				session.flush();
				session.evict(userobj);
				returnvalue=true;
					
			
			}
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			
    	  }
		  
		  catch(Exception e)
		  {
				 HibernateUtil.rollbackTransaction();
				 HibernateUtil.closeSession();
				 log.fatal(e.getMessage());
				 Log.exception(e);
		  }
		newUser.setError_msg(error_msg);
		return returnvalue;
	}
}
