package org.bte.framework.faces;

import java.util.HashMap;
import java.util.List;

public interface FacesDAO {

	public List<RFTemplateDTO> getRFTemplate(int templateId,boolean default_template);
	public List<RFMenuItemDTO> getRFMenuItem(int userrole);
	public List<RFMenuItemDTO> getRFMenuItem(RFMenuItemDTO searchobj);
	public List<RFPageDTO> getRFPage(RFPageDTO searchobj);
	public List<RFButtonDTO> getRFButton(RFButtonDTO searchobj);
	public String getMenuName(int userRole,int depVersion,String menu_name,int status,HashMap<String,Object> obj);

	public List<RFPageDTO> getRFPageWedjat(String pagename,int position);
	public String getLandingPage(int userrole);
	
	public List<RFDataTable>getDataTable(int userid , String dt_code);
	
	public List<RFDataTableColumn>getDataTableColumn(int userid , String dt_code,int dtid,int dt_add_column_dt_id);
	public List<RFFieldsDTO>getFields(String pagename);
	
}
