package org.bte.framework.security;

import java.util.Stack;

import javax.servlet.http.HttpSession;

import org.bte.core.utils.CodeList;



public class LoginDTO 
{
	String login_password;
	String login_confirm_password;
	String login_old_password;
	String login_id;
	Integer login_person_id;
	Integer person_title;
	String person_fname;
	String person_mname;
	String person_lname;
	Integer login_person_role;
	Integer login_person_department;
	private Integer user_login_id;
	private int org_id;
	Integer login_person_company;
	String login_ip_address;
	String login_ip_machine;
	String trnPwd;
	private String company_code;
	private String dept_name;
	private String login_def_landing_page;
	private String loc_name;
	private int login_audit_id;
	private HttpSession session;
	
	private Stack<String> nav_pageList = new   Stack<String>();
	public boolean backbutton;
	public String backbutton_value;
	private String error_msg;
	private long session_timeout;
	private long last_access_time;
	private boolean session_timeout_flag;
	private String login_geolocation;
	private String session_id;
	private int person_type;
	
	public String getTrnPwd() {
		return trnPwd;
	}
	public void setTrnPwd(String trnPwd) {
		this.trnPwd = trnPwd;
	}	
	
	public String getLogin_ip_address() {
		return login_ip_address;
	}
	public void setLogin_ip_address(String loginIpAddress) {
		login_ip_address = loginIpAddress;
	}
	public String getLogin_ip_machine() {
		return login_ip_machine;
	}
	public void setLogin_ip_machine(String loginIpMachine) {
		login_ip_machine = loginIpMachine;
	}
	public Integer getLogin_person_company() {
		return login_person_company;
	}
	public void setLogin_person_company(Integer loginPersonCompany) {
		login_person_company = loginPersonCompany;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int orgId) {
		org_id = orgId;
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
		return login_person_department;
	}
	
	public Integer getLogin_person_department() {
		return login_person_department;
	}
	public void setLogin_person_department(Integer loginPersonDepartment) {
		login_person_department = loginPersonDepartment;
	}
	public void setPerson_fname(String personFname) 
	{
		person_fname = personFname;
	}
	public String getPerson_fname()
	{
		return person_fname;
	}
	public void setPerson_mname(String personMname) 
	{
		person_mname = personMname;
	}
	public void setPerson_lname(String personLname) 
	{
		person_lname = personLname;
	}
	public String getPersonName()
	{
		String name = person_fname;
		if (person_title > 0 )
			name = CodeList.getLabelFromCode("SALUTION", person_title) + name;
		if (person_lname != null)
			name = name + " " + person_lname;
		return name;
	}
	public void setUser_login_id(Integer user_login_id) {
		this.user_login_id = user_login_id;
	}
	public Integer getUser_login_id() {
		return user_login_id;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getLogin_def_landing_page() {
		return login_def_landing_page;
	}
	public void setLogin_def_landing_page(String login_def_landing_page) {
		this.login_def_landing_page = login_def_landing_page;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	public int getLogin_audit_id() {
		return login_audit_id;
	}
	public void setLogin_audit_id(int login_audit_id) {
		this.login_audit_id = login_audit_id;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	public Stack<String> getNav_pageList() {
		return nav_pageList;
	}
	public void setNav_pageList(Stack<String> nav_pageList) {
		this.nav_pageList = nav_pageList;
	}
	public long getSession_timeout() {
		return session_timeout;
	}
	public void setSession_timeout(long session_timeout) {
		this.session_timeout = session_timeout;
	}
	public long getLast_access_time() {
		return last_access_time;
	}
	public void setLast_access_time(long last_access_time) {
		this.last_access_time = last_access_time;
	}
	public boolean isSession_timeout_flag() {
		return session_timeout_flag;
	}
	public void setSession_timeout_flag(boolean session_timeout_flag) {
		this.session_timeout_flag = session_timeout_flag;
	}
	public String getLogin_confirm_password() {
		return login_confirm_password;
	}
	public void setLogin_confirm_password(String login_confirm_password) {
		this.login_confirm_password = login_confirm_password;
	}
	public String getLogin_old_password() {
		return login_old_password;
	}
	public void setLogin_old_password(String login_old_password) {
		this.login_old_password = login_old_password;
	}
	public String getLogin_geolocation() {
		return login_geolocation;
	}
	public void setLogin_geolocation(String login_geolocation) {
		this.login_geolocation = login_geolocation;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public int getPerson_type() {
		return person_type;
	}
	public void setPerson_type(int person_type) {
		this.person_type = person_type;
	}
	
}
