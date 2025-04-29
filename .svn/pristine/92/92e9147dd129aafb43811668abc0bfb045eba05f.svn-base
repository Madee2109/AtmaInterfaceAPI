package org.bte.core.person.staff;

import java.util.List;
import java.util.Map;



public class StaffManagerImpl implements StaffManager {
	
	StaffDAO staffDAO = new StaffDAOImpl();
	public boolean saveStaffMtr(Map<String,Object> map){
		return staffDAO.saveStaffMtr(map);
	}
	
	public List<StaffDTO> getStaffMtr (Map<String,Object> map){
		return staffDAO.getStaffMtr(map);
	}


	
	public List getMenuItemPermission(int staff_id,int company_id,int org_id){
		return staffDAO.getMenuItemPermission(staff_id, company_id,org_id);
	}
	public List getMenuItemPermissionTemplate(int Templateid){
		return staffDAO.getMenuItemPermissionTemplate(Templateid);
	}
	public boolean savePermissionTemplate(UserTemplateDTO obj){
		return staffDAO.savePermissionTemplate(obj);
	}
	public List<UserTemplateDTO>getsavePermissionTemplate(Map<String,Object> map){
		return staffDAO.getsavePermissionTemplate(map);
	}
}
