package org.bte.framework.ws.client.hms;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class Test {

	public static void main(String arg[])  {
		

		try  {

			URLConnection connection = new URL("http://192.168.29.100:8080/AtmaInterfaceAPI/wsservice").openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json" );
			String re="{" + 
					"\"client_id\" : \"atma-arh-diahome\"," + 
					"\"client_aut_token\" : \"atma-arh-diahome-102\"," + 
					"\"api_for\" : \"doctor_master\""+
					"}";
			OutputStream output = connection.getOutputStream();
		    output.write(re.getBytes());	
		    InputStream response = connection.getInputStream();
			String result = IOUtils.toString(response);
			System.out.println(re); 
			System.out.println("---------------------------------------------------");
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		
		
	}
}
