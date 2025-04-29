package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.primefaces.shaded.json.JSONObject;

public class PatientApptSearch extends BTEWSInterfaceDBSelectQuery{



	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			
			String sql="";
			String condition="";
			JSONObject json = reqdto.getReq_json();
			if(!json.isNull("search_param_obj")) {
				JSONObject jsonobj = json.getJSONObject("search_param_obj");
			
				
				if(!jsonobj.isNull("patient_mrdno")) {
					condition = " AND p.person_uid = '"+jsonobj.getString("patient_mrdno")+"' ";
				}
				if(!jsonobj.isNull("patient_mrdno_start_with")) {
					condition = " AND p.person_uid like '"+jsonobj.getString("patient_mrdno_start_with")+"%' ";
				}
				if(!jsonobj.isNull("patient_mrdno_regexp")) {
					condition = " AND p.person_uid REGEXP '"+jsonobj.getString("patient_mrdno_regexp")+"' ";
				}
				
				
				if(!jsonobj.isNull("fname")) {
					
					condition = " AND p.person_fname = '"+jsonobj.getString("fname")+"' ";
				}
				if(!jsonobj.isNull("fname_start_with")) {
					
					condition = " AND p.person_fname like '"+jsonobj.getString("fname_start_with")+"%' ";
				}
				if(!jsonobj.isNull("fname_regexp")) {
					
					condition = " AND p.person_fname REGEXP '"+jsonobj.getString("fname_regexp")+"' ";
				}
				if(!jsonobj.isNull("fname_soundlike")) {
				
					condition = " AND p.person_fname SOUNDS LIKE '"+jsonobj.getString("fname_soundlike")+"' ";
				}
				
			}
			
			sql=sql+"SELECT appt_id,DATE_FORMAT(appt_doregn,'%Y-%m-%d %H:%i:%s') AS appt_entry_date ,DATE_FORMAT(appt_date,'%Y-%m-%d') AS appt_date"
					+ ",TIME_FORMAT(appt_time,'%H:%i:%s') AS appt_time"
					+ ",appt_mobno AS appt_mobile_no,appt_patname AS appt_patient_name,appt_complaints AS appt_reason "
					+ ", d.person_uid AS appt_dr_code ,p.person_uid AS appt_patient_mrdno " 
					+",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'APPOINTMENTTYPE' AND cl_id =appt_category )AS appt_type "  
					+ ",(SELECT cl_label FROM tb_code_list WHERE cl_group = 'APPOINTMENTBOOKINGMODE' AND cl_id =appt_bkg_mode)AS appt_mode "
					+",(SELECT loc_name FROM tb_comp_location_mtr l,tb_comp_organization o WHERE o.org_id = a.org_id AND o.loc_id = l.loc_id)AS appt_org_loc_name "
					+" FROM tb_appointment a LEFT JOIN tb_person_mtr p ON p.person_id = appt_personid ,tb_person_mtr d  "
					+ "WHERE appt_consultantid = d.person_id "+condition+" order by appt_date,appt_time ";
		
		
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			Statement stmt = conn.createStatement();
			//stmt.setInt(0, loh_id);
				ResultSet  rs = stmt.executeQuery(sql);
				converttoStringList(finaljson, "patient_appt_list", rs);
				
			
		} catch (Exception e) {

			
			markError(e);
		
			
		}

		
	}



}
