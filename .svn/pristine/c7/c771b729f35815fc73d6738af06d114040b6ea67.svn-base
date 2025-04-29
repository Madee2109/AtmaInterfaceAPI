package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.bte.framework.ws.WSRequestDTO;


public class WSCodeList extends BTEWSInterfaceDBSelectQuery{

	public void run() {
		
		try {
			String sql="";
			String cl_group = "";
			if(!reqdto.getReq_json().isNull("cl_group")) {
				cl_group = reqdto.getReq_json().getString("cl_group");
			}
			sql="SELECT cl_label , cl_id,cl_alternate_id_1 FROM tb_code_list WHERE cl_flag = 1 AND cl_group = ? ";
		
		
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cl_group);
			ResultSet  rs = stmt.executeQuery();
		
			converttoStringList(finaljson, "code_list", rs);
			
		} catch (Exception e) {

			
		markError(e);
			
			
		}

		
	}
}
