package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;

import org.bte.framework.ws.WSRequestDTO;
import org.primefaces.shaded.json.JSONObject;

public class PatientRegGet extends BTEWSInterfaceDBSelectQuery {

	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			
			String sql="";
			String patient_mrdno="";
			if(!reqdto.getReq_json().isNull("patient_mrdno")) {
				patient_mrdno = reqdto.getReq_json().getString("patient_mrdno");
			}
			
			sql="SELECT person_id , person_fname AS fname, person_mname AS mname, person_lname AS lname,person_uid AS patient_mrdno "
					+ ",person_fat_hus_name AS fat_hus_name, person_mot_wife_name AS mot_wife_name"
					+ ", DATE_FORMAT(person_dob,'%Y-%m-%d') AS patient_dob ,DATE_FORMAT(person_datereg,'%Y-%m-%d') AS patient_dor "
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'SEX' AND cl_id = person_sex) AS patient_sex"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'PATIENTTYPE' AND cl_id = pt_typeofpat) AS patient_type"
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'TITLE' AND cl_id = person_title) AS patient_title "
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'MARITALSTATUS' AND cl_id = person_marital_status ) AS marital_status "
					+ " ,cd_mobile AS mobile_no,cd_phno AS phone_no,cd_emailid AS patient_email "
					//+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = '' AND cl_id = ) AS "
					+ " FROM  tb_person_mtr m LEFT JOIN tb_contactdetails_mtr ON cd_personid = person_id AND cd_index = 1,tb_patient_mtr d  "
					+ "WHERE person_id = pt_personid AND person_uid = '"+patient_mrdno+"' LIMIT 0,1 ";
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			Statement stmt = conn.createStatement();
			//stmt.setInt(0, loh_id);
				ResultSet  rs = stmt.executeQuery(sql);
				JSONObject jarr =	converttoObject(finaljson, "patient_information_obj", rs);
				
		
			if(jarr!=null) {
			
			sql="SELECT cd_no AS address_doorno,cd_streetname1 AS address_street_1,cd_streetname2 AS address_street_2"
					+ ",cd_flatname AS address_flat_name,ct_locality AS address_locality,cd_city AS address_city, cd_pincode AS address_pincode"
					+ ",if(cd_index=1,'Permanent','Temporary') AS address_type " 
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'STATES' AND cl_id = cd_state) AS address_state "
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'COUNTRY' AND cl_id = cd_country ) AS address_country "
					
					+" FROM tb_contactdetails_mtr WHERE cd_personid ="+jarr.getInt("person_id");
			
				  rs = stmt.executeQuery(sql);
			converttoStringList(jarr, "address_list", rs);
			}
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}

}
