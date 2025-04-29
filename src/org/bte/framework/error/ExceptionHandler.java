package org.bte.framework.error;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.apache.log4j.Logger;
import org.bte.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class ExceptionHandler {
	
	 /**
	 * 
	 */
	static Logger log = Logger.getLogger(ExceptionHandler.class);
	static  HashMap<Long, ErrorMessage> messageList=new HashMap<Long, ErrorMessage>();
	public static ErrorMessage putError(int code){
	return 	logThreadDetail(code,null,null);
	}
	public static ErrorMessage putError(int code,Exception e){
		return 	logThreadDetail(code,e,null);
	}
	public static ErrorMessage putError(int code,String message){
		return 	logThreadDetail(code,null,message);
	}
	public static ErrorMessage putError(int code,Exception e,String message){
		return 	logThreadDetail(code,e,message);
	}
	private static ErrorMessage logThreadDetail(int code,Exception e,String message){
		
		
		boolean newdetail=false;
		Long id = 	Thread.currentThread().getId();
		if(messageList.get(id) != null){
			ErrorMessage mes1 =	 messageList.get(id);
			
			if(mes1.getCode_id()==code){
				return mes1;
			}
		}
		if(e !=null && ErrorCode.error_code_find_exception == code){
			String ex_message = e.getMessage();
			if(e instanceof org.hibernate.MappingException){
				if(ex_message.contains("Unknown entity")){	
					code =ErrorCode.error_code_sql_exception_Unknown_entity; 
				}
			}else if(e instanceof org.hibernate.exception.SQLGrammarException){
				
					code =ErrorCode.error_code_sql_exception_Table_Missing; 
				
			}
		}
		
		ErrorMessage mes = getErrorDetail(code);
		
		if(messageList.get(id) != null){
		
			ErrorMessage mes1 =	 messageList.get(id);
			
			if(mes1.getCode_severity_level()>mes.getCode_severity_level()){
				mes = mes1;
			}else{
				newdetail = true;
			}
			
		}else{
			newdetail = true;
		}
		if(newdetail){
			messageList.put(id, mes);
			
			if(mes.getCode_log_message()!=null){
				if(mes.getCode_severity() == ErrorCode.code_severity_error){
					log.error(mes.getCode_log_message());
					
				}else if(mes.getCode_severity() == ErrorCode.code_severity_fatal){
					log.fatal(mes.getCode_log_message());
				}else if(mes.getCode_severity() == ErrorCode.code_severity_info){
					log.info(mes.getCode_log_message());
				}else if(mes.getCode_severity() == ErrorCode.code_severity_WARN){
					log.warn(mes.getCode_log_message());
				}
			}
			if(message!=null){
				if(mes.getCode_severity() == ErrorCode.code_severity_error){
					log.error(message);
					
				}else if(mes.getCode_severity() == ErrorCode.code_severity_fatal){
					log.fatal(message);
				}else if(mes.getCode_severity() == ErrorCode.code_severity_info){
					log.info(message);
				}else if(mes.getCode_severity() == ErrorCode.code_severity_WARN){
					log.warn(message);
				}
			}
			if(e !=null && mes.isCode_exception_log_flag()){
				if(mes.getCode_severity() == ErrorCode.code_severity_error){
					log.error(e.getMessage());
					Log.exception(e);
				}else if(mes.getCode_severity() == ErrorCode.code_severity_fatal){
					log.fatal(e.getMessage());
					Log.exception(e);
				}else if(mes.getCode_severity() == ErrorCode.code_severity_info){
					log.info(e.getMessage());
					Log.exception(e);
				}else if(mes.getCode_severity() == ErrorCode.code_severity_WARN){
					log.warn(e.getMessage());
					Log.exception(e);
				}
			}
			
			if(mes.isCode_thread_detail_log_flag()){
				Throwable th = new Throwable();
				for( StackTraceElement ele:  th.fillInStackTrace().getStackTrace()){
					log.info("Class:"+ele.getClassName() +";Method:"+ele.getMethodName()+";Line: "+ele.getLineNumber());
				}
			}else if(mes.isCode_thread_log_flag()){
				Throwable th = new Throwable();
				for(int i=2 ; th.fillInStackTrace().getStackTrace().length>i && i<5;i++){
					 StackTraceElement ele = th.fillInStackTrace().getStackTrace()[i];
					log.info("Class:"+ele.getClassName() +";Method:"+ele.getMethodName()+";Line: "+ele.getLineNumber());
				}
			}
		}
		return mes;
	}
	
	
	private static ErrorMessage getErrorDetail(int code)
	{
		List<ErrorMessage> letterparamlist=null;
		try
		{

			Session session = HibernateUtil.getSession();
			if(session==null){
				ErrorMessage errormessage =	new ErrorMessage();
				errormessage.setCode_id(code);
				errormessage.setCode_summary("Error");
				errormessage.setCode_msg("Check DB Connection");
				errormessage.setCode_severity(ErrorCode.code_severity_fatal);
				return errormessage;
			}
			String sql ="SELECT code_id , code_type , code_msg , code_summary , code_severity ,code_severity_level"
					+ ",code_thread_detail_log_flag,code_thread_log_flag,code_log_message,code_exception_log_flag,code_insert_table_flag "
					+ " FROM tb_notifocation_code WHERE code_id ="+code+" ";
			letterparamlist=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ErrorMessage.class)).list();
			
			
			HibernateUtil.closeSession();
		}
		catch(Exception e)
		{
			HibernateUtil.closeSession();
			log.fatal(e.getMessage());
		}
		if(letterparamlist!=null && letterparamlist.size()>0){
			return letterparamlist.get(0);
		}else{
			ErrorMessage errormessage =	new ErrorMessage();
			errormessage.setCode_id(code);
			errormessage.setCode_summary("Contact Admin");
			errormessage.setCode_msg("Contact Admin");
			errormessage.setCode_severity(ErrorCode.code_severity_WARN);
			errormessage.setCode_type(ErrorCode.code_type_growl);
			return errormessage;
		}
		
	}
	public  static List<ErrorMessage> getErrorDetail()
	{
		List<ErrorMessage> letterparamlist=null;
		try
		{

			Session session = HibernateUtil.getSession();
			
			String sql ="SELECT code_id , code_type , code_msg , code_summary , code_severity ,code_severity_level"
					+ ",code_thread_detail_log_flag,code_thread_log_flag,code_log_message,code_exception_log_flag,code_insert_table_flag "
					+ " FROM tb_notifocation_code ";
			letterparamlist=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ErrorMessage.class)).list();
			
			
			HibernateUtil.closeSession();
		}
		catch(Exception e)
		{
			HibernateUtil.closeSession();
			Log.exception(e);
		}
		return letterparamlist;
		
	}
	public  static void insertError(ErrorMessage msg)
	{
		try
		{

			Session session = HibernateUtil.getSession();
			if(session==null){
				
				return ;
			}
			HibernateUtil.beginTransaction();
			String sql ="INSERT  INTO  tb_notification (not_code,not_msg,added_by,added_date,login_audit_id) VALUES (?,?,?,?,?)";
			Query qry = session.createSQLQuery(sql).setParameter(0, msg.getCode_id())
					   .setParameter(1, msg.getCode_msg())
					   .setParameter(2, msg.getUser_id())
					   .setParameter(3, new Date())
					   .setParameter(4, msg.getLogin_audit_id());
				if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return;
				}

			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
		}
		catch(Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			
		}
		
	}
}
