package org.bte.framework.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.bte.bean.JSFFacesUtil;
import org.bte.bean.UserContext;
import org.bte.core.utils.HiberbateUtilSessionDTO;
import org.bte.core.utils.HibernateUtil;
public class LifeCycleListener implements PhaseListener{
	private static final Logger logger = Logger.getLogger("org.bte.framework.error");
	 static Logger log = Logger.getLogger(LifeCycleListener.class);	
	public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
}

public void beforePhase(PhaseEvent event) {
	
	FacesContext facesCtx = event.getFacesContext();
    ExternalContext extCtx = facesCtx .getExternalContext();
    HttpSession session = (HttpSession)extCtx .getSession(false); 
    boolean newSession = (session == null) || (session.isNew()); 
    boolean postback = !extCtx.getRequestParameterMap().isEmpty();
    boolean timedout = postback && newSession; 
    if(timedout) { 
    	
    	log.error(" Session Time out do redirect to login page ;");
    	Application app = facesCtx.getApplication(); 
    	ViewHandler viewHandler = app.getViewHandler();
    	facesCtx.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Session Time Out !", ""));
    	UIViewRoot view = viewHandler.createView( facesCtx, "/login/login.xhtml"); 
    	facesCtx.setViewRoot(view); 
    	facesCtx.renderResponse(); 
    	try { 
    		viewHandler.renderView(facesCtx, view); 
    		facesCtx.responseComplete(); 
    	} catch(Throwable t) { 
    		throw new FacesException( "Session timed out", t); 
    	} 
    	
    }
    /*if(event.getPhaseId() ==PhaseId.RESTORE_VIEW ){
		RequestContext.getCurrentInstance().execute("displayProgress()");
	}*/
}

public void afterPhase(PhaseEvent event) {
	
	
	if(event.getPhaseId() ==PhaseId.INVOKE_APPLICATION ){
		Long id = 	Thread.currentThread().getId();
		int opensession=0;
		int opentran=0;
		HiberbateUtilSessionDTO sessionDTO=	HibernateUtil.sessioninformation.get(id);
		if(sessionDTO !=null){
			while(sessionDTO.tranCount>0){
				HibernateUtil.rollbackTransaction();
				logger.error("Auto rollback ---> Open Transaction ");
				opentran++;
			}
			while(sessionDTO.sessionCount>0){
				HibernateUtil.closeSession();
				logger.error("Auto session close ---> Open Session ");
				opensession++;
			}
			if(opensession>0 || opentran >0){
				sendmail(opensession, opentran,sessionDTO);
			}
		}
			if(ExceptionHandler.messageList.get(id) != null){
				
				ErrorMessage msg= ExceptionHandler.messageList.get(id);
				Severity ser = FacesMessage.SEVERITY_ERROR;
				if(msg.getCode_severity() == ErrorCode.code_severity_error){
					
				}else if(msg.getCode_severity() == ErrorCode.code_severity_fatal){
					ser = FacesMessage.SEVERITY_FATAL;
				}else if(msg.getCode_severity() == ErrorCode.code_severity_info){
					ser = FacesMessage.SEVERITY_INFO;
				}else if(msg.getCode_severity() == ErrorCode.code_severity_WARN){
					ser = FacesMessage.SEVERITY_WARN;
				}
				
				if(msg.isCode_insert_table_flag()){
					FacesContext facesContext=FacesContext.getCurrentInstance(); 
					if(facesContext!=null){
						org.bte.bean.UserContext userContext=(org.bte.bean.UserContext) facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}", org.bte.bean.UserContext.class);
						msg.setUser_id(userContext.getUserPersonID());
						msg.setLogin_audit_id(userContext.getLogin_audit_id());
					}
					
					ExceptionHandler.insertError(msg);
				}
				String detail = "";
				if(msg.getCode_msg()!=null && !msg.getCode_msg().equalsIgnoreCase(msg.getCode_summary())){
					detail=msg.getCode_msg();
				}
					 FacesMessage message 	= new FacesMessage(ser, "Code : "+msg.getCode_id()+" "+msg.getCode_summary(), detail);
			         
					 if(msg.getCode_type()==ErrorCode.code_type_message_popup)
				       JSFFacesUtil.showMessageInDialog(message);
					 else if(msg.getCode_type()==ErrorCode.code_type_message_on_page){
						  JSFFacesUtil.showMessageInDialog(message);
					 }
					 else if(msg.getCode_type()==ErrorCode.code_type_growl){
						  JSFFacesUtil.showMessageInDialog(message);
						 }else if(msg.getCode_type()==ErrorCode.code_type_email){
						        
							 sendmail(msg);
						}
					
				        ExceptionHandler.messageList.remove(id);
				return;
			}
		}
	/*if(event.getPhaseId() ==PhaseId.RENDER_RESPONSE){
		RequestContext.getCurrentInstance().execute("hideProgress()");
	}*/
  }

public void sendmail(ErrorMessage msg){}

public void sendmail(int opensession,int opentran,HiberbateUtilSessionDTO sessionDTO){}
}
