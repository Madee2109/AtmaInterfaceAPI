package org.bte.framework.audit;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;



public class AuditManagerImpl implements AuditManager
{
	public ArrayList get_audit(Integer encid,Integer patid)
	{
		AuditDAO audit=new AuditDAOImpl();
		return audit.get_audit(encid,patid);
	}

	public Boolean save_audit(List<AuditDTO> list)
	{
		AuditDAO audit = new AuditDAOImpl();
		/*AuditDAO audit=new AuditDAOImpl();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UserContext userContext = (UserContext) facesContext.getApplication()
												.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);
		auditlist.setAudit_ipaddress(userContext.getUserIPAddress());
		auditlist.setAudit_machinename(userContext.getUserMachineName());
		auditlist.setAuditUserid(userContext.getUserPersonID()!=null?userContext.getUserPersonID():auditlist.getAuditpersonid());
		*/
		return audit.save_audit(list);
	}

	public List<AuditDTO> operationlist(){
		AuditDAO audit = new AuditDAOImpl();
		return audit.operationlist();
	}

	public List<AuditDTO> viewloglist(Date fromdate, Date todate, int person_id, int activity, int operation, int sort){
		AuditDAO audit = new AuditDAOImpl();
		return audit.viewloglist(fromdate, todate, person_id, activity, operation, sort);
	}
	public List<AuditDTO> viewAuditLogList(HashMap<String, Object> obj){
		AuditDAO audit = new AuditDAOImpl();
		return audit.viewAuditLogList(obj);
	}
	public boolean saveAuditNewSession(List<AuditDTO> list,String serverName){
		AuditDAO audit = new AuditDAOImpl();
		return audit.saveAuditNewSession(list,serverName);
	}
}
