package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.primefaces.shaded.json.JSONObject;

public class PatientRegSearch extends BTEWSInterfaceDBSelectQuery{

	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			
			String sql="";
			JSONObject json = reqdto.getReq_json();
			String condition="";
			boolean mol_search = false;
			if(!json.isNull("search_param_obj")) {
				JSONObject jsonobj = json.getJSONObject("search_param_obj");
			
				
				if(!jsonobj.isNull("patient_mrdno")) {
					condition = " AND person_uid = '"+jsonobj.getString("patient_mrdno")+"' ";
				}
				if(!jsonobj.isNull("patient_mrdno_start_with")) {
					condition = " AND person_uid like '"+jsonobj.getString("patient_mrdno_start_with")+"%' ";
				}
				if(!jsonobj.isNull("patient_mrdno_regexp")) {
					condition = " AND person_uid REGEXP '"+jsonobj.getString("patient_mrdno_regexp")+"' ";
				}
				
				
				if(!jsonobj.isNull("fname")) {
					mol_search = true;
					condition = " AND person_fname = '"+jsonobj.getString("fname")+"' ";
				}
				if(!jsonobj.isNull("fname_start_with")) {
					mol_search = true;
					condition = " AND person_fname like '"+jsonobj.getString("fname_start_with")+"%' ";
				}
				if(!jsonobj.isNull("fname_regexp")) {
					mol_search = true;
					condition = " AND person_fname REGEXP '"+jsonobj.getString("fname_regexp")+"' ";
				}
				if(!jsonobj.isNull("fname_soundlike")) {
					mol_search = true;
					condition = " AND person_fname SOUNDS LIKE '"+jsonobj.getString("fname_soundlike")+"' ";
				}
				
			}
			
			
			sql="SELECT person_id , person_fname AS fname, person_mname AS mname, person_lname AS lname,person_uid AS patient_mrdno "
					+ ",person_fat_hus_name AS fat_hus_name, person_mot_wife_name AS mot_wife_name"
					+ ", DATE_FORMAT(person_dob,'%Y-%m-%d') AS patient_dob ,DATE_FORMAT(person_datereg,'%Y-%m-%d') AS patient_dor "
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'SEX' AND cl_id = person_sex) AS patient_sex"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'PATIENTTYPE' AND cl_id = pt_typeofpat) AS patient_type"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'TITLE' AND cl_id = person_title) AS patient_title "
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'MARITALSTATUS' AND cl_id = person_marital_status ) AS marital_status "
					+ " ,cd_mobile AS mobile_no,cd_phno AS phone_no,cd_emailid AS patient_email "
					
					+ " FROM  tb_person_mtr m LEFT JOIN tb_contactdetails_mtr ON cd_personid = person_id AND cd_index = 1,tb_patient_mtr d  "
					+ "WHERE person_id = pt_personid "+condition+" ORDER BY person_uid ";
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			Statement stmt = conn.createStatement();
			//stmt.setInt(0, loh_id);
				ResultSet  rs = stmt.executeQuery(sql);
					converttoStringList(finaljson, "patient_list", rs);
				
		
			
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}
}
