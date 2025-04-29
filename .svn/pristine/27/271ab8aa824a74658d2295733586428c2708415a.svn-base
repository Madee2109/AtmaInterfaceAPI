package org.bte.framework.ws;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bte.core.utils.HibernateUtil;
import org.bte.core.utils.IDSequenceGenerator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class BTEWSDAOImpl {

	public  List<WSRequestDTO> getRequestList(Map<String,Object> map){
		List<WSRequestDTO> rfMenuItemDTO = new ArrayList<WSRequestDTO>();

		try {
			Session session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT ws_req_service_id,ws_req_date,ws_req_response_code,ws_req_client_ref_uid,ws_req_response_time"
					+ ",ws_req_text,ws_req_response,ws_req_id,ws_service_name,ws_service_key AS api_for "
					+ " FROM tb_ws_request LEFT JOIN tb_ws_service ON ws_req_service_id = ws_service_id WHERE 1=1 ";
		
			if(map !=null) {
				if(map.get("req_from") !=null) {
					sql = sql +" AND ws_req_date >= '"+HibernateUtil.getDateformat(map.get("req_from"))+"'";
				}
				if(map.get("req_to") !=null) {
					sql = sql +" AND ws_req_date <= '"+HibernateUtil.getDateformat(map.get("req_to"))+"'";
				}
				if(map.get("ws_req_id") !=null) {
					sql = sql +" AND ws_req_id = "+map.get("ws_req_id");
				}
				if(map.get("client_ref_no") !=null) {
					sql = sql +" AND ws_service_id like '%"+map.get("client_ref_no")+"%'";
				}
				if(map.get("api") !=null) {
					sql = sql +" AND ( ws_service_name like '%"+map.get("api")+"%' OR ws_service_key	 like '%"+map.get("api")+"%' )";
				}
			}
			sql = sql+" ORDER BY ws_req_id DESC ";
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(WSRequestDTO.class)).list();
			HibernateUtil.closeSession();
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			return null;
		}

		
		return rfMenuItemDTO;
	}
	public  List<WSServiceDTO> getServiceList(Map<String,Object> map){
		List<WSServiceDTO> rfMenuItemDTO = new ArrayList<WSServiceDTO>();

		try {
			Session session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT `ws_service_id`, `ws_service_name`, `ws_service_class`, `ws_service_method`, `ws_service_status`"
					+ ",ws_service_key ,ws_service_desc,ws_service_desc "
					+ " FROM tb_ws_service WHERE ws_service_status=1 ";
		
			if(map !=null) {
				if(map.get("ws_service_id") !=null) {
					sql = sql +" AND ws_service_id = "+map.get("ws_service_id");
				}
			}
			sql = sql+" ORDER BY ws_service_name";
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(WSServiceDTO.class)).list();
			HibernateUtil.closeSession();
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			return null;
		}

		
		return rfMenuItemDTO;
	}
	public  List<WSParamDTO> getServiceParamList(Map<String,Object> map){
		List<WSParamDTO> rfMenuItemDTO = new ArrayList<WSParamDTO>();

		try {
			Session session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT ws_param_id,ws_param_name,ws_param_type,ws_param_desc,ws_param_parent,ws_service_id,ws_param_order "
					+ ",ws_param_possible_value,ws_param_default_value,ws_param_style ,cl_alternate_id_1 AS ws_param_type_label "
					+ " FROM tb_ws_service_param,tb_code_list  WHERE ws_param_type = cl_id AND cl_group = 'ws_param_type' ";
		
			if(map !=null) {
				if(map.get("ws_service_id") !=null) {
					sql = sql +" AND ws_service_id = "+map.get("ws_service_id");
				}
			}
			sql = sql+" ORDER BY ws_param_order,ws_param_name ";
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(WSParamDTO.class)).list();
			HibernateUtil.closeSession();
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			return null;
		}

		
		return rfMenuItemDTO;
	}
	public  List<WSServiceDTO> getServiceListExample(Map<String,Object> map){
		List<WSServiceDTO> rfMenuItemDTO = new ArrayList<WSServiceDTO>();

		try {
			Session session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT ws_service_request_ex,ws_service_response_ex,ws_service_ex_id "
					+ " FROM tb_ws_service_example WHERE 1=1 ";
		
			if(map !=null) {
				if(map.get("ws_service_id") !=null) {
					sql = sql +" AND ws_service_id = "+map.get("ws_service_id");
				}
				if(map.get("ws_service_ex_id") !=null) {
					sql = sql +" AND ws_service_ex_id = "+map.get("ws_service_ex_id");
				}
			}
			
			rfMenuItemDTO=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(WSServiceDTO.class)).list();
			HibernateUtil.closeSession();
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			return null;
		}

		
		return rfMenuItemDTO;
	}
	/*public static boolean saveAuthentication(WSDTO obj){

	
		try {
			Session session=HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			

			List<LoginDTO> loginList = null;
			LoginDTO loginDTO;
			Session dbSession = HibernateUtil.getSession();
			String encPass = EncryptionService.encryptPassword(obj.getWs_password());
			String sqlQuery = "SELECT t.`login_person_id`  FROM tb_user t where t.login_id='"+obj.getWs_username()+"' and t.login_password='"+encPass+"' ";
			
			loginList = dbSession.createSQLQuery(sqlQuery).setResultTransformer(Transformers.aliasToBean(LoginDTO.class)).list();
			sqlQuery="INSERT  INTO tb_ws_authentication_request (`authentication_req_id`, `authentication_req_date`, `authentication_req_user_name`, `authentication_Id`, `authentication_errorcode`)  VALUES (?,?,?,?,?) ";
			
			
			Query qry1 = session.createSQLQuery(sqlQuery).setParameter(0, 0).setParameter(2, obj.getWs_username())
					.setParameter(1, new Date()).setParameter(3, 0).setParameter(4, 0);		
		
			if (loginList.isEmpty())
			{
				obj.setError_code(BTEWSErrorCode.ERRORCODE_LOGIN_FAILED);
				qry1.setParameter(4, BTEWSErrorCode.ERRORCODE_LOGIN_FAILED);
				qry1.executeUpdate();
				HibernateUtil.commitTransaction();;
				HibernateUtil.closeSession();
				
				return false;
			}
			 
			Iterator<LoginDTO> it = loginList.iterator();
			loginDTO = it.next();
			
			
			String sql="";
			
			sql = " SELECT `authentication_Id` FROM tb_ws_authentication ORDER BY authentication_Id DESC LIMIT 0,1  ";
			List id = dbSession.createSQLQuery(sql).list();
			if(id.size()==0 || id.get(0)==null){
				obj.setAuthentication_Id(0);
			}else {
				obj.setAuthentication_Id(Integer.parseInt(id.get(0).toString())+1);
			}
			
			sql="INSERT  INTO tb_ws_authentication (`authentication_Id`, `authentication_user_name`, `authentication_person_id`, `authentication_check_in`)  VALUES (?,?,?,?) ";
		
		
			Query qry = session.createSQLQuery(sql).setParameter(0, obj.getAuthentication_Id()).setParameter(1, obj.getWs_username())
					.setParameter(2, loginDTO.getLogin_person_id()).setParameter(3, new Date());		
			
			if (qry.executeUpdate() == 0) {
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return false;
			}
			obj.setError_code(BTEWSErrorCode.ERRORCODE_SUCCESS);
			qry1.setParameter(4, BTEWSErrorCode.ERRORCODE_SUCCESS).setParameter(3, obj.getAuthentication_Id());
			qry1.executeUpdate();
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			obj.setAuthentication_Id(0);
			return false;
		}

		
		
	
	}*/
	public  boolean saveWSResponse(WSRequestDTO obj) {


		
		try {
			Session session=HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			

			
			
		String 	sqlQuery="update tb_ws_request SET ws_req_response= ?,ws_req_response_time=?,ws_req_response_code = ?  WHERE ws_req_id="+obj.getWs_req_id();
			
			Query qry1 = session.createSQLQuery(sqlQuery)
					.setParameter(0, obj.getWs_req_response()).setParameter(1, new Date())
					.setParameter(2,obj.getWs_req_response_code());	
			qry1.executeUpdate();
			
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			
			
			return false;
		}

		
		
	
	
	}
public  List<WSServiceDTO> getWSAPI(String apifor){
	List<WSServiceDTO> list = new ArrayList<WSServiceDTO>();
		
		try {
			Session session=HibernateUtil.getSession();
			

			String sql="SELECT `ws_service_id`, `ws_service_name`, `ws_service_class`, `ws_service_method`, `ws_service_status` ,ws_service_key  "
					+ " FROM tb_ws_service WHERE ws_service_key = '"+apifor+"'";
			list=session.createSQLQuery(sql)
					.setResultTransformer(Transformers.aliasToBean(WSServiceDTO.class)).list();
			
			/*if(list.size()==1) {
				obj.setWs_req_service_id(list.get(0).getWs_service_id());
				obj.setWs_service_class(list.get(0).getWs_service_class());
			}*/
			
		
			
			
			HibernateUtil.closeSession();
			
			
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			
			
			
		}

		return list;
		
	
	}
public Map<String,WSUserDTO> getActiveToken(){


	Map<String,WSUserDTO> map = new HashMap<String,WSUserDTO>();
	try {
		Session session=HibernateUtil.getSession();
		

		String sql="SELECT client_user_server_person_id,u.client_user_id,u.client_id,server_id,u.client_user_name "
				+ ",server_http_url AS host_url,server_http_username AS host_username,server_http_password AS host_password "
				+ ",server_db_url AS db_url,server_db_username AS db_username ,server_db_password AS db_password"
				+ ",ws_token_id,ws_token_key,ws_token_end_time AS login_end_time "
				+ " FROM tb_client_user u, tb_client_server_detail s ,tb_ws_token t"
				+ " WHERE  u.client_id = s.client_id AND u.client_user_id = t. client_user_id ";
		List<WSUserDTO> list=session.createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(WSUserDTO.class)).list();
		
		for(WSUserDTO use:list){
			map.put(use.getWs_token_key(), use);
		}
		
		HibernateUtil.closeSession();
		
		
		
	} catch (Exception e) {

		
		e.printStackTrace();
		
		HibernateUtil.closeSession();
		
	}
	return map;
	
	


}
	public  boolean generatetoken(WSUserDTO userdto){

	
	try {
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		

		String sql="SELECT client_user_server_person_id,client_user_id,u.client_id,server_id "
				+ ",server_http_url AS host_url,server_http_username AS host_username,server_http_password AS host_password "
				+ ",server_db_url AS db_url,server_db_username AS db_username ,server_db_password AS db_password"
				+ " FROM tb_client_user u, tb_client_server_detail s "
				+ " WHERE server_status = 1 AND  u.client_id = s.client_id AND  client_user_name =? and client_user_password = ?";
		List<WSUserDTO> list=session.createSQLQuery(sql)
				.setParameter(0, userdto.getClient_user_name())
				.setParameter(1, userdto.getClient_user_password())
				.setResultTransformer(Transformers.aliasToBean(WSUserDTO.class)).list();
		
		if(list.size()==1) {
			userdto.setClient_id(list.get(0).getClient_id());
			userdto.setClient_user_id(list.get(0).getClient_user_id());
			userdto.setClient_user_server_person_id(list.get(0).getClient_user_server_person_id());
			userdto.setServer_id(list.get(0).getServer_id());
			userdto.setHost_url(list.get(0).getHost_url());
			userdto.setHost_username(list.get(0).getHost_username());
			userdto.setHost_password(list.get(0).getHost_password());
			userdto.setDb_url(list.get(0).getDb_url());
			userdto.setDb_password(list.get(0).getDb_password());
			userdto.setDb_username(list.get(0).getDb_username());
			
		}else{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			return false;
		}
		
		 int id = IDSequenceGenerator.getNextSequenceInt("tb_ws_token");
		 String key =userdto.getClient_user_name()+"-"+id;
		 Date date = new Date();
		 Calendar cal =Calendar.getInstance();
		 cal.setTime(new Date());
		 cal.add(Calendar.DATE, 1);
		
	String 	sqlQuery="INSERT  INTO tb_ws_token "
			+ "(ws_token_id,ws_token_key,ws_token_gen_date,ws_token_end_time,client_user_id)  VALUES (?,?,?,?,?) ";
		
		
		Query qry1 = session.createSQLQuery(sqlQuery)
				.setParameter(0, id).setParameter(1, key)
				.setParameter(2, date).setParameter(3, cal.getTime()).setParameter(4, userdto.getClient_user_id());	
		qry1.executeUpdate();
		userdto.setWs_token_id(id);
		userdto.setWs_token_key(key);
		 userdto.setLogin_end_time(cal.getTime());
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		
		return true;
		
	} catch (Exception e) {

		
		e.printStackTrace();
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
		return false;
	}

	
	

}
	public  boolean saveWSRequest(WSRequestDTO obj){

		
		try {
			Session session=HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			

			/*String sql="SELECT `ws_service_id`, `ws_service_name`, `ws_service_class`, `ws_service_method`, `ws_service_status` ,ws_service_key  "
					+ " FROM tb_ws_service WHERE ws_service_key = '"+ obj.getApi_for()+"'";
			List<WSServiceDTO> list=session.createSQLQuery(sql)
					.setResultTransformer(Transformers.aliasToBean(WSServiceDTO.class)).list();
			
			if(list.size()==1) {
				obj.setWs_req_service_id(list.get(0).getWs_service_id());
				obj.setWs_service_class(list.get(0).getWs_service_class());
			}
			
			*/
		String 	sqlQuery="INSERT  INTO tb_ws_request "
				+ "(`ws_req_id`, `ws_req_date`, `ws_req_server_id`, `ws_req_service_id`, `ws_req_client_id`"
				+ ",ws_req_status,ws_req_text,ws_req_response,ws_req_response_code,ws_req_client_ref_uid"
				+ ",ws_req_client_user_id,ws_req_token_id,ws_req_ipaddress,ws_req_session_id) "
				+ "  VALUES (?,?,?,?,?  ,?,?,?,?,?	,?,?,?,?) ";
			
			
			Query qry1 = session.createSQLQuery(sqlQuery)
					.setParameter(0, obj.getWs_req_id()).setParameter(1, obj.getWs_req_date())
					.setParameter(2, obj.getWs_req_server_id()).setParameter(3,  obj.getWs_req_service_id())
					.setParameter(4,  obj.getWs_req_client_id()).setParameter(5,  obj.getWs_req_status())
					.setParameter(6,  obj.getWs_req_text())
					.setParameter(7,  obj.getWs_req_response())
					.setParameter(8,  obj.getWs_req_response_code())
					.setParameter(9,  obj.getWs_req_client_ref_uid())
					.setParameter(10,  obj.getWs_req_client_user_id())
					.setParameter(11,  obj.getWs_req_token_id())
					.setParameter(12,  obj.getWs_req_ipaddress())
					.setParameter(13,  obj.getWs_req_session_id());	
			qry1.executeUpdate();
			
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			
			
			return false;
		}

		
		
	
	}
	
	public WSUserDTO validateUserAccess(String username , String password) {


		
		try {
			Session session=HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			

			String sql="SELECT client_user_id , client_id,server_http_url "
					+ " FROM tb_client_user u,tb_client_server_detail s"
					+ " WHERE u.client_id= s.client _id AND server_status =1 AND client_user_name = ?";
			List<WSServiceDTO> list=session.createSQLQuery(sql).setParameter(0, username)
					.setResultTransformer(Transformers.aliasToBean(WSServiceDTO.class)).list();
			
			if(list.size()==1) {
				
			}
			
			
			return null;
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			
			
			return null;
		}

		
		
	
	
	}
	
	
}
