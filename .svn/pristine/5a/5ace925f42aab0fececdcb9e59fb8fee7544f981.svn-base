package org.bte.framework.audit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public interface AuditManager 
{
	public List<AuditDTO> viewAuditLogList(HashMap<String, Object> obj);
	 public ArrayList get_audit(Integer encid,Integer patid);
	  
	 public Boolean save_audit(List<AuditDTO> list);
	 public boolean saveAuditNewSession(List<AuditDTO> list,String serverName);
	 public List<AuditDTO> operationlist();
	 
	 public List<AuditDTO> viewloglist(Date fromdate, Date todate, int person_id, int activity, int operation, int sort);
}
