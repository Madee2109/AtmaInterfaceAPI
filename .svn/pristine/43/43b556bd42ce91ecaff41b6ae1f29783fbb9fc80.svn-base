package org.bte.framework.faces;

import java.util.List;




public class FacesManagerImpl implements FacesManager{

	FacesDAO facesDAO = new FacesDAOImpl();
	public List<RFMenuItemDTO> getRFMenuItem(int userrole){
		return facesDAO.getRFMenuItem(userrole);
	}
	public List<RFMenuItemDTO> getRFMenuItem(RFMenuItemDTO searchobj){
		return facesDAO.getRFMenuItem(searchobj);
	}
	public List<RFPageDTO> getRFPage(RFPageDTO searchobj){
		return facesDAO.getRFPage(searchobj);
	}
	public List<RFButtonDTO> getRFButton(RFButtonDTO searchobj){
		return facesDAO.getRFButton(searchobj);
	}
	public List<RFTemplateDTO> getRFTemplate(int templateId,boolean default_template){
		return facesDAO.getRFTemplate(templateId, default_template);
	}
	public List<RFPageDTO> getRFPageWedjat(String pagename,int position){
		return facesDAO.getRFPageWedjat(pagename, position);
	}
	public String getLandingPage(int userrole) {
		return facesDAO.getLandingPage(userrole);
	}
	
	public List<RFDataTable>getDataTable(int userid , String dt_code){
		return facesDAO.getDataTable(userid,dt_code);
	}
	public List<RFFieldsDTO>getFields(String pagename){
		return facesDAO.getFields(pagename);
	}
	public List<RFDataTableColumn>getDataTableColumn(int userid , String dt_code,int dtid,int dt_add_column_dt_id){
		return facesDAO.getDataTableColumn(userid, dt_code, dtid,dt_add_column_dt_id);
	}
}
