package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

public class PharmacyItemBatchStock extends BTEWSInterfaceDBSelectQuery {

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
				
				
			}
			String sql="";
			sql="SELECT i.item_id , item_name , mrn_item_batch_no AS item_batch_no,DATE_FORMAT(mrn_expiry_date,'%Y-%m-%d')  AS item_exp_date" + 
					",SUM(s.mrn_qty) AS item_stock_qty,mrn_mrp as item_batch_mrp , store_name,store_id,store_location" + 
					
					" FROM tb_item_mrn_summary s,tb_item_mrn_detail d , tb_item_mtr i , tb_item_store_mtr g" + 
					" WHERE s.mrn_key = d.mrn_key AND i.item_id = s.item_id AND s.mrn_qty > 0 " + 
					" AND store_id = location_code AND store_type = 1 " + condition+
					" GROUP BY s.location_code,s.item_id,mrn_item_batch_no,mrn_expiry_date,mrn_mrp" + 
					" ORDER BY item_name LIMIT 0,10 ";
	
		Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
		PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet  rs = stmt.executeQuery();
			  	converttoStringList(finaljson, "stock_list", rs);
			  
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}
}
