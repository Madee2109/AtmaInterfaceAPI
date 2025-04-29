package org.bte.core.person.staff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class StaffService  {
	StaffManager staffmgr=new StaffManagerImpl();
	
	public Map<String,Integer> getStaffType(){
		Map<String,Integer> obj = new HashMap<String,Integer>();
		obj.put("Doctor",2);
		obj.put("Staff",3);
		obj.put("Monitor",18);
		return obj;
		
	}
	public boolean saveStaffMtrDIF(Object obj){
		Map<String,Object> map = (Map<String,Object>)obj;
		if(saveStaffMtr( map)){
			
				
				map.put("saveStatus",true);
				map.put("saveMsg", "Saved");
			
			//addAuditList(map, true, "Saved","STAFF" ,AUDIT_OP_INSERT,0);
			return true;
		}
		else{
			map.put("saveStatus",false);
			map.put("saveMsg", "Save Fails");
			//addAuditList(map, false, "Save Fails","STAFF" ,AUDIT_OP_INSERT,0);
			return false;
		}
	}
	public List<StaffDTO> getPersonList(String sugg){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("SAVE_OBJ_PERSON_NAME", sugg);
		return staffmgr.getStaffMtr(map);
	}
	public boolean saveStaffMtr(Map<String,Object> map){
		return staffmgr.saveStaffMtr(map);
	}
	
	public List<StaffDTO> getStaffMtr(Map<String,Object> map){
		return staffmgr.getStaffMtr(map);
	}

	
	public boolean savePermissionTemplate(UserTemplateDTO obj){
		return staffmgr.savePermissionTemplate(obj);
	}
	public List<UserTemplateDTO>getsavePermissionTemplate(Map<String,Object> map){
		return staffmgr.getsavePermissionTemplate(map);
	}
	
	public List getMenuItemPermission(int staff_id,int company_id,int org_id){
		return staffmgr.getMenuItemPermission(staff_id, company_id, org_id);
	}
	
	public List getMenuItemPermissionTemplate(int Templateid){
		return staffmgr.getMenuItemPermissionTemplate(Templateid);
	}
}
