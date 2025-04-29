package org.bte.framework.security;

import org.bte.core.utils.CodeList;

public class tb_user {
	String login_password;
	String login_id;
	Integer login_person_id;	
	Integer login_person_role;
	Integer login_person_speciality;
	String role_login_id;
	int user_login_id;
	String trnPwd;
	
	public String getTrnPwd() {
		return trnPwd;
	}
	public void setTrnPwd(String trnPwd) {
		this.trnPwd = trnPwd;
	}	

	public String getLogin_password() 
	{
		return login_password;
	}
	public void setLogin_password(String loginPassword) 
	{
		login_password = loginPassword;
	}
	public String getLogin_id() 
	{
		return login_id;
	}
	public void setLogin_id(String loginId) 
	{
		login_id = loginId;
	}
	public Integer getLogin_person_id() 
	{
		return login_person_id;
	}
	public void setLogin_person_id(Integer loginPersonId) 
	{
		login_person_id = loginPersonId;
	}
	public Integer getLogin_person_role() 
	{
		return login_person_role;
	}
	public void setLogin_person_role(Integer loginPersonRole) 
	{
		login_person_role = loginPersonRole;
	}
	public void setLogin_person_role(String loginPersonRole) 
	{
		login_person_role = CodeList.getCodeFromLabel("USERROLE",loginPersonRole);;
	}

	public Integer getLogin_person_speciality() 
	{
		return login_person_speciality;
	}
	public void setLogin_person_speciality(Integer loginPersonSpeciality) 
	{
		login_person_speciality = loginPersonSpeciality;
	}
	public void setLogin_person_speciality(String loginPersonSpeciality) 
	{
		login_person_speciality = CodeList.getCodeFromLabel("USERSPECIALITY", loginPersonSpeciality);
	}
	public void setRole_login_id(String role_login_id) {
		this.role_login_id = role_login_id;
	}
	public String getRole_login_id() {
		return role_login_id;
	}
	public void setUser_login_id(int user_login_id) {
		this.user_login_id = user_login_id;
	}
	public int getUser_login_id() {
		return user_login_id;
	}


}
