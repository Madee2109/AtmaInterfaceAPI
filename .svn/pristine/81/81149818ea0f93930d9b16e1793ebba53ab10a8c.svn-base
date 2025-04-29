package org.bte.framework.faces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;



public abstract class FacesService {
	FacesManager facesManager = new FacesManagerImpl();
	public List<RFTemplateDTO> getRFTemplate(int templateId,boolean default_template){
		return facesManager.getRFTemplate(templateId, default_template);
	}
	public List<RFDataTable>getDataTable(int userid , String dt_code){
		return facesManager.getDataTable(userid,dt_code);
	}
	public List<RFPageDTO> getRFPageWedjat(String page, int position){
		return null;
	}
	public List<RFPageDTO> getRFPage(RFPageDTO searchobj){
		return facesManager.getRFPage(searchobj);
	}	
	
    public List<RFMenuItemDTO> getRFMenuItem(RFMenuItemDTO searchobj){
		 return facesManager.getRFMenuItem(searchobj);
	}
    public List<RFMenuItemDTO> getRFMenuItem(int userrole){
		 return null;
	}
    public String getLandingPage(int userrole){
    	return facesManager.getLandingPage(userrole);
    }
	/*public List<RFPageDTO> getRFPageLayout(Map<String,Object> searchobj){
			return facesManager.getRFPageLayout(searchobj);
	}

	public List<RFPageLayoutDTO> getRFPageLayoutUnit(Map<String,Object> searchobj){
			return facesManager.getRFPageLayoutUnit(searchobj);
	}
    public List<RFThemeDTO> getRFTheme(Map<String, Object> searchobj) {
		 return facesManager.getRFTheme(searchobj);
	}
    public List<SelectItem> getRFThemeSelectItem(Map<String, Object> searchobj){
    	List<SelectItem> list =new ArrayList<SelectItem>();
    	List<RFThemeDTO> rfthemelist = facesManager.getRFTheme(searchobj);
    	if(rfthemelist!=null && rfthemelist.size()>0){
    		for(int i=0;i<rfthemelist.size();i++){
    			list.add(new SelectItem(rfthemelist.get(i).getRf_theme_name(),rfthemelist.get(i).getRf_theme_display()));
			}
    	}
		return list;
    }*/
    
    public List<RFFieldsDTO>getFields(String pagename){
		return facesManager.getFields(pagename);
	}
	public List<RFDataTableColumn>getDataTableColumn(int userid , String dt_code,int dtid,int dt_add_column_dt_id){
		return facesManager.getDataTableColumn(userid, dt_code, dtid,dt_add_column_dt_id);
	}
}
