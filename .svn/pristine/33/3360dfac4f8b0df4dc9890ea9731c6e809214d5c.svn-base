package org.bte.framework.audit;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Map;



public interface AuditDAO 
{
	public ArrayList get_audit(Integer encid,Integer patid);

	public Boolean save_audit(List<AuditDTO> list);

	public List<AuditDTO> operationlist();

	public List<AuditDTO> viewloglist(Date fromdate, Date todate, int person_id, int activity, int operation, int sort);
	public List<AuditDTO> viewAuditLogList(Map<String, Object> obj);
	public boolean saveAuditNewSession(List<AuditDTO> list,String serverName);
}
