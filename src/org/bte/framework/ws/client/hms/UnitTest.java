package org.bte.framework.ws.client.hms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.mail.search.AddressStringTerm;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class UnitTest {
public static String AddString(String key,String value){
	return "\""+key+"\":\""+value+"\"";
}
public static String AddString(String key,int value){
	return "\""+key+"\":\""+value+"\"";
}
	public static void main(String arg[]) throws MalformedURLException, IOException {
		
		URLConnection connection = new URL("http://192.168.29.100:8080/AtmaInterfaceAPI/wsservice").openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json" );
		
		
		String patient_reg_insert="";
		//patient_reg_insert = patient_reg_insert+AddString("patient_mrdno", "AR22070008")+",";
		patient_reg_insert = patient_reg_insert+AddString("patient_title", "Mr")+",";
		patient_reg_insert = patient_reg_insert+AddString("fname", "ashok Kumar")+",";
		patient_reg_insert = patient_reg_insert+AddString("mname", "")+",";
		patient_reg_insert = patient_reg_insert+AddString("lname", "")+",";
		patient_reg_insert = patient_reg_insert+AddString("fat_hus_name", "")+",";
		patient_reg_insert = patient_reg_insert+AddString("marital_status", "single")+",";
		patient_reg_insert = patient_reg_insert+AddString("patient_sex", "male")+",";
		patient_reg_insert = patient_reg_insert+AddString("patient_dob", "1990-05-05")+",";
		patient_reg_insert = patient_reg_insert+AddString("patient_dor", "1990-05-05")+",";
		patient_reg_insert = patient_reg_insert+AddString("mot_wife_name", "ashok")+",";
		patient_reg_insert = patient_reg_insert+AddString("mobile_no", "9500018180")+",";
		patient_reg_insert = patient_reg_insert+AddString("patient_type", "normal")+",";
		String address = "";
		address = address+AddString("address_type", "param")+",";
		address = address+AddString("address_doorno", "Mr")+",";
		address = address+AddString("address_flat_name", "Mr")+",";
		address = address+AddString("address_street_1", "Mr")+",";
		address = address+AddString("address_street_2", "Mr")+",";
		address = address+AddString("address_pincode", 600066)+",";
		address = address+AddString("address_city", "Mr")+",";
		address = address+AddString("address_state", "Bihar")+",";
		address = address+AddString("address_country", "COUNTRY");
		address="{"+address+"}";
		address="["+address.replace("param", "Permanent")+","+address.replace("param", "Temporary")+"]";
		patient_reg_insert= patient_reg_insert+"\"address_list\":"+address+"";
		
		String appt = "";
		appt = appt+AddString("appt_date", "1990-05-05")+",";
		appt = appt+AddString("appt_time", "13:20:00")+",";
		appt = appt+AddString("appt_type", "Consultation")+",";
		appt = appt+AddString("appt_for", "New Patient")+",";
		appt = appt+AddString("appt_dr_code", "D11")+",";
		appt = appt+AddString("appt_patient_mrdno", "AR22070008")+",";
		appt = appt+AddString("appt_mobile_no", "1990-05-05")+",";
		appt = appt+AddString("appt_mode", "online")+",";
		appt = appt+AddString("appt_reason", "704409")+",";
		appt = appt+AddString("appt_patient_name", "1990-05-05")+",";
		appt = appt+AddString("appt_entry_date", "1990-05-05")+",";
		appt = appt+AddString("appt_org_loc_name", "egmore")+",";
		appt = appt+AddString("appt_patient_center_name", "egmore")+",";
		
		String re="{" + 
				"\"client_id\" : \"atma-arh-diahome\"," + 
				"\"client_aut_token\" : \"atma-arh-diahome-102\"," + 
				//"api_for\" : \"patient_reg_insert\"," + "\"patient_information_obj\" : {"+patient_reg_insert+"}"+
				//"\"api_for\" : \"patient_reg_update\"," + "\"patient_information_obj\" : {"+patient_reg_insert+"}"+
				//"\"api_for\" : \"patient_appt_cancel\"," + "\"appt_id\" : 704397"+
				//"\"api_for\" : \"patient_appt_insert\"," + "\"patient_appt_obj\" : {"+appt+"}"+
				//"\"api_for\" : \"patient_appt_update\"," + "\"patient_appt_obj\" : {"+appt+AddString("appt_id", 704409)+"}"+
				//"\"api_for\" : \"patient_appt_checkin\"," + "\"patient_checkin_obj\":{\"appt_id\" : 704401}"+
				"\"api_for\" : \"doctor_master\""+
				"}";

		try (OutputStream output = connection.getOutputStream()) {
		    output.write(re.getBytes());	
		}catch(Exception e) {
			e.printStackTrace();
		}

		InputStream response = connection.getInputStream();
		String result = IOUtils.toString(response);
		System.out.println(re); 
		System.out.println("---------------------------------------------------");
		System.out.println(result);
		
		/*
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://localhost:8080/btecMC2Atma/wsservice");

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("ws_req_id", "12345"));
		params.add(new BasicNameValuePair("param-2", "Hello!"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		        // do something useful
		    }
		}*/
	}
}
