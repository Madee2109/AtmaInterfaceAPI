package org.bte.framework.audit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bte.bean.UserContext;
import org.bte.core.utils.CodeList;
import org.bte.framework.error.Log;






public class AuditService {

	static public int AUDIT_LOGIN=1;
	static public int AUDIT_LOGOUT=2;
	static public int AUDIT_PAGE_REDIRECT=3;
	
	
	static public int AUDIT_OP_INSERT=1;

	static public int AUDIT_OP_UPDATE=2;

	static public int AUDIT_OP_DELETE=3;

	static public int AUDIT_OP_PAY=4;
	
	static public int AUDIT_OP_OTHER = 7;
	
	public static boolean save_audit(AuditDTO obj)
	{
		List<AuditDTO> list  = new ArrayList<AuditDTO>();
		list.add(obj);
		AuditManager audit = new AuditManagerImpl();
		return audit.save_audit(list);
	}
	public static boolean save_audit(int auditoperation , String activity , int auditId,String information)
	{
		AuditDTO dto = new AuditDTO();
		dto.setActivity(activity);
		dto.setAuditActivity(CodeList.getCodeFromLabel("AUDIT_ACTIVITY", activity));
		dto.setAuditId(auditId);
		dto.setAudit_information(information);
		if(FacesContext.getCurrentInstance()!=null){
			FacesContext facesContext= FacesContext.getCurrentInstance();
			ExternalContext ectx = FacesContext.getCurrentInstance()
					.getExternalContext();
			HttpSession httpsession = (HttpSession) ectx.getSession(true);
			HttpServletRequest request = (HttpServletRequest) ectx
					.getRequest();
			
			dto.setAudit_ipaddress(request.getRemoteAddr());
			try {
				dto.setAudit_machinename(InetAddress.getByName(
						"" + request.getRemoteAddr()).getHostName());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				Log.exception(e);
			}
			dto.setAudit_loginsession(httpsession.getId());
	  	     
			UserContext userContext = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);    	 
			dto.setOrg_id(userContext.getOrg_id());
			dto.setAuditUserid(userContext.getUserPersonID());
		
		}
		List<AuditDTO> list  = new ArrayList<AuditDTO>();
		list.add(dto);
		AuditManager audit = new AuditManagerImpl();
		return audit.save_audit(list);
	}
	public static boolean save_audit(int auditoperation , String activity , int auditId)
	{
		AuditDTO dto = new AuditDTO();
		dto.setActivity(activity);
		dto.setAuditActivity(CodeList.getCodeFromLabel("AUDIT_ACTIVITY", activity));
		dto.setAuditId(auditId);
		
		if(FacesContext.getCurrentInstance()!=null){
			FacesContext facesContext= FacesContext.getCurrentInstance();
			ExternalContext ectx = FacesContext.getCurrentInstance()
					.getExternalContext();
			HttpSession httpsession = (HttpSession) ectx.getSession(true);
			HttpServletRequest request = (HttpServletRequest) ectx
					.getRequest();
			
			dto.setAudit_ipaddress(request.getRemoteAddr());
			try {
				dto.setAudit_machinename(InetAddress.getByName(
						"" + request.getRemoteAddr()).getHostName());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				Log.exception(e);
			}
			dto.setAudit_loginsession(httpsession.getId());
	  	     
			UserContext userContext = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);    	 
			dto.setOrg_id(userContext.getOrg_id());
			dto.setAuditUserid(userContext.getUserPersonID());
		
		}
		List<AuditDTO> list  = new ArrayList<AuditDTO>();
		list.add(dto);
		AuditManager audit = new AuditManagerImpl();
		return audit.save_audit(list);
	}
	public boolean save_audit(List<AuditDTO> list)
	{
		AuditManager audit = new AuditManagerImpl();
		return audit.save_audit(list);
	}
	/*public boolean saveAuditDIF(Object obj){
		Map<String,Object> map=(Map<String,Object>) obj;
		List<AuditDTO> saveobjlist=(List<AuditDTO>) map.get(Constants.SAVE_OBJ_TB_AUDIT);
		javax.faces.context.FacesContext facesContext = javax.faces.context.FacesContext.getCurrentInstance();
		UserContext userContext = (UserContext) facesContext.getApplication()
												.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
		String ip =null;
		String  sessionId = null;
		String machine=null;
		try{
			ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
			 HttpServletRequest request = (HttpServletRequest)ectx .getRequest();
			 sessionId = request.getSession().getId();
			 ip=request.getRemoteAddr();
		 machine=InetAddress.getByName(""+request.getRemoteAddr()).getHostName();
		 }
		 catch(UnknownHostException e){
			 Log.exception(e);
		 }
		for(int i=0;i<saveobjlist.size();i++){
			saveobjlist.get(i).setAudit_ipaddress(ip);
			saveobjlist.get(i).setAudit_machinename(machine);
			saveobjlist.get(i).setAuditUserid(userContext.getUserPersonID());
			saveobjlist.get(i).setOrg_id(userContext.getOrg_id());
			saveobjlist.get(i).setAuditDate(new Date());
			saveobjlist.get(i).setAudit_loginsession(sessionId);
		}
		
		return save_audit(saveobjlist);
	}*/
	public List<AuditDTO> viewAuditLogList(HashMap<String, Object> obj){
		AuditManager audit = new AuditManagerImpl();
		return audit.viewAuditLogList(obj);
	}
	public boolean saveAuditNewSession(List<AuditDTO> list,String serverName){
		AuditManager audit = new AuditManagerImpl();
		return audit.saveAuditNewSession(list,serverName);
	}
	
	public static void addAuditList(boolean saveStatus,String saveMsg,int auditact,int auditoperation,int auditId){
		
			AuditDTO dto = new AuditDTO();
			dto.setAudit_information(saveMsg);
			dto.setAudit_save_status(saveStatus?1:0);
			dto.setAuditId(auditId);
			dto.setAuditActivity(auditact);
			dto.setAuditOperation(auditoperation);
			if(FacesContext.getCurrentInstance()!=null){
				FacesContext facesContext= FacesContext.getCurrentInstance();
				ExternalContext ectx = FacesContext.getCurrentInstance()
						.getExternalContext();
				HttpSession httpsession = (HttpSession) ectx.getSession(true);
				HttpServletRequest request = (HttpServletRequest) ectx
						.getRequest();
				
				dto.setAudit_ipaddress(request.getRemoteAddr());
				try {
					dto.setAudit_machinename(InetAddress.getByName(
							"" + request.getRemoteAddr()).getHostName());
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					Log.exception(e);
				}
				dto.setAudit_loginsession(httpsession.getId());
		  	     
				UserContext userContext = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);    	 
				dto.setOrg_id(userContext.getOrg_id());
				dto.setAuditUserid(userContext.getUserPersonID());
			
			}
			
			AuditService auditservice = new AuditService();
			auditservice.save_audit(dto);
		
		
	}
	
	
	public  void addAuditList(boolean saveStatus,String saveMsg,String auditAct,int auditoperation,int auditId){
		addAuditList( saveStatus, saveMsg, CodeList.getCodeFromLabel("AUDIT_ACTIVITY", auditAct), auditoperation,auditId);
	}
}
