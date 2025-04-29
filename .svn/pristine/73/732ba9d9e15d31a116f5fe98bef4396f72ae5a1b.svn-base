package org.bte.framework.ws;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

public class JSONUtil {

	
	public static String converttoString(Map<String, Object> obj) {
		String a="";
		if(obj==null || obj.size()==0) {
			return "{}";
		}
		
		for(Map.Entry<String, Object> ob:obj.entrySet()) {
			Object val = ob.getValue();
			a=a+",\""+ob.getKey()+"\": ";
			if(val==null) {
				a=a+"\"\"";
			}else if(val instanceof Boolean) {
				a=a+(((Boolean)val)?1:0);
			}else if(val instanceof Integer) {
				a=a+val.toString();
			}else if(val instanceof Double) {
				a=a+val.toString();
			}else if(val instanceof Date) {
				a=a+"\""+ob.getValue()+"\"";
			}else if(val instanceof List) {
				a=a+converttoString((List)val);
			}else{
				a=a+"\""+ob.getValue()+"\"";
			}
		}
		a=a.substring(1);
		a="{"+a+"}";
		return a;
	}
	public static void converttoStringList(JSONObject reqdto,String key ,ResultSet rs) {
		try{
		 ResultSetMetaData rsmd = rs.getMetaData();
		
		 JSONArray jarr = new JSONArray();
		    while(rs.next()) {
		      int numColumns = rsmd.getColumnCount();
		      JSONObject obj = new JSONObject();

		      for (int i=1; i<numColumns+1; i++) {
		        String column_name = rsmd.getColumnName(i);

		        if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
		         obj.put(column_name, rs.getArray(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
		         obj.put(column_name, rs.getBoolean(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
		         obj.put(column_name, rs.getBlob(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
		         obj.put(column_name, rs.getDouble(column_name)); 
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
		         obj.put(column_name, rs.getFloat(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
		         obj.put(column_name, rs.getNString(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
		         obj.put(column_name, rs.getString(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
		         obj.put(column_name, rs.getDate(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
		        obj.put(column_name, rs.getTimestamp(column_name));   
		        }
		        else{
		         obj.put(column_name, rs.getObject(column_name));
		        }
		      }

		      jarr.put(obj);
		    }
		    reqdto.put(key, jarr);

		}catch(Exception e){
			
		}
		
	}
public static void converttoString(WSRequestDTO reqdto,String key ,List list) {
		String a = converttoString(list);
		String txt = "{\"response_code\" : 1,\"ws_req_id\":"+reqdto.getWs_req_id()+","
				+ "\""+key+"\":"+a +"}";
		reqdto.setWs_req_response(txt);
	}
public static void converttoStringObj(WSRequestDTO reqdto,String key ,List list) {
	Map map = (Map)list.get(0); 
	String a = converttoString(map);
	String txt = "{\"response_code\" : 1,\"ws_req_id\":"+reqdto.getWs_req_id()+","
			+ "\""+key+"\":"+a +"}";
	reqdto.setWs_req_response(txt);
}
	public static String converttoString(List list) {
		
		if(list==null || list.size()==0) {
			return "[]";
		}
		String a="";
		
		for(Object ob:list) {
			Map map = (Map)ob; 
			a = a+","+converttoString(map);
		}
		a=a.substring(1);
		a="["+a+"]";
		return a;
	}

}
