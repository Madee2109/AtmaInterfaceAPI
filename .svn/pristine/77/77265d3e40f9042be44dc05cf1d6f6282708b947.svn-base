package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.bte.framework.ws.WSRequestDTO;
import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

public class LabOrderResultGet extends BTEWSInterfaceDBSelectQuery{




	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			String sql="";
			int loh_id=0;
			if(!reqdto.getReq_json().isNull("loh_id")) {
				loh_id = reqdto.getReq_json().getInt("loh_id");
			}
			
			sql="SELECT loh_id, DATE_FORMAT(loh_date,'%Y-%m-%d %H:%i:%s') AS loh_date,enc_apptid AS appt_id , lrh_id "
					+ "FROM tb_lab_order_header l LEFT JOIN tb_lab_result_header r ON loh_id = lrh_order_id , tb_encounter e WHERE l.enc_id = e.enc_id AND loh_id = "+loh_id;
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			Statement stmt = conn.createStatement();
			//stmt.setInt(0, loh_id);
				ResultSet  rs = stmt.executeQuery(sql);
				JSONObject jarr =	converttoObject(finaljson, "lab_order_obj", rs);
			if(jarr!=null) {
				
				sql = "SELECT lab_id AS lab_order_test_code , lod_action AS lab_order_test_status ,lod_test_done AS lab_order_done "
						+ " FROM tb_lab_order_detail,tb_lab_tests_mtr  WHERE  lab_id = lod_test_id AND loh_id="+loh_id;
				
				 stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				 JSONArray test=	converttoStringList(jarr, "lab_order_test_list", rs)	;
				
				
				if(jarr.isNull("lrh_id")==false) {
					int lrh_id =jarr.getInt("lrh_id");
					jarr.remove("lrh_id");
					
					for(int i=0;i<test.length();i++) {
						sql = "SELECT lrd_result_value AS test_prop_result,lrd_result_label AS test_prop_name,lrd_prop_id AS test_prop_code"
								+ ",lrd_uom AS test_prop_unit,lrd_normal_values AS test_prop_normal,lrd_notes AS test_prop_result_notes"
								+ " FROM tb_lab_result_detail WHERE lrh_id = "+lrh_id+" AND lrd_test_id = "+test.getJSONObject(i).getInt("lab_order_test_code")+" ORDER BY lrd_seq_no";
						
						 stmt = conn.createStatement();
							
							rs = stmt.executeQuery(sql);
							converttoStringList(test.getJSONObject(i), "lab_order_test_result", rs)	;
						
					}
				}
				
				
				sql = "SELECT DATE_FORMAT(lts_datetime,'%Y-%m-%d %H:%i:%s') AS lab_sample_taken_time,lts_name  AS lab_sample_code "
						+ " FROM tb_lab_test_sample WHERE lts_ref_id = "+loh_id;
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				converttoStringList(jarr, "lab_order_sample_list", rs)	;
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
			int loh_id=0;
			if(!reqdto.getReq_json().isNull("loh_id")) {
				loh_id = reqdto.getReq_json().getInt("loh_id");
			}
			
			sql="SELECT loh_id,loh_date,enc_apptid AS appt_id ,lrh_id "
					+ "FROM tb_lab_order_header l LEFT JOIN tb_lab_result_header r ON loh_id = lrh_order_id "
					+ ", tb_encounter e WHERE l.enc_id = e.enc_id AND loh_id = ?";
			
			list=session.createSQLQuery(sql).setParameter(0, loh_id).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			if(list.size()==1) {
				Map<String,Object> map = (Map<String,Object>)list.get(0);
				sql = "SELECT lab_id AS lab_order_test_code , lod_action AS lab_order_test_status ,lod_test_done AS lab_order_done "
						+ " FROM tb_lab_order_detail,tb_lab_tests_mtr  WHERE loh_id = ? AND lab_id = lod_test_id ";
				List ss=session.createSQLQuery(sql).setParameter(0, loh_id).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				map.put("lab_order_test_list", ss);
				if(map.get("lrh_id") !=null) {
					int lrh_id = (int) map.get("lrh_id");
					map.remove("lrh_id");
					sql = "SELECT lrd_result_value AS test_prop_result,lrd_result_label AS test_prop_name,lrd_prop_id AS test_prop_code"
							+ ",lrd_uom AS test_prop_unit,lrd_normal_values AS test_prop_normal,lrd_notes AS test_prop_result_notes"
							+ " FROM tb_lab_result_detail WHERE lrh_id = "+lrh_id+" AND lrd_test_id = ? ORDER BY lrd_seq_no";
					for(Object ob:ss) {
						Map<String,Object> map1 = (Map<String,Object>)ob;
						List ss2=session.createSQLQuery(sql).setParameter(0, map1.get("lab_order_test_code")).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
						map1.put("lab_order_test_result", ss2);
					}
				}
				sql = "SELECT DATE_FORMAT(lts_datetime,'%Y-%m-%d %H:%i:%s') AS lab_sample_taken_time,lts_name  AS lab_sample_code "
						+ " FROM tb_lab_test_sample WHERE lts_ref_id = ?";
				 ss=session.createSQLQuery(sql).setParameter(0, loh_id).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				map.put("lab_order_sample_list", ss);
			}
			HibernateUtil.closeSession();
			
		} catch (Exception e) {

			
			e.printStackTrace();
			HibernateUtil.closeSession();
			
		}

		JSONUtil.converttoStringObj( reqdto,"lab_order_obj",list);
	}


*/


}
