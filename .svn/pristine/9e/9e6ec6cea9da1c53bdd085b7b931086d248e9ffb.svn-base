package org.bte.core.person.staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.bte.core.person.PersonDAOImpl;
import org.bte.core.person.PersonDTO;
import org.bte.core.utils.CodeList;
import org.bte.core.utils.HibernateUtil;
import org.bte.core.utils.IDSequenceGenerator;
import org.bte.framework.faces.RFMenuItemDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.primefaces.model.TreeNode;

public class StaffDAOImpl extends PersonDAOImpl implements StaffDAO {
	
	public boolean saveStaffMtr(Map<String,Object> map){
		Session session=HibernateUtil.getSession();
		try
		{
			
			HibernateUtil.beginTransaction();

			if(savePerson(map)==false){
				throw new Exception();
			}	
		
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		
	}	
	catch(Exception e)
	{
		
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
		HibernateUtil.logException(e);
		return false;
	}
	
}

	
	public List<StaffDTO> getStaffMtr(Map<String, Object> map) {
		
		Session session=HibernateUtil.getSession();
		List<StaffDTO> stafflist=new ArrayList<StaffDTO>();
		try{
			String sql="SELECT p.person_id, p.`person_type`, p.`person_title`, p.`person_fname`, p.`person_mname`, p.`person_lname`,"
					+ " p.`person_sex`, p.`person_dob`, p.`person_orgnflag`, p.`person_uid`, p.`person_age`, p.`person_active`, "
					+ " p.`person_location`, p.`person_company`, p.`person_pp_no`, p.`person_pan_no`, p.`person_datereg`, p.`org_id`," 
					+ " coalesce((select c.cl_label from tb_code_list c where c.cl_id=p.person_type and c.cl_group='PERSONTYPE'),'') as person_type_name, "
					+ " p.`company_id`, p.`department_id`, p.`person_fat_hus_name`, p.`person_mot_wife_name`, p.`person_marital_status`,"
					+ " p.`user_id`,p.person_guardian_name,p.person_language_known,"
					+ " t.cd_id,t.`cd_no`,t.cd_phno, t.`cd_mobile`, t.`cd_flatname`, t.`cd_streetname1`, t.`cd_streetname2`, t.`cd_streetname3`, t.`ct_locality`, t.`cd_city`, t.`cd_state`, "
					+ " t.`cd_country`, t.`cd_pincode`, t.`cd_emailid`, t.`cd_landmark`, t.`cd_name` "
					+ " ,(SELECT cl_alternate_id_1 FROM tb_code_list WHERE cl_id = person_sex AND cl_group like 'SEX') as person_sex_label"
					+ " , (SELECT login_id FROM  tb_user WHERE login_person_id = p.person_id LIMIT 0,1  ) AS login_id  "
					+ " FROM tb_person_mtr p , tb_contactdetails_mtr t "
					+ " WHERE  p.person_id = t.cd_personid  and p.person_type > 1 ";

			if(map!=null){
				if(map.get(SAVE_OBJ_PERSON_NAME)!=null){
					sql = sql + " AND p.person_fname like '%"+map.get(SAVE_OBJ_PERSON_NAME).toString()+"%'";
				}
				if(map.get(SAVE_OBJ_PERSON_ID)!=null){
					sql = sql + " AND p.person_id like '"+map.get(SAVE_OBJ_PERSON_ID).toString()+"'";
				}if(map.get("person_id")!=null){
					sql = sql + " AND p.person_id like '"+map.get("person_id").toString()+"'";
				}
				if(map.get(SAVE_OBJ_PERSON_TYPE)!=null){
					if(map.get(SAVE_OBJ_PERSON_TYPE) instanceof Integer)
					sql = sql + " AND p.person_type = '"+map.get(SAVE_OBJ_PERSON_TYPE).toString()+"'";
					if(map.get(SAVE_OBJ_PERSON_TYPE) instanceof String)
						sql = sql + " AND p.person_type in( "+map.get(SAVE_OBJ_PERSON_TYPE).toString()+")";
				}
				if(map.get(SAVE_OBJ_ORG_ID)!=null){
					sql = sql + " AND p.org_id = '"+map.get(SAVE_OBJ_ORG_ID).toString()+"'";
				}
				if(map.get("person_active")!=null){
					sql = sql + " AND p.person_active = '"+map.get("person_active").toString()+"'";
				}
				if(map.get("SAVE_OBJ_ECRF_PROGRAM_ID")!=null){
					sql = sql + " AND p.person_id IN (SELECT s.person_id FROM tb_ecrf_program_staff s WHERE s.program_id ='"+map.get("SAVE_OBJ_ECRF_PROGRAM_ID").toString()+"')";
				}
				
			}
			sql = sql +" ORDER BY person_fname";
			stafflist=session.createSQLQuery(sql).setResultTransformer(Transformers
					.aliasToBean(StaffDTO.class)).list();
			HibernateUtil.closeSession();
		}catch(Exception e){
			HibernateUtil.logException(e);
			HibernateUtil.closeSession();
		}
		return stafflist;
	}
public PersonDTO getStaff(int doctorId) {

		
		Session session=HibernateUtil.getSession();
		List<PersonDTO> stafflist=new ArrayList<PersonDTO>();
		try{
			String sql="SELECT p.person_id, p.`person_type`, p.`person_title`, p.`person_fname`, p.`person_mname`, p.`person_lname`,"
					+ " p.`person_sex`, p.`person_dob`, p.`person_uid`, p.`person_age`, p.`person_active`, p.person_image_path ,"
					+ " person_fat_hus_name,person_mot_wife_name ,person_marital_status,person_datereg,person_active ,person_pan_no,p.department_id,"
					+ ""
					+ " `cd_emailid`,ct_locality,cd_city,cd_state,cd_country,cd_streetname2,cd_streetname1,cd_flatname,cd_no,cd_pincode  "
					+ " FROM tb_person_mtr p ,tb_contactdetails_mtr c "
					+ " WHERE  cd_personid = p.person_id AND cd_index = 2  AND   p.person_id=  "+doctorId;

			
				
			
			stafflist=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(PersonDTO.class)).list();
			HibernateUtil.closeSession();
			
		}catch(Exception e){
			
			HibernateUtil.closeSession();
		}
		if(stafflist!=null && stafflist.size()>0){
			return stafflist.get(0);
		}
		return null;
	
	}
	
	public List getMenuItemPermissionTemplate(int Templateid){
		Session session=HibernateUtil.getSession();
		List stafflist=new ArrayList();
		try{
			String sql="SELECT  menu_item_id  FROM tb_user_template_menu_item t "
					+ " WHERE user_template_id =  "+Templateid;

			
			stafflist=session.createSQLQuery(sql).list();
			HibernateUtil.closeSession();
		}catch(Exception e){
			HibernateUtil.logException(e);
			HibernateUtil.closeSession();
		}
		return stafflist;
	}
public List getMenuItemPermission(int staff_id,int company_id,int org_id){
		
		Session session=HibernateUtil.getSession();
		List stafflist=new ArrayList();
		try{
			String sql="SELECT  menu_item_id  FROM tb_user_template_menu_item m ,tb_user_permission_company t "
					+ " WHERE m.user_template_id = t.user_template_id AND t.`company_id` = "+company_id+" AND org_id = "+org_id+" AND  t.person_id =  "+staff_id;

			
			stafflist=session.createSQLQuery(sql).list();
			HibernateUtil.closeSession();
		}catch(Exception e){
			HibernateUtil.logException(e);
			HibernateUtil.closeSession();
		}
		return stafflist;
	}
public boolean savePermissionTemplate(UserTemplateDTO obj){


	Session session=HibernateUtil.getSession();
	try
	{
		
		HibernateUtil.beginTransaction();
int usertemplateid = obj.getUser_template_id() ;

		String sql="";
		Query qry = null;
		if(usertemplateid==0){
			usertemplateid = IDSequenceGenerator.getNextSequenceInt("tb_user_template_menu_item");
			obj.setUser_template_id(usertemplateid);
			
			sql="INSERT INTO  tb_user_template (user_template_name,user_template_id,add_user_id,add_date,user_template_home_page) "
					+ "VALUES(?,?,?,?,?) ";
			
			 qry=session.createSQLQuery(sql)
					 .setParameter(0, obj.getUser_template_name()).setParameter(1, usertemplateid)
					 .setParameter(2, obj.getAdd_user_id()).setParameter(3,new Date())
					 .setParameter(4,obj.getUser_template_home_page());
			qry.executeUpdate();
			
		}else{
			 sql="delete from tb_user_template_menu_item where user_template_id = "+usertemplateid+" ";
				
			 qry=session.createSQLQuery(sql);
			qry.executeUpdate();
			
			
			
			sql="UPDATE  tb_user_template SET user_template_name = ? , user_template_home_page=?  where user_template_id = "+usertemplateid+" ";
			
			 qry=session.createSQLQuery(sql)
					 .setParameter(0, obj.getUser_template_name())
					 .setParameter(1,obj.getUser_template_home_page());
			qry.executeUpdate();
		}
		
		
		String sql_menu = "INSERT INTO tb_user_template_menu_item (`user_template_id`,  `menu_item_id`) VALUES (?,?)";
		String sql_v_type = "INSERT INTO tb_user_template_jrnl_vchr_type "
				+ " (`user_template_id`, `jrnl_vchr_type`,jrnl_vchr_type_insert_request,jrnl_vchr_type_cancel_request,jrnl_vchr_type_show_item_value"
				+ ",jrnl_vchr_type_show_print  ) "
				+ " VALUES (?,?,?,?,?,?)";
		
			 
			  if(obj.getMenuitem()!=null){
				  for(Integer li : obj.getMenuitem()){
					  
					  qry=session.createSQLQuery(sql_menu).setParameter(0, usertemplateid).setParameter(1, li);
						qry.executeUpdate();
				  }
			  }
			  
			   
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		return true;
	
}	
catch(Exception e)
{
	
	HibernateUtil.rollbackTransaction();
	HibernateUtil.closeSession();
	HibernateUtil.logException(e);
	return false;
}



}
public List<UserTemplateDTO>getsavePermissionTemplate(Map<String,Object> map){
	Session session=HibernateUtil.getSession();
	List<UserTemplateDTO> stafflist=new ArrayList<UserTemplateDTO>();
	try{
		String sql="SELECT user_template_id,user_template_name,user_template_home_page FROM tb_user_template ";

		
		stafflist=session.createSQLQuery(sql).setResultTransformer(Transformers
				.aliasToBean(UserTemplateDTO.class)).list();
		HibernateUtil.closeSession();
	}catch(Exception e){
		HibernateUtil.logException(e);
		HibernateUtil.closeSession();
	}
	return stafflist;
}
	
public static List<StaffDTO> getStafflicence_detail() {

		
		Session session=HibernateUtil.getSession();
		List<StaffDTO> stafflist=new ArrayList<StaffDTO>();
		try{
			String sql="SELECT p.person_id, p.`person_type`, p.`person_title`, p.`person_fname`, p.`person_mname`, p.`person_lname`,"
					+ " p.`person_sex`, p.`person_dob` ,p.`person_uid`, p.`person_age`, p.`person_active`, p.person_image_path ,"
					+ ""
					+ " (SELECT group_concat(cd_phno) FROM tb_contact_phone WHERE cd_personid =  p.person_id ) AS cd_mobile ,"
					+ "`cd_emailid`,licence_exp_date "
					+ " FROM tb_person_mtr p ,tb_contactdetails_mtr c ,tb_emp_licence_detail l "
					+ " WHERE  cd_personid = p.person_id AND cd_index = 2 AND person_type = 3 AND  p.person_id = l.person_id "
					+ " AND licence_exp_date < current_date";

			
				
			
			stafflist=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(StaffDTO.class)).list();
			HibernateUtil.closeSession();
			
		}catch(Exception e){
			
			HibernateUtil.closeSession();
		}
		
		return stafflist;
	
	}

public static List<StaffDTO> getStaffcheck_detail() {

	
	Session session=HibernateUtil.getSession();
	List<StaffDTO> stafflist=new ArrayList<StaffDTO>();
	try{
		String sql="SELECT p.person_id, p.`person_type`, p.`person_title`, p.`person_fname`, p.`person_mname`, p.`person_lname`,"
				+ " p.`person_sex`, p.`person_dob` ,p.`person_uid`, p.`person_age`, p.`person_active`, p.person_image_path ,"
				+ ""
				+ " (SELECT group_concat(cd_phno) FROM tb_contact_phone WHERE cd_personid =  p.person_id ) AS cd_mobile ,"
				+ "`cd_emailid`,licence_exp_date,check_next_date "
				+ " FROM tb_person_mtr p ,tb_contactdetails_mtr c ,tb_emp_licence_detail l "
				+ " WHERE  cd_personid = p.person_id AND cd_index = 2 AND person_type = 3 AND  p.person_id = l.person_id "
				+ " AND check_next_date < current_date";

		
			
		
		stafflist=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(StaffDTO.class)).list();
		HibernateUtil.closeSession();
		
	}catch(Exception e){
		
		HibernateUtil.closeSession();
	}
	
	return stafflist;

}
}
