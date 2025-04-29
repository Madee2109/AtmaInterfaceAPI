package org.bte.framework.ws;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.bte.core.utils.CodeList;
import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONException;
import org.primefaces.shaded.json.JSONObject;

public abstract class BTEWSInterfaceDBSelectQuery implements BTEWSInterface{
String errormsg;
	int response_code = 1;
	JSONObject response = new JSONObject();
	 public JSONObject finaljson = new JSONObject();
	public  WSRequestDTO reqdto=null;
	 HttpServletRequest req;
	 ServletResponse res;
	 public boolean inital(WSRequestDTO reqdto,HttpServletRequest req,ServletResponse res) {
		this.reqdto = reqdto;
		this.req =req;
		this.res = res;
		return true;
	}

	

	public void markError(Exception e){
		response_code = 4;
		errormsg = e.getMessage();
		e.printStackTrace();
	}
	public void getResponse() {
		response.put("ws_req_id", reqdto.getWs_req_id());
		response.put("response_code", response_code);
		response.put("response_msg", CodeList.getAlternateIdFromCode("ws_req_response_code", response_code));
		if(response_code==1) {
			
			response.put("response_data", finaljson);
		}else {
			
			response.put("response_msg_desc", errormsg);
			
		}
		reqdto.setWs_req_response_code(response_code);
		reqdto.setWs_req_response(response.toString());
		
	}
	public void writeResult() {
		try {
			
			
			res.setContentType("application/json");
			res.getOutputStream().write(reqdto.getWs_req_response().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getField(JSONObject obj,String column_name,int type,ResultSet rs) throws JSONException, SQLException {
		 if(type==java.sql.Types.ARRAY){
	         obj.put(column_name, rs.getArray(column_name));
	        }
	        else if(type==java.sql.Types.BIGINT){
	         obj.put(column_name, rs.getInt(column_name));
	        }
	        else if(type==java.sql.Types.BOOLEAN){
	        	int a= rs.getBoolean(column_name)?1:0;
	         obj.put(column_name, a);
	        }
	        else if(type==java.sql.Types.BLOB){
	         obj.put(column_name, rs.getBlob(column_name));
	        }
	        else if(type==java.sql.Types.DOUBLE){
	         obj.put(column_name, rs.getDouble(column_name)); 
	        }
	        else if(type==java.sql.Types.FLOAT){
	         obj.put(column_name, rs.getFloat(column_name));
	        }
	        else if(type==java.sql.Types.INTEGER){
	         obj.put(column_name, rs.getInt(column_name));
	        }
	        else if(type==java.sql.Types.NVARCHAR){
	         obj.put(column_name, rs.getNString(column_name));
	        }
	        else if(type==java.sql.Types.VARCHAR){
	         obj.put(column_name, rs.getString(column_name));
	        }
	        else if(type==java.sql.Types.TINYINT){
	         obj.put(column_name, rs.getInt(column_name));
	        }
	        else if(type==java.sql.Types.SMALLINT){
	         obj.put(column_name, rs.getInt(column_name));
	        }
	        else if(type==java.sql.Types.DATE){
	         obj.put(column_name, rs.getDate(column_name));
	        }
	        else if(type==java.sql.Types.TIMESTAMP){
	        obj.put(column_name, rs.getTimestamp(column_name));   
	        } else if(type==java.sql.Types.BIT){
	        	int a= rs.getBoolean(column_name)?1:0;
	         obj.put(column_name, a);
	        }
	        else{
	         obj.put(column_name, rs.getObject(column_name));
	        }
	}
	public  JSONArray converttoStringList(JSONObject reqdto,String key,ResultSet rs) {
		 JSONArray jarr = new JSONArray();
		try{
		 ResultSetMetaData rsmd = rs.getMetaData();
		
		
		    while(rs.next()) {
		      int numColumns = rsmd.getColumnCount();
		      JSONObject obj = new JSONObject();

		      for (int i=1; i<numColumns+1; i++) {
			         String column_name = rsmd.getColumnLabel(i);
		        getField(obj,column_name,rsmd.getColumnType(i),rs);
		       
		      }
		     
		      jarr.put(obj);
		    }
		   
		    reqdto.put(key, jarr);

		}catch(Exception e){
			e.printStackTrace();
		}
		return jarr;
	}
	public  JSONObject converttoObject(JSONObject reqdto,String key,ResultSet rs) {
		 JSONObject jarr =null;
		try{
		 ResultSetMetaData rsmd = rs.getMetaData();
		
		
		    while(rs.next()) {
		    	jarr = new JSONObject();
		      int numColumns = rsmd.getColumnCount();
		     

		      for (int i=1; i<numColumns+1; i++) {
		        String column_name = rsmd.getColumnLabel(i);
		        getField(jarr,column_name,rsmd.getColumnType(i),rs);
		        
		      }
		      reqdto.put(key, jarr);
		     
		    }
		   
		   

		}catch(Exception e){
			e.printStackTrace();
		}
		return jarr;
	}

	
	

	
}
