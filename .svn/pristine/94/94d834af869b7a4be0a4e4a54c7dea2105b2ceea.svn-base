package org.bte.core.person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.bte.core.utils.HibernateUtil;
import org.bte.core.utils.IDSequenceGenerator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.bte.framework.error.Log;


public class PersonDAOImpl  {
	Session session;
	protected String print_seq_name=null;
	protected boolean insertflag = false;
	public static String SAVE_OBJ_TB_PERSON_MTR_ID = "person_id";
	public static String SAVE_OBJ_CD_INDEX = "SAVE_OBJ_CD_INDEX";
	public static String SAVE_OBJ_PERSON = "SAVE_OBJ_PERSON";
	public static String SAVE_OBJ_PERSON_ID = "SAVE_OBJ_PERSON_ID";
	public static String SAVE_OBJ_PERSON_NAME = "SAVE_OBJ_PERSON_NAME";
	public static String SAVE_OBJ_PERSON_TYPE = "SAVE_OBJ_PERSON_TYPE";
	public static String SAVE_OBJ_ORG_ID = "org_id";
	protected  boolean savePerson(Map<String,Object> map ){
		 session=HibernateUtil.getSession();
		try
		{
			
			HibernateUtil.beginTransaction();
			PersonDTO person_save_obj = (PersonDTO) map.get(SAVE_OBJ_PERSON);
			int person_id = person_save_obj.getPerson_id();
			if(person_save_obj.getPerson_id()==0){
				person_id=Integer.parseInt(IDSequenceGenerator.getNextSequence("tb_person_mtr"));
				if(print_seq_name!=null && (person_save_obj.getPerson_uid()==null || person_save_obj.getPerson_uid().trim().isEmpty() )){
					//person_save_obj.setPerson_uid(getPrintNo(print_seq_name,person_save_obj.getOrg_id(),false,null));
				}
				person_save_obj.setPerson_id(person_id);
				if(!savePersonMtr(person_save_obj,session)){
					throw new Exception();
				}
				
				insertflag = true;
			}else{

				if(!updatePersonMtr(person_save_obj,session)){
					throw new Exception();
				}			
			
			}
			/*
			if(!saveOrUpdateContactPerson(person_save_obj.getContactperson_list(), person_id)){
				throw new Exception();
			}
			if(!saveOrUpdateNotifiactionPerson(person_save_obj.not_list, person_id)){
				throw new Exception();
			}
			*/
			ContactDetailsMtrDTO perment = new ContactDetailsMtrDTO(); ;
					List<ContactDetailsMtrDTO> contact_details_mtr_save_list = new ArrayList<ContactDetailsMtrDTO>();
					if(person_save_obj.getContactdetailsmtr_list() ==null){
						contact_details_mtr_save_list = new ArrayList<ContactDetailsMtrDTO>();
						perment = new ContactDetailsMtrDTO();
					}
					else{
						for(ContactDetailsMtrDTO conmtr:person_save_obj.getContactdetailsmtr_list()){
							if(conmtr.getCd_index() == 1){
								perment = conmtr;
								
							}else{
								contact_details_mtr_save_list.add(conmtr);
							}
						}
					}
					
					perment.setCd_city(person_save_obj.getCd_city());
					perment.setCd_country(person_save_obj.getCd_country());
					perment.setCd_emailid(person_save_obj.getCd_emailid());
					
					perment.setCd_fax(person_save_obj.getCd_fax());
					perment.setCd_no(person_save_obj.getCd_no());
					
					perment.setCd_flatname(person_save_obj.getCd_flatname());
					perment.setCd_index(person_save_obj.getCd_index());
					perment.setCd_landmark(person_save_obj.getCd_landmark());
					perment.setCd_mobile(person_save_obj.getCd_mobile());
					perment.setCd_name(person_save_obj.getCd_name());
					perment.setCd_offphno(person_save_obj.getCd_offphno());
					perment.setCd_pincode(person_save_obj.getCd_pincode());
					perment.setCd_phno(person_save_obj.getCd_phno());
					perment.setCd_status(1);
					perment.setCd_state(person_save_obj.getCd_state());
					perment.setCd_streetname1(person_save_obj.getCd_streetname1());
					perment.setCd_streetname2(person_save_obj.getCd_streetname2());
					perment.setCd_streetname3(person_save_obj.getCd_streetname3());
					perment.setCt_locality(person_save_obj.getCt_locality());
					perment.setCd_id(person_save_obj.getCd_id());
					contact_details_mtr_save_list.add(perment);
					if(saveOrUpdateContactDetailsMtr(contact_details_mtr_save_list, person_id, 0)){
						person_save_obj.setCd_id(perment.getCd_id());
						HibernateUtil.commitTransaction();
						HibernateUtil.closeSession();
						return true;
					}
					
			
			
			
			  throw new Exception();
			
		}	
		catch(Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			HibernateUtil.logException(e);
			return false;
		}
		
	}

	public   boolean savePersonMtr(PersonDTO person_save_obj,Session session)  {
		//log
		
			Query qry;
			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append("insert into tb_person_mtr ");
			sql_str_buf.append("(	person_id, 			person_type, 		person_title, ");
			sql_str_buf.append("	person_fname, 		person_mname, 		person_lname, ");
			sql_str_buf.append("	person_uid, 		person_age, 		person_active,");
			sql_str_buf.append("	person_sex, 		person_dob, 		person_orgnflag,");
			sql_str_buf.append("	person_location, 	person_company, 	person_pp_no,");
			sql_str_buf.append("	person_pan_no, 		person_datereg,		org_id,");
			sql_str_buf.append("	company_id, 		department_id, 		person_fat_hus_name,");
			sql_str_buf.append("	person_mot_wife_name, person_marital_status, user_id ," +
									" person_abbreviation, person_guardian_name,person_language_known,person_name_search )");
			sql_str_buf.append("values( ?, ?, ?, ?, ?, ?, ?, ? ,");
			sql_str_buf.append("		?, ?, ?, ?, ?, ?, ?, ? ,");
			sql_str_buf.append("		?, ?, ?, ?, ?, ?, ?, ? ,? ,?,?,?)");
			
			
			
			  qry = session.createSQLQuery(sql_str_buf.toString())
			 					.setParameter(0, person_save_obj.getPerson_id())
							   .setParameter(1, person_save_obj.getPerson_type())
							   .setParameter(2, person_save_obj.getPerson_title())
							   
							   .setParameter(3, person_save_obj.getPerson_fname())
							   .setParameter(4, person_save_obj.getPerson_mname())
							   .setParameter(5, person_save_obj.getPerson_lname())
							   
							   .setParameter(6, person_save_obj.getPerson_uid())
							   .setParameter(7, person_save_obj.getPerson_age())
							   .setParameter(8, person_save_obj.getPerson_active())
							   
							   .setParameter(9, person_save_obj.getPerson_sex())
							   .setParameter(10, person_save_obj.getPerson_dob())
							   .setParameter(11, person_save_obj.getPerson_orgnflag())
							   
							   .setParameter(12, person_save_obj.getPerson_location())
							   .setParameter(13, person_save_obj.getPerson_company())
							   .setParameter(14, person_save_obj.getPerson_pp_no())
							   
							   .setParameter(15, person_save_obj.getPerson_pan_no())
							   .setParameter(16, person_save_obj.getPerson_datereg())
							   .setParameter(17, person_save_obj.getOrg_id())
							 
							   .setParameter(18, person_save_obj.getCompany_id())
							   .setParameter(19, person_save_obj.getDepartment_id())
							   .setParameter(20, person_save_obj.getPerson_fat_hus_name())
							   
							   .setParameter(21, person_save_obj.getPerson_mot_wife_name())
							   .setParameter(22, person_save_obj.getPerson_marital_status())
							   .setParameter(23, person_save_obj.getUser_id())
							   
							   .setParameter(24, person_save_obj.getPerson_abbreviation())
							   .setParameter(25, person_save_obj.getPerson_guardian_name())
							   .setParameter(26, person_save_obj.getPerson_language_known())
							   .setParameter(27, person_save_obj.getPerson_fname().replace(" ", ""));

				if(qry.executeUpdate()==0){
					
					return false;
					
				}
			
		
		return true;
		
		
	}
	public boolean updatePersonMtr(PersonDTO person_update_obj,Session session)  {
		//log
		
		
			Query qry;
			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append("update  tb_person_mtr ");
			sql_str_buf.append("set	person_id=?, 		person_type=?, 		person_title=?, ");
			sql_str_buf.append("	person_fname=?, 	person_mname=?, 	person_lname=?, ");
			sql_str_buf.append("	person_uid=?, 		person_age=?, 		person_active=?,");
			sql_str_buf.append("	person_sex=?, 		person_dob=?, 		person_orgnflag=?,");
			sql_str_buf.append("	person_location=?, 	person_company=?, 	person_pp_no=?,");
			sql_str_buf.append("	person_pan_no=?, 	person_datereg=?,		org_id=?,");
			sql_str_buf.append("	company_id=?, 		department_id=?, 		person_fat_hus_name=?,");
			sql_str_buf.append("	person_mot_wife_name=?, person_marital_status=?, user_id=? ,person_abbreviation=?, ");
			sql_str_buf.append("	person_guardian_name=? ,person_language_known=? , person_name_search = ? ");
			sql_str_buf.append("where		 person_id= "+ person_update_obj.getPerson_id());
			
			
			
			  qry = session.createSQLQuery(sql_str_buf.toString())
			 					.setParameter(0, person_update_obj.getPerson_id())
							   .setParameter(1, person_update_obj.getPerson_type())
							   .setParameter(2, person_update_obj.getPerson_title())
							   
							   .setParameter(3, person_update_obj.getPerson_fname())
							   .setParameter(4, person_update_obj.getPerson_mname())
							   .setParameter(5, person_update_obj.getPerson_lname())
							   
							   .setParameter(6, person_update_obj.getPerson_uid())
							   .setParameter(7, person_update_obj.getPerson_age())
							   .setParameter(8, person_update_obj.getPerson_active())
							   
							   .setParameter(9, person_update_obj.getPerson_sex())
							   .setParameter(10, person_update_obj.getPerson_dob())
							   .setParameter(11, person_update_obj.getPerson_orgnflag())
							   
							   .setParameter(12, person_update_obj.getPerson_location())
							   .setParameter(13, person_update_obj.getPerson_company())
							   .setParameter(14, person_update_obj.getPerson_pp_no())
							   
							   .setParameter(15, person_update_obj.getPerson_pan_no())
							   .setParameter(16, person_update_obj.getPerson_datereg())
							   .setParameter(17, person_update_obj.getOrg_id())
							 
							   .setParameter(18, person_update_obj.getCompany_id())
							   .setParameter(19, person_update_obj.getDepartment_id())
							   .setParameter(20, person_update_obj.getPerson_fat_hus_name())
							   
							   .setParameter(21, person_update_obj.getPerson_mot_wife_name())
							   .setParameter(22, person_update_obj.getPerson_marital_status())
							   .setParameter(23, person_update_obj.getUser_id())
							   
							   .setParameter(24, person_update_obj.getPerson_abbreviation())							   
							   .setParameter(25, person_update_obj.getPerson_guardian_name())
							   .setParameter(26, person_update_obj.getPerson_language_known())
							   .setParameter(27, person_update_obj.getPerson_fname().replace(" ", ""));
			  

				if(qry.executeUpdate()==0){
					
					return false;
					
				}
			
		
		return true;
		}	
		
		
	
	
	public    boolean saveOrUpdateContactDetailsMtr(List<ContactDetailsMtrDTO> contact_details_mtr_save_list , int person_id , int cd_id)  
	{
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		
		//log
		try{
			
			
			Query qry = null;
			/*	String del="delete from tb_contactdetails_mtr where cd_personid = "+person_id+" ";
				if(cd_id>0){
					del=del+" AND cd_id = '"+cd_id+"' ";
				}
				Query qry=session.createSQLQuery(del);
				if(qry.executeUpdate()==0){
					
				}*/
			
			
			
		StringBuilder sql_str_buf=new StringBuilder();
		
		sql_str_buf.append("insert into tb_contactdetails_mtr ");
		sql_str_buf.append("	(cd_personid, 		cd_index, 			cd_no, ");
		sql_str_buf.append("	cd_mobile, 			cd_streetname1, 	cd_streetname2, ");
		sql_str_buf.append("	cd_flatname, 		ct_locality, 		cd_city,");
		sql_str_buf.append("	cd_state, 			cd_country, 		cd_pincode,");
		sql_str_buf.append("	cd_offphno, 		cd_fax, 			cd_phno, ");
		sql_str_buf.append("	cd_emailid, 		cd_id,cd_landmark,");
		sql_str_buf.append("	cd_name, 	cd_defult, 	cd_status, ");
		sql_str_buf.append("	cd_streetname3  )");
		sql_str_buf.append("values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,");
		sql_str_buf.append("		?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
		
		Iterator<ContactDetailsMtrDTO> it = contact_details_mtr_save_list.iterator();
		while(it.hasNext()){
			ContactDetailsMtrDTO contact_details_mtr_save_obj = it.next();
			
			if(contact_details_mtr_save_obj.getCd_id()>0){
				String del="delete from tb_contactdetails_mtr where cd_id = "+contact_details_mtr_save_obj.getCd_id()+" ";
				
				 qry=session.createSQLQuery(del);
				if(qry.executeUpdate()==0){
				}
			}else{
				int id = IDSequenceGenerator.getNextSequenceInt("tb_contactdetails_mtr");
				
				contact_details_mtr_save_obj.setCd_id(id);
				
			}
			
		 qry = session.createSQLQuery(sql_str_buf.toString())
		 					.setParameter(0, person_id)
						   .setParameter(1, contact_details_mtr_save_obj.getCd_index())
						   .setParameter(2, contact_details_mtr_save_obj.getCd_no())
						   
						   .setParameter(3, contact_details_mtr_save_obj.getCd_mobile())
						   .setParameter(4, contact_details_mtr_save_obj.getCd_streetname1())
						   .setParameter(5, contact_details_mtr_save_obj.getCd_streetname2())
						   
						   .setParameter(6, contact_details_mtr_save_obj.getCd_flatname())
						   .setParameter(7, contact_details_mtr_save_obj.getCt_locality())
						   .setParameter(8, contact_details_mtr_save_obj.getCd_city())
						   
						   .setParameter(9, contact_details_mtr_save_obj.getCd_state())
						   .setParameter(10, contact_details_mtr_save_obj.getCd_country())
						   .setParameter(11, contact_details_mtr_save_obj.getCd_pincode())
						   
						   .setParameter(12, contact_details_mtr_save_obj.getCd_offphno())
						   .setParameter(13, contact_details_mtr_save_obj.getCd_fax())
						   .setParameter(14, contact_details_mtr_save_obj.getCd_phno())
						  
						   .setParameter(15, contact_details_mtr_save_obj.getCd_emailid())
						   .setParameter(16, contact_details_mtr_save_obj.getCd_id())
						   .setParameter(17, contact_details_mtr_save_obj.getCd_landmark())
						  
						   .setParameter(18, contact_details_mtr_save_obj.getCd_name())
						   .setParameter(19, contact_details_mtr_save_obj.isCd_defult())
						   .setParameter(20, contact_details_mtr_save_obj.getCd_status())
						   .setParameter(21, contact_details_mtr_save_obj.getCd_streetname3());
		 
			if(qry.executeUpdate()==0){
				//log
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				
				
			}
		}
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	//log
	return true;
	}	
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
		return false;
		
	}
	}

	

	
	private   boolean saveOrUpdateContactPhone(List<ContactPhoneDTO> contact_phone_list,int person_id, int cd_id) 
	{
			
			 StringBuilder sql_str_buf=new StringBuilder();
			 
			 
				/*if(contact_phone_list_obj.getCd_id()>0)
					if(!(deleteContactPhone(contact_phone_list_obj.getCd_id()))){
						rollbackTransaction();
						closeSession();
						throw new Exception();
					}*/
				
			 	
					sql_str_buf.append("insert into tb_contact_phone ");
					sql_str_buf.append("	(			cd_personid, 	cd_location, ");
					sql_str_buf.append("				cd_type, 		cd_phoneno,		cd_id  )");
					sql_str_buf.append("values( ?, ?, ?, ");
					sql_str_buf.append("		?, ?   )");
					
				Session	session=HibernateUtil.getSession();
				HibernateUtil.beginTransaction();
							Iterator<ContactPhoneDTO> it = contact_phone_list.iterator();
							while(it.hasNext()){
								ContactPhoneDTO contact_phone_list_obj = it.next();
			Query	 qry = session.createSQLQuery(sql_str_buf.toString())
					 				   .setParameter(0, contact_phone_list_obj.getCd_personid())
									   .setParameter(1, contact_phone_list_obj.getCd_location())
									   
									   .setParameter(2, contact_phone_list_obj.getCd_type())
									   .setParameter(3, contact_phone_list_obj.getCd_phoneno())
									   .setParameter(4, contact_phone_list_obj.getCd_id());
									   
				if(qry.executeUpdate()==0){
					//log
					
					return false;
					
				}
			}
			
			
			return true;
		}
		
		
		
	

	public boolean saveOrUpdateContactPerson(List<ContactPersonDTO> contact_person_list,int person_id) 
	{
		
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		try {
				StringBuilder sql_str_buf=new StringBuilder();
			/*if(contact_person_list_obj.getCd_serial_id()>0)
				if(!(deleteContactPerson(contact_person_list_obj.getCd_serial_id()))){
				rollbackTransaction();
				closeSession();
				throw new Exception();
			}*/
		 	
				sql_str_buf.append("insert into tb_contact_person ");
				sql_str_buf.append("(cd_personid, cd_contactname, ");
				sql_str_buf.append("cd_designation, cd_contactno, cd_extension, ");
				sql_str_buf.append("cd_mobileno, cd_emailid, cd_serial_id, cd_address, cd_relation, cd_income ) ");
				sql_str_buf.append("values( ?, ?, ?, ?, "); 
				sql_str_buf.append("?, ?, ?, ? ,?,?,? )");
				
				/*Session session=getSession();
				beginTransaction();*/
				if(contact_person_list!=null)
				{
					Iterator<ContactPersonDTO> it = contact_person_list.iterator();
					while(it.hasNext())
					{
						ContactPersonDTO contact_person_list_obj=  it.next();
						if(contact_person_list_obj.getCd_serial_id()>0){
							String del="delete from tb_contact_person where cd_serial_id = "+contact_person_list_obj.getCd_serial_id()+" ";
							
							Query qry=session.createSQLQuery(del);
							if(qry.executeUpdate()==0){
							}
						}
						
						
						Query qry = session.createSQLQuery(sql_str_buf.toString())
					 				   .setParameter(0, person_id)
									   .setParameter(1, contact_person_list_obj.getCd_contactname())
									   
									   .setParameter(2, contact_person_list_obj.getCd_designation())
									   .setParameter(3, contact_person_list_obj.getCd_contactno())
									   .setParameter(4, contact_person_list_obj.getCd_extension())
									   
									   .setParameter(5, contact_person_list_obj.getCd_mobileno())
									   .setParameter(6, contact_person_list_obj.getCd_emailid())
									   .setParameter(7, contact_person_list_obj.getCd_serial_id())
									   .setParameter(8, contact_person_list_obj.getCd_address())
									   .setParameter(9, contact_person_list_obj.getCd_relation())
									   .setParameter(10, contact_person_list_obj.getCd_income());
				
						if(qry.executeUpdate()==0)
						{	
							HibernateUtil.rollbackTransaction();
							HibernateUtil.closeSession();
							return false;	
							
						}
					}
				}
				
				HibernateUtil.commitTransaction();
				HibernateUtil.closeSession();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			return false;
		}
		
	}

	public   List<PersonDTO> getPersonList(int persontype,int personid,Map<String , Object> map)
	{
		List<PersonDTO> person_list;	  
		try
		{

			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append(" select 	person_id, 			person_type, 		person_title,  ");
			sql_str_buf.append("			person_fname, 		person_mname, 		person_lname, ");
			sql_str_buf.append("			person_uid, 		person_age, 		person_active,");
			sql_str_buf.append("			person_sex, 		person_dob, 		person_orgnflag,");
			sql_str_buf.append("			person_location, 	person_company, 	person_pp_no,");
			sql_str_buf.append("			person_pan_no, 		person_datereg,		org_id,");
			sql_str_buf.append("			company_id, 		department_id, 		person_fat_hus_name,");
			sql_str_buf.append("			person_mot_wife_name, person_marital_status, user_id, ");
			sql_str_buf.append("			 person_abbreviation, person_guardian_name,person_language_known ");
			sql_str_buf.append(" from 	tb_person_mtr WHERE 1 = 1 ");
			
			if(personid != 0){
				sql_str_buf.append(" AND 		person_id = '").append(personid).append("'");
			}
			if(persontype != 0){
				sql_str_buf.append(" AND 		person_type = '").append(persontype).append("'");
			}
			Session session=HibernateUtil.getSession();
			
			person_list=session.createSQLQuery(sql_str_buf.toString()).
									setResultTransformer(Transformers.aliasToBean(PersonDTO.class)).list();		
			
			HibernateUtil.closeSession();
			return person_list;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
		
	}
	
	public    List<ContactDetailsMtrDTO> getContactDetailsList(Map<String,Object> map )
	{
		List<ContactDetailsMtrDTO> person_list;	  
		try
		{

			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append(" select 	cd_personid, 		cd_index, 			cd_no,  ");
			sql_str_buf.append("			cd_mobile, 			cd_streetname1, 	cd_streetname2,");
			sql_str_buf.append("			cd_flatname, 		ct_locality, 		cd_city,");
			sql_str_buf.append("			cd_state, 			cd_country, 		cd_pincode,");
			sql_str_buf.append("			cd_offphno, 		cd_fax, 			cd_phno,");
			sql_str_buf.append("			cd_emailid, 		cd_id,cd_landmark,");
			sql_str_buf.append("			cd_name, 	cd_defult, 	cd_status, cd_streetname3 ");
			sql_str_buf.append(" from 	tb_contactdetails_mtr ");
			sql_str_buf.append(" where 	1=1 ");
			if(map!=null){
				if(map.get(SAVE_OBJ_TB_PERSON_MTR_ID)!=null){
					sql_str_buf.append(" AND 	cd_personid = ").append(map.get(SAVE_OBJ_TB_PERSON_MTR_ID).toString());
				}
				if(map.get(SAVE_OBJ_CD_INDEX)!=null){
					sql_str_buf.append(" AND 	cd_index = ").append(map.get(SAVE_OBJ_CD_INDEX).toString());
				}
			}
			Session 	session=HibernateUtil.getSession();
			
			person_list=session.createSQLQuery(sql_str_buf.toString()).setResultTransformer(Transformers.aliasToBean(ContactDetailsMtrDTO.class)).list();		
			
			HibernateUtil.closeSession();
			return person_list;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
		
	}
	
	
	

	public   List<ContactPhoneDTO> getContactPhoneList(int personid,int persontype)
	{
		
		List<ContactPhoneDTO> contact_phone_list;	  
		try
		{

			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append(" select 	cd_personid, 	cd_location, ");
			sql_str_buf.append(			"	cd_type, 		cd_phno as cd_phoneno  ");
			sql_str_buf.append(" from 	tb_contact_phone ");
			sql_str_buf.append(" where cd_personid = '").append(personid).append("'");
			
			Session session=HibernateUtil.getSession();
			
			contact_phone_list=session.createSQLQuery(sql_str_buf.toString()).setResultTransformer(Transformers.aliasToBean(ContactPhoneDTO.class)).list();		
			
			HibernateUtil.closeSession();
			return contact_phone_list;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
		
	}
	public   List<ContactPhoneDTO> getContactPhoneList(int personid)
	{
		
		List<ContactPhoneDTO> contact_phone_list;	  
		try
		{

			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append(" select 	cd_personid, 	cd_location, ");
			sql_str_buf.append(			"	cd_type, 		cd_phno as cd_phoneno  ");
			sql_str_buf.append(" from 	tb_contact_phone ");
			sql_str_buf.append(" where cd_personid = '").append(personid).append("'");
			
			Session session=HibernateUtil.getSession();
			
			contact_phone_list=session.createSQLQuery(sql_str_buf.toString()).setResultTransformer(Transformers.aliasToBean(ContactPhoneDTO.class)).list();		
			
			HibernateUtil.closeSession();
			return contact_phone_list;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
		
	}
	public   List<ContactPersonDTO> getContactPersonList(int personid)
	{
		List<ContactPersonDTO> contact_person_list=new ArrayList<ContactPersonDTO>();	  
		try
		{
			Session session = HibernateUtil.getSession();  	
			
			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append("select	cd_personid,   cd_contactname, ");
			sql_str_buf.append("		cd_designation, cd_contactno,   cd_extension, ");
			sql_str_buf.append("		cd_mobileno, 	cd_emailid  ,cd_serial_id ");
			sql_str_buf.append(" from 	tb_contact_person ");
			sql_str_buf.append(" where cd_personid = "+personid);
			
			contact_person_list=session.createSQLQuery(sql_str_buf.toString()).setResultTransformer(Transformers.aliasToBean(ContactPersonDTO.class)).list();		
			
			HibernateUtil.closeSession();
			return contact_person_list;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
		
	}
	
	public   List<ContactPersonDTO> getContactPersonList(Map<String,Object> map){
		
		List<ContactPersonDTO> contact_person_list=new ArrayList<ContactPersonDTO>();	  
		try
		{
			Session session = HibernateUtil.getSession();  	
			
			StringBuilder sql_str_buf=new StringBuilder();
			
			sql_str_buf.append("select cd_serial_id, cd_personid, cd_contactname, ");
			sql_str_buf.append("cd_designation, cd_contactno,   cd_extension, ");
			sql_str_buf.append("cd_mobileno, cd_emailid, cd_serial_id ");
			sql_str_buf.append("from tb_contact_person ");
			sql_str_buf.append("where 1=1 ");
			if(map!=null){
				if(map.get(SAVE_OBJ_TB_PERSON_MTR_ID)!=null){
					sql_str_buf.append(" AND cd_personid = ").append(map.get(SAVE_OBJ_TB_PERSON_MTR_ID).toString());
				}
				if(map.get("name_sugg")!=null) {
					sql_str_buf.append(" AND cd_contactname like '").append(map.get("name_sugg").toString()).append("%'");
				}
				
			}
			
			contact_person_list=session.createSQLQuery(sql_str_buf.toString()).setResultTransformer(Transformers.aliasToBean(ContactPersonDTO.class)).list();		
			
			HibernateUtil.closeSession();
			return contact_person_list;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
		
	}
	public List<PersonNotificationDTO> getPersonNotificationList(Map<String,Object> map ){
		List<PersonNotificationDTO> contact_person_list=new ArrayList<PersonNotificationDTO>();	  
	try
	{
		Session session = HibernateUtil.getSession();  	
		
		StringBuilder sql_str_buf=new StringBuilder();
		
		sql_str_buf.append("SELECT t.`person_id`, t.`notfication_for`, t.`notification_sms`, t.`notification_email` ,`cl_alternate_id_1`   as  notfication_for_label FROM tb_person_notification t , tb_code_list ");
		sql_str_buf.append(" where t.`notfication_for` = cl_id AND cl_group like 'NOTIFICATION_FOR' ");
		if(map!=null){
			if(map.get(SAVE_OBJ_TB_PERSON_MTR_ID)!=null){
				sql_str_buf.append(" AND 	 t.`person_id` =  ").append(map.get(SAVE_OBJ_TB_PERSON_MTR_ID).toString());
			}
			if(map.get(SAVE_OBJ_PERSON_ID)!=null){
				sql_str_buf.append(" AND 	 t.`person_id` =  ").append(map.get(SAVE_OBJ_PERSON_ID).toString());
			}
			
		}
		
		contact_person_list=session.createSQLQuery(sql_str_buf.toString()).setResultTransformer(Transformers.aliasToBean(PersonNotificationDTO.class)).list();		
		
		HibernateUtil.closeSession();
		return contact_person_list;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}}
	
	private   boolean saveOrUpdateNotifiactionPerson(List<PersonNotificationDTO> contact_person_list,int person_id) 
	{
		
			StringBuilder sql_str_buf=new StringBuilder();
			
			
				
			/*if(contact_person_list_obj.getCd_serial_id()>0)
				if(!(deleteContactPerson(contact_person_list_obj.getCd_serial_id()))){
				rollbackTransaction();
				closeSession();
				throw new Exception();
			}*/
		 	
			if(person_id>0)
			{
				String del="delete from tb_person_notification where `person_id` = "+person_id+" ";
				
				Query qry=session.createSQLQuery(del);
				if(qry.executeUpdate()==0){
					
				}
			}
			
				sql_str_buf.append("insert into tb_person_notification ");
				sql_str_buf.append("  ( `person_id`, `notfication_for`, `notification_sms`, `notification_email` ) ");
				sql_str_buf.append("values( ?, ?, ?, ? )"); 
				
				
				/*Session session=getSession();
				beginTransaction();*/
				if(contact_person_list!=null)
				{
					Iterator<PersonNotificationDTO> it = contact_person_list.iterator();
					while(it.hasNext())
					{
						
						PersonNotificationDTO contact_person_list_obj=  it.next();
					
						Query qry = session.createSQLQuery(sql_str_buf.toString())
					 				   .setParameter(0, person_id)
									   .setParameter(1, contact_person_list_obj.getNotfication_for())
									   
									   .setParameter(2, contact_person_list_obj.isNotification_sms())
									   .setParameter(3, contact_person_list_obj.isNotification_email());
				
						if(qry.executeUpdate()==0)
						{						
							return false;					
						}
					}
				}
				
				
		return true;		
	}

	protected  boolean savePerson(PersonDTO person_save_obj){
		 session=HibernateUtil.getSession();
		try
		{
			
			HibernateUtil.beginTransaction();
			int person_id = person_save_obj.getPerson_id();
			if(person_save_obj.getPerson_id()==0){
				person_id=Integer.parseInt(IDSequenceGenerator.getNextSequence("tb_person_mtr"));
				if(print_seq_name!=null && (person_save_obj.getPerson_uid()==null || person_save_obj.getPerson_uid().trim().isEmpty() )){
					//person_save_obj.setPerson_uid(getPrintNo(print_seq_name,person_save_obj.getOrg_id(),false,null));
				}
				person_save_obj.setPerson_id(person_id);
				
				
				insertflag = true;
				
				if(!savePersonMtr(person_save_obj,session)){
					throw new Exception();
				}
				
			}
			if(!updatePersonMtr(person_save_obj,session)){
				throw new Exception();
			}
			if(person_save_obj.getContactperson_list()!=null){
				if(!saveOrUpdateContactPerson(person_save_obj.getContactperson_list(), person_id)){
					throw new Exception();
				}
			}
			/*
			if(person_save_obj.not_list!=null){
				if(!saveOrUpdateNotifiactionPerson(person_save_obj.not_list, person_id)){
					throw new Exception();
				}
			}
			
			if(person_save_obj.contactphone_list!=null){
				if(!saveOrUpdateContactPhone(person_save_obj.contactphone_list, person_id)){
					throw new Exception();
				}
				
			}
			*/
			
			ContactDetailsMtrDTO perment = new ContactDetailsMtrDTO(); ;
					List<ContactDetailsMtrDTO> contact_details_mtr_save_list = person_save_obj.getContactdetailsmtr_list();
					if(contact_details_mtr_save_list ==null){
						contact_details_mtr_save_list = new ArrayList<ContactDetailsMtrDTO>();
						perment = new ContactDetailsMtrDTO();
					}
					/*else{
						for(int i=0;contact_details_mtr_save_list.size()>i;i++){
							if(contact_details_mtr_save_list.get(i).getCd_index() == 1){
								perment = contact_details_mtr_save_list.get(i);
								contact_details_mtr_save_list.remove(i);
								break;
							}
						}
					}*/
					
					perment.setCd_city(person_save_obj.getCd_city());
					perment.setCd_country(person_save_obj.getCd_country());
					perment.setCd_emailid(person_save_obj.getCd_emailid());
					
					perment.setCd_fax(person_save_obj.getCd_fax());
					perment.setCd_no(person_save_obj.getCd_no());
					perment.setCd_id(person_save_obj.getCd_id());
					
					perment.setCd_flatname(person_save_obj.getCd_flatname());
					perment.setCd_index(2);
					perment.setCd_landmark(person_save_obj.getCd_landmark());
					perment.setCd_mobile(person_save_obj.getCd_mobile());
					perment.setCd_name(person_save_obj.getCd_name());
					perment.setCd_offphno(person_save_obj.getCd_offphno());
					perment.setCd_pincode(person_save_obj.getCd_pincode()!=null?person_save_obj.getCd_pincode():0);
					perment.setCd_phno(person_save_obj.getCd_phno());
					perment.setCd_status(1);
					perment.setCd_state(person_save_obj.getCd_state());
					perment.setCd_streetname1(person_save_obj.getCd_streetname1());
					perment.setCd_streetname2(person_save_obj.getCd_streetname2());
					perment.setCd_streetname3(person_save_obj.getCd_streetname3());
					perment.setCt_locality(person_save_obj.getCt_locality());
					perment.setCd_defult(false);
					contact_details_mtr_save_list.add(perment);
					contact_details_mtr_save_list.addAll(person_save_obj.getShipping());
					if(saveOrUpdateContactDetailsMtr(contact_details_mtr_save_list, person_id, 0)){
						HibernateUtil.commitTransaction();
						HibernateUtil.closeSession();
						return true;
					}
				
				
			
			
			  throw new Exception();
			
		}	
		catch(Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			Log.exception(e);
			return false;
		}
		
	}
	
	private   boolean saveOrUpdateContactPhone(List<ContactPhoneDTO> contact_phone_list,int person_id) 
	{
			
			 StringBuilder sql_str_buf=new StringBuilder();
			 
			 if(person_id>0)
				{
				 
					String del="delete from tb_contact_phone where cd_personid = "+person_id+" ";
					
					Query qry=session.createSQLQuery(del);
					if(qry.executeUpdate()==0){
						
					}
				}
				
			 	
					sql_str_buf.append("insert into tb_contact_phone ");
					sql_str_buf.append("	(			cd_personid, 	cd_location, ");
					sql_str_buf.append("				cd_type, 		cd_phno	  )");
					sql_str_buf.append("values( ?, ?, ?, ?   )");
					
				
							Iterator<ContactPhoneDTO> it = contact_phone_list.iterator();
							while(it.hasNext()){
								ContactPhoneDTO contact_phone_list_obj = it.next();
			Query	 qry = session.createSQLQuery(sql_str_buf.toString())
					 				   .setParameter(0, person_id)
									   .setParameter(1, contact_phone_list_obj.getCd_location())
									   
									   .setParameter(2, contact_phone_list_obj.getCd_type())
									   .setParameter(3, contact_phone_list_obj.getCd_phoneno());
									   
				if(qry.executeUpdate()==0){
					//log
					
					return false;
					
				}
			}
			
			
			return true;
		}
		
}
