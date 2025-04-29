package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.bte.framework.ws.WSRequestDTO;

public class DoctorMaster extends BTEWSInterfaceDBSelectQuery{

	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			String sql="";
			sql="SELECT " + 
					"person_fname AS dr_name ,person_uid AS dr_code,doc_regno AS dr_reg_no " + 
					",doc_qualification AS dr_qualification ,cl_label AS dr_sex,dept_name AS dr_speciality" + 
					" FROM tb_doctor_mtr , tb_person_mtr ,tb_comp_department_mtr ,tb_code_list" + 
					" WHERE person_id = doc_personid AND doc_engagetype in (1,2) " + 
					" AND dept_id = doc_speciality AND cl_group = 'sex' AND person_active = 1	 and person_sex  = cl_id ";
		
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			 Statement stmt = conn.createStatement();
			ResultSet  rs = stmt.executeQuery(sql);
		
			converttoStringList(finaljson, "doctor_master_list", rs);
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}
	
}
