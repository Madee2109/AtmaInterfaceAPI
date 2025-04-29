package org.bte.framework.faces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.bte.core.utils.HibernateUtil;
import org.bte.framework.error.Log;

public class FacesDAOImpl implements FacesDAO {

	private  Logger log = Logger.getLogger(FacesDAOImpl.class);
	Session session;
	
	public List<RFFieldsDTO>getFields(String pagename){

		List<RFFieldsDTO> rfMenuItemDTO = null;

		try {
			String pagename1="";
			if(pagename.contains(".jsf")) {
				pagename1 = pagename.replace(".jsf", ".xhtml");
			}else if(pagename.contains(".xhtml")) {
				pagename1 = pagename.replace(".xhtml", ".jsf");
			}
			pagename = pagename.replace(".jsf", "");
			session=HibernateUtil.getSession();
			String sql=" SELECT rf_fields_id,rf_fields_key,rf_fields_validator_type,f.rf_fields_component_id,rf_fields_add_flag,rf_fields_parrent_id,rf_fields_isleaf,rf_fields_component_class "
					+ ",rf_fields_default_flag,rf_fields_default_value_expression,rf_fields_default_value_condition,rf_fields_setmethod,rf_fields_value_class "
					+ ",rf_fields_add_style_script"
					+ " FROM tb_rf_fields f,tb_rf_page,tb_rf_fields_component_mtr c  "
					+ " WHERE f.rf_fields_component_id = c.rf_fields_component_id AND  erp_pageid = rf_page_id AND rf_fields_status = 1 AND (erp_pagename =? OR erp_pagename =?) "
					+ " ORDER BY rf_fields_seq ";
			
			
				rfMenuItemDTO=session.createSQLQuery(sql).setParameter(0, pagename).setParameter(1, pagename1)
						.setResultTransformer(Transformers.aliasToBean(RFFieldsDTO.class)).list();
				sql = "SELECT rf_fields_att_name,rf_fields_att_class,rf_fields_att_type,rf_fields_att_value_expression "
						+ " FROM tb_rf_fields_attributes_mtr a, tb_rf_fields_attributes_value v  "
						+ " WHERE a.rf_fields_att_id = v.rf_fields_att_id AND rf_fields_id = ? AND rf_fields_att_value_status = 1 ";
				for(RFFieldsDTO field:rfMenuItemDTO){
					
					
				List<RFFieldsAttDTO>	ss=session.createSQLQuery(sql).setParameter(0, field.getRf_fields_id())
							.setResultTransformer(Transformers.aliasToBean(RFFieldsAttDTO.class)).list();
				field.setTaglist(ss);
				}
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			e.printStackTrace();
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	
	}
	public List<RFDataTableColumn>getDataTableColumn(int userid , String dt_code,int dtid,int dt_add_column_dt_id){

		List<RFDataTableColumn> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql=" SELECT column_id,column_code,column_header,column_seq,column_visible,column_style_class,column_style"
					+ ",column_sortable,column_filterable,column_width,column_sortBy,column_filterBy,column_filterMatchMode,column_resizable"
					+ ",column_exportable,column_value_exp,column_converter,column_class,column_type,column_footer_calculation,column_method_update,column_value "
					+ ",column_footer_exp,column_footer_exp_rendered ,column_action ,column_img,column_icon,column_method_exp,column_method_exp_param"
					+ ",column_method_onclick,column_method_oncomplete,column_xls_pattern "
					+ " FROM tb_rf_datatable_column WHERE 1=1 ";
			if(dt_code!=null) {
				sql = sql+" AND dt_code ='"+dt_code+"'";
			}
			if(dtid>0 && dt_add_column_dt_id>0) {
				sql = sql+" AND ( dt_id ='"+dtid+"' OR dt_id ="+dt_add_column_dt_id+" )";
			}else{
				sql = sql+" AND dt_id ="+dtid;
			}
			sql = sql+" ORDER BY column_seq";
				rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFDataTableColumn.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			e.printStackTrace();
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	
	}
	public List<RFDataTable>getDataTable(int userid , String dt_code){

		List<RFDataTable> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="SELECT dt_id, `dt_code`, `dt_rows`, `dt_paginator`, `dt_lazy`, `dt_stickyHeader`,dt_refresh,dt_refresh_action,dt_frozenColumns,dt_add_column_dt_id"
					+ ",dt_header_text,dt_div_style,dt_report_xls"
					+ " FROM tb_rf_datatable WHERE dt_code ='"+dt_code+"'";
			
				rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFDataTable.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	
	}
	public List<RFTemplateDTO> getRFTemplate(int templateId,boolean default_template){

		List<RFTemplateDTO> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="SELECT `rf_template_id`, `rf_template_name`, `rf_template_skin`, `rf_template_css`, `rf_template_page`, `rf_template_default` "
					+ " FROM tb_rf_template WHERE 1=1 ";
			
			if(default_template){
				sql=sql+" AND `rf_template_default` = 1";
			}
			if(templateId>0){
				sql=sql+" AND `rf_template_id` = "+templateId;
			}
			
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFTemplateDTO.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	
	}
	
	public List<RFMenuItemDTO> getRFMenuItem(int userrole)
	{
		List<RFMenuItemDTO> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="";
			sql=sql+" SELECT menu_item_icon, erp_pageurl AS menu_item_page_name , mi.`menu_item_id`, mi.`menu_item_for_refid`, mi.`menu_item_dep_version`, mi.`menu_item_value`, mi.`menu_item_page`," +
							" mi.`menu_item_home_page`, mi.`menu_item_component_id`, mi.`menu_item_status`, mi.`menu_item_action`, mi.`menu_item_parent_id`," +
							" mi.`menu_item_leaf`, mi.`menu_item_order`, mi.`menu_item_default`,mi.`menu_item_ui_id`, mi.`menu_item_style`," +
							" mi.`menu_item_submit_mode`,mi.`menu_item_bypassUpdates`, mi.`menu_item_oncomplete`, mi.`menu_item_reRender`, mi.`menu_item_rendered` " +
					" FROM tb_rf_menuitem mi ,tb_rf_page  WHERE   mi.`menu_item_status`= 1  AND mi.`menu_item_for`= 1 AND  mi.`menu_item_page` = erp_pageid ";
			
				sql=sql+" AND mi.`menu_item_for_refid`= "+userrole;
			
			sql=sql+" ORDER BY mi.`menu_item_order`";
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFMenuItemDTO.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	}
	public List<RFMenuItemDTO> getRFMenuItem(RFMenuItemDTO searchobj)
	{
		List<RFMenuItemDTO> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="";
			sql=sql+" SELECT menu_item_column,menu_item_icon, mi.`menu_item_id`, mi.`menu_item_for_refid`, mi.`menu_item_dep_version`, mi.`menu_item_value`, mi.`menu_item_page`,"
							+ "(SELECT erp_pagename FROM tb_rf_page WHERE menu_item_page = erp_pageid ) AS menu_item_page_name , " +
							" mi.`menu_item_home_page`, mi.`menu_item_component_id`, mi.`menu_item_status`, mi.`menu_item_action`, mi.`menu_item_parent_id`," +
							" mi.`menu_item_leaf`, mi.`menu_item_order`, mi.`menu_item_default`,mi.`menu_item_ui_id`, mi.`menu_item_style`," +
							" mi.`menu_item_submit_mode`,mi.`menu_item_bypassUpdates`, mi.`menu_item_oncomplete`, mi.`menu_item_reRender`, mi.`menu_item_rendered` "
							+ ", ifnull((SELECT MAX(c.menu_item_column)  FROM tb_rf_menuitem c WHERE mi.menu_item_id = c.menu_item_parent_id    ),0) AS menu_item_column_max "
							+ ",menu_item_expanded " +
					" FROM tb_rf_menuitem mi  WHERE 1=1 ";
			if(searchobj.getMenu_item_status()>0){
				sql=sql+" AND  mi.`menu_item_status`="+searchobj.getMenu_item_status();
			}
			if(searchobj.getMenu_item_for()>0){
				sql=sql+" AND mi.`menu_item_for`= "+searchobj.getMenu_item_for();
			
				sql=sql+" AND mi.`menu_item_for_refid`= "+searchobj.getMenu_item_for_refid();
			}
			if(searchobj.getMenu_item_id()>0){
				sql=sql+" AND  mi.`menu_item_id`="+searchobj.getMenu_item_id();
			}
			if(searchobj.getMenu_item_dep_version()>0){
				sql=sql+" AND  mi.`menu_item_dep_version`="+searchobj.getMenu_item_dep_version();
			}
			sql=sql+" ORDER BY mi.`menu_item_order`";
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFMenuItemDTO.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	}
	
	public List<RFPageDTO> getRFPage(RFPageDTO searchobj)
	{
		List<RFPageDTO> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT rp.`erp_pageid`, rp.`erp_pagename`, rp.`erp_pagetitle`, rp.`erp_pageurl`, rp.`erp_pagestyle`" +
					" FROM erp_rf_page rp WHERE 1=1 ";
			if(searchobj.getErp_pageid()>0){
				sql=sql+" AND rp.`erp_pageid`="+searchobj.getErp_pageid();
			}else {
				sql=sql+" AND rp.`erp_pagename`= '"+searchobj.getErp_pagename()+"'";
			}
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFPageDTO.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	}
	public List<RFPageDTO> getRFPageWedjat(String pagename,int position){
		List<RFPageDTO> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT rp.`erp_pageid`, rp.`erp_pagename`, rp.`erp_pagetitle`, rp.`erp_pageurl`, rp.`erp_pagestyle`" +
					" FROM tb_rf_page rp1,tb_rf_page rp , tb_rf_page_wedjat w  WHERE rp1.erp_pageid = w.erp_pageid AND w.erp_subpageid = rp.`erp_pageid` AND  rp1.`erp_pagename` = '"+pagename+"'";
			if(position > 0 ){
				sql = sql+" AND erp_position="+position;
			}
			sql = sql+" ORDER BY erp_position ,`erp_position_row` "; 
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFPageDTO.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		if(rfMenuItemDTO==null || rfMenuItemDTO.size()==0){
			rfMenuItemDTO = new ArrayList<RFPageDTO>();
			RFPageDTO obj = new RFPageDTO();
			obj.setErp_pageurl("/faces_marketing/todaytask.xhtml");
			rfMenuItemDTO.add(obj);
		}
		return rfMenuItemDTO;
	}
	public List<RFButtonDTO> getRFButton(RFButtonDTO searchobj)
	{
		List<RFButtonDTO> rfMenuItemDTO = null;

		try {
			session=HibernateUtil.getSession();
			String sql="";
			sql=sql+" SELECT eb.`button_id`, eb.`button_ui_id`, eb.`button_value`, eb.`button_page_id`, eb.`button_nav_page_id`, " +
							" eb.`button_component_id`, eb.`button_action`, eb.`button_status`, eb.`button_onclick`, eb.`button_oncomplete` " +
					" FROM erp_rf_button eb WHERE 1=1 ";
			if(searchobj.getButton_status()>0){
				sql=sql+" AND eb.`button_status`="+searchobj.getButton_status();
			}
			if(searchobj.getButton_page_id()>0){
				sql=sql+" AND eb.`button_page_id`= "+searchobj.getButton_page_id();
			}
			if(searchobj.getButton_id()>0){
				sql=sql+" AND  eb.`button_id`="+searchobj.getButton_id();
			}
			sql=sql+" ORDER BY eb.button_order ";
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RFButtonDTO.class)).list();
			HibernateUtil.closeSession();
		} catch (Exception e) {

			log.fatal(e.getMessage());
			Log.exception(e);
			HibernateUtil.closeSession();
		}

		return rfMenuItemDTO;
	}
	public String getMenuName(int userRole,int  depVersion,String menu_name,int status,HashMap<String,Object> obj){
		String pageName="";
		 session = HibernateUtil.getSession(); 
		 List userPermissions;	  
		 try
		  { 			    
			   String sql="SELECT `user_role_menu_page`  FROM tb_atma_module  WHERE user_role_id="+userRole;
			   if(status>0){
				   sql=sql+" AND user_role_status="+status;
			   }
			   if(depVersion>0){
				   sql=sql+" AND user_dep_version="+depVersion;
			   }
			   userPermissions=session.createSQLQuery(sql).list();	
			   pageName=userPermissions.get(0).toString();
			   HibernateUtil.closeSession();
		  }
		 catch(Exception e)
			 {
			   HibernateUtil.closeSession();
			   log.fatal("user_role_id=====>"+userRole);
			   pageName="cmnEmptyPage.xhtml";
			   
			 }
			return pageName;
	}

	public String getLandingPage(int userrole) {
		String pageName="";
		 session = HibernateUtil.getSession(); 
		 try{ 
			 String sql = "select erp_pageurl from tb_user_permission, tb_rf_page where permission_role_home_page = erp_pageid and permission_role_id = " + userrole;
			 List page=session.createSQLQuery(sql).list();	
			   pageName=page.get(0).toString();
			 
		  }catch(Exception e){
			   HibernateUtil.closeSession();
			   pageName="/cmnEmptyPage.xhtml";
			   
			 }
		return pageName;
	}
	
}
