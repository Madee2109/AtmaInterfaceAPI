package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

public class PharmacyItemMtr extends BTEWSInterfaceDBSelectQuery{




	public void run() {
	
		try {
			JSONObject json = reqdto.getReq_json();
			String condition="";
			boolean mol_search = false;
			if(!json.isNull("search_param_obj")) {
				JSONObject jsonobj = json.getJSONObject("search_param_obj");
			
				if(!jsonobj.isNull("item_id")) {
					condition = " AND i.item_id = '"+jsonobj.get("item_id").toString()+"' ";
				}
				if(!jsonobj.isNull("item_name")) {
					condition = " AND i.item_name = '"+jsonobj.getString("item_name")+"' ";
				}
				if(!jsonobj.isNull("item_name_start_with")) {
					condition = " AND i.item_name like '"+jsonobj.getString("item_name_start_with")+"%' ";
				}
				if(!jsonobj.isNull("item_name_regexp")) {
					condition = " AND i.item_name REGEXP '"+jsonobj.getString("item_name_regexp")+"' ";
				}
				if(!jsonobj.isNull("item_name_soundlike")) {
					condition = " AND i.item_name SOUNDS LIKE '"+jsonobj.getString("item_name_regexp")+"' ";
				}
				
				if(!jsonobj.isNull("item_mol_name")) {
					mol_search = true;
					condition = " AND r.drug_ref_generic_name = '"+jsonobj.getString("item_mol_name")+"' ";
				}
				if(!jsonobj.isNull("item_mol_name_start_with")) {
					mol_search = true;
					condition = " AND r.drug_ref_generic_name like '"+jsonobj.getString("item_mol_name_start_with")+"%' ";
				}
				if(!jsonobj.isNull("item_mol_name_regexp")) {
					mol_search = true;
					condition = " AND r.drug_ref_generic_name REGEXP '"+jsonobj.getString("item_mol_name_regexp")+"' ";
				}
				if(!jsonobj.isNull("item_mol_name_soundlike")) {
					mol_search = true;
					condition = " AND r.drug_ref_generic_name SOUNDS LIKE '"+jsonobj.getString("item_mol_name_soundlike")+"' ";
				}
				
			}
			String sql="";
			sql="SELECT item_id,item_name,item_cat_name AS item_category,item_hsn_code,if(item_dateofinclusion='0000-00-00',null,item_dateofinclusion) AS item_entry_date "
					+ ",(SELECT dis_unit FROM tb_item_dispensing_unit WHERE dis_id = item_uom) AS item_uom"
					+ ",dc_dosage AS item_dosage ,dc_manufacturername AS item_manufacturer"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_id =dc_category AND cl_group='DRUGCATEGORY' LIMIT 0,1) AS item_drug_category "
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_id =dc_dosage_unit AND cl_group='DRUGDOSAGE' LIMIT 0,1) AS  item_dosage_unit"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_id =dc_type AND cl_group='DRUGTYPE' LIMIT 0,1) AS  item_type"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_id =dc_intakemode AND cl_group='DRUGINTAKE' LIMIT 0,1) AS  item_intake"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_id =dc_group AND cl_group='DRUGSCHEDULE' LIMIT 0,1) AS  item_sc_group";
					
			if(mol_search) {
				sql=sql	+ ",count(dcm_comid) AS molcount "
						+ " FROM tb_item_mtr i LEFT JOIN tb_drug_com_mtr ON item_id = dc_id ,tb_item_category,tb_drug_ref_mtr r,tb_drug_com_map c "
						+ " WHERE item_cat_id = item_category  AND store_type = 1 AND item_status = 1  "
						+ " AND c.dcm_comid=i.item_id and  c.dcm_drug_ref_code=r.drug_ref_code"
						+condition+"  GROUP BY i.item_id ORDER BY item_name";
			
			}else {
				sql=sql	+ ",ifnull((SELECT count(dcm_comid) FROM tb_drug_com_map WHERE dcm_comid = item_id),0) AS molcount "
						+ " FROM tb_item_mtr i LEFT JOIN tb_drug_com_mtr ON item_id = dc_id ,tb_item_category "
						+ " WHERE item_cat_id = item_category  AND store_type = 1 AND item_status = 1  "+condition+"  ORDER BY item_name";
			}
			
	
		Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
		PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet  rs = stmt.executeQuery();
			 JSONArray jarr =	converttoStringList(finaljson, "item_list", rs);
			  sql="SELECT r.`drug_ref_code` as item_mol_code, r.drug_ref_generic_name as item_mol_name, c.dcm_strength as item_mol_str "
			  		+ " FROM tb_drug_ref_mtr r,tb_drug_com_map c where c.dcm_comid=? and  c.dcm_drug_ref_code=r.drug_ref_code";
				
			for(int i=0;i<jarr.length();i++) {
				JSONObject ob=jarr.getJSONObject(i);
				if(ob.getInt("molcount")>0) {
				 stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ob.getInt("item_id"));
				  rs = stmt.executeQuery();
				  converttoStringList(ob, "mol_list", rs);
				}
				ob.remove("molcount");
			}
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}




}
