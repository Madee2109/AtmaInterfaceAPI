package org.bte.framework.security;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

//import sun.misc.CharacterEncoder;
public class EncryptionService 
{
	private static Logger log = Logger.getLogger(EncryptionService.class);	
	private static EncryptionService instance;
	private EncryptionService()
	{
	}

	public static String encryptPassword(String data) 
	{
		StringBuffer sb = new StringBuffer();

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(data.getBytes("UTF-8"));
			byte[] digestBytes = messageDigest.digest();
			//         sb.append(digestBytes.toString());


			String hex = null;

			for (int i = 0; i < digestBytes.length; i++) {
				//Convert it to positive integer and then to Hex String

				hex = Integer.toHexString(0xFF & digestBytes[i]);

				//Append "0" to the String to made it exactly 128 length (SHA-512 algorithm)
				if (hex.length() < 2) 
					sb.append("0");
				sb.append(hex);
			}

		}
		catch (Exception ex) {
			log.info(ex.getMessage());
		}

		return new String(sb);
	}

	public static synchronized EncryptionService getInstance() //step 1
	{
		if(instance == null)
		{
			return new EncryptionService();
		} 
		else    
		{
			return instance;
		}
	}
}
