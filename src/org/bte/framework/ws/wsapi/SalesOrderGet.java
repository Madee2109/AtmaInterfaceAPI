package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.primefaces.shaded.json.JSONObject;

public class SalesOrderGet extends BTEWSInterfaceDBSelectQuery{





	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			String sql="";
			String coh_order_no="";
			if(!reqdto.getReq_json().isNull("coh_order_no")) {
				coh_order_no = reqdto.getReq_json().getString("coh_order_no");
			}
			
			sql="SELECT loh_id,coh_print_no AS coh_order_no, DATE_FORMAT(coh_date,'%Y-%m-%d %H:%i:%s') AS coh_date,coh_note,coh_replace_notes"
					+ ",enc_apptid AS appt_id "
					+ ""
					+ " FROM tb_customer_order_header l , tb_encounter e "
					+ " WHERE l.coh_enc_id = e.enc_id AND coh_print_no = '"+coh_order_no+"'";
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			Statement stmt = conn.createStatement();
			//stmt.setInt(0, loh_id);
				ResultSet  rs = stmt.executeQuery(sql);
				JSONObject jarr =	converttoObject(finaljson, "sales_order_obj", rs);
			if(jarr!=null) {
				
				sql = "SELECT cod_item_id,cod_qty AS cod_order_qty,cod_notes "
						+ " FROM tb_customer_order_detail  WHERE   loh_id="+jarr.getInt("loh_id");
				
				 stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				jarr.remove("loh_id");
				converttoStringList(jarr, "sales_order_item_list", rs)	;
				
			}
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}





}
