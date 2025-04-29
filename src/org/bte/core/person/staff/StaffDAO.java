package org.bte.core.person.staff;

import java.util.List;
import java.util.Map;



public interface StaffDAO {
	
	public boolean saveStaffMtr(Map<String,Object> map);
	
	public List<StaffDTO> getStaffMtr(Map<String,Object> map);

	public List getMenuItemPermission(int staff_id,int company_id,int org_id);
	public List getMenuItemPermissionTemplate(int Templateid);
	public boolean savePermissionTemplate(UserTemplateDTO obj);
	public List<UserTemplateDTO>getsavePermissionTemplate(Map<String,Object> map);
}
