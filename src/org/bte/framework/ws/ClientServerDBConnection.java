package org.bte.framework.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;
public class ClientServerDBConnection {

	public static  HashMap<Integer, Connection> connectionmap = new HashMap<Integer, Connection>();
	private static Logger log = Logger.getLogger(ClientServerDBConnection.class);	
	
	public static Connection getConnection(WSUserDTO userdto) throws SQLException 
	{
		
	
			 Connection connection = connectionmap.get(userdto.getServer_id());
			 if(connection == null ){
				
				
					 
					// url = url+"?logger=com.mysql.jdbc.log.Slf4JLogger&profileSQL=true&autoReconnect=true";
						connection = DriverManager.getConnection (userdto.getDb_url(),userdto.getDb_username(),userdto.getDb_password());
						log.info("connection success"+connection);
						
						connectionmap.put(userdto.getServer_id(), connection);
					
			 }
			 return connection;
		
		
	}
}
