package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;

import org.bte.framework.ws.WSRequestDTO;

import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

public class LabProfileMaster extends BTEWSInterfaceDBSelectQuery{


	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			String sql="";
			sql=sql+"SELECT lph_id AS lab_profile_code,lph_profile_name AS lab_profile_name "
					+ " FROM tb_lab_profile_hdr WHERE lph_active = 1 ";
		Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			 Statement stmt = conn.createStatement();
			ResultSet  rs = stmt.executeQuery(sql);
		
			 JSONArray jarr =	converttoStringList(finaljson, "lab_profile_master", rs);
			 
			for(int i=0;i<jarr.length();i++){
				JSONObject ob=jarr.getJSONObject(i);
				sql="SELECT lab_id AS lab_test_code, lab_node AS lab_test_name FROM tb_lab_profile_detail d , tb_lab_tests_mtr m "
						+ " WHERE   lpd_lab_id = lab_id AND lph_id = "+ob.getInt("lab_profile_code");
			
				  rs = stmt.executeQuery(sql);
				  converttoStringList(ob, "lab_profile_test_list", rs);
			}
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}
	/*
	public void run(WSRequestDTO reqdto) {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			Session session=HibernateUtil.getSession();
			String sql="";
			sql=sql+"SELECT lph_id AS lab_profile_code,lph_profile_name AS lab_profile_name "
					+ " FROM tb_lab_profile_hdr";
		
		
			list=session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			sql="SELECT lab_id AS lab_test_code, lab_node AS lab_test_name FROM tb_lab_profile_detail d , tb_lab_tests_mtr m "
					+ " WHERE lph_id = ? AND lpd_lab_id = lab_id ";
			for(Object ob:list) {
				Map<String,Object> map = (Map<String,Object>)ob;
				List ss=session.createSQLQuery(sql).setParameter(0, map.get("lab_profile_code")).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				map.put("lab_profile_test_list", ss);
			}
			HibernateUtil.closeSession();
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			
		}

		JSONUtil.converttoString( reqdto,"lab_profile_master_list",list);
	}
*/

}
