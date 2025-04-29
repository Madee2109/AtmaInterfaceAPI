package org.bte.bean;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.bte.core.person.staff.StaffService;
import org.bte.framework.error.Log;
import org.bte.framework.faces.FacesService;
import org.bte.framework.faces.FacesServicePrimeFaces;
import org.bte.framework.security.LoginDTO;
import org.bte.framework.security.LoginService;

@ManagedBean ( name = "login" )
@ViewScoped
public class login
 {
	private boolean showsidepanel;
	private String userName;
	private String userPassword;
	private Integer userSpeciality;
	private String userSpecialityName;
	private Integer userRole;
	private UserContext userContext;	
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirm;
	private String errorMessage;
	private String passwordChangeMessage;	
	private String loc_name;
	private String userrole_label;
	private String message;
	private String return_value;
	
	private String companycode;
	public Map<String,String> config_org = new HashMap<String,String>();
	
	private int temp_userrole;
	private String temp_pagename;
	private String focus = "inForm:username";
	private List<String> imagelist;
	private String geolocationmessage;
	private int geolocation_flag;
	public login() {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	
	/*ApplicationBean appbean =  facesContext.getApplication()
				.evaluateExpressionGet(facesContext, "#{ApplicationBean}", ApplicationBean.class);
		
		
		imagelist = new ArrayList<String>();
		for(String token : appbean.config.get("application-banner").split(";")) {
			imagelist.add(token);
		}
		geolocation_flag = Integer.parseInt(appbean.config.get("application-geolocation"));
*/	}
	
	


	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	

	public String getReturn_value() {
		return return_value;
	}

	public void setReturn_value(String return_value) {
		this.return_value = return_value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
	

	public void setPasswordChangeMessage(String passwordChangeMessage) {
		this.passwordChangeMessage = passwordChangeMessage;
	}

	public String getPasswordChangeMessage() {
		return passwordChangeMessage;
	}

	public String getErrorMessage() 
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}
	public String getOldPassword() 
	{
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) 
	{
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() 
	{
		return newPassword;
	}

	public void setNewPassword(String newPassword) 
	{
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirm() 
	{
		return newPasswordConfirm;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) 
	{
		this.newPasswordConfirm = newPasswordConfirm;
	}

	public UserContext getUserContext() 
	{
		 return userContext;
		}

	public void setUserContext(UserContext userContext) 
	{
	 this.userContext = userContext;    
	}
   
    public String getUserName() 
	 {
        return userName;
     }
	
	public void setUserName(String username) 
	 {
        this.userName = username;
     }
	 
	public String getUserPassword() 
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}

	public Integer getUserSpeciality() 
	{
		return userSpeciality;
	}

	public void setUserSpeciality(Integer userSpeciality) 
	{
		this.userSpeciality = userSpeciality;
	}

	public Integer getUserRole() {
		
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public void logout(){
		
		LoginService.logout();
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		String page = "/";
			try {
				facesContext.getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+page);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.exception(e);
			}

	}
	public void actionname1(){
		
	}
//button action start
public String actionname()  
 { 	
	
	 
	passwordChangeMessage="";
	errorMessage="";
	oldPassword="";
	newPassword="";
	newPasswordConfirm="";
	
	//usercontext.setUserName(getusername());
	//usercontext.setUserSpeciality(getspeciality());
	try
	{
		
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		 
		//baseurl = baseurl==null?"":baseurl.toString();
		if (userName.isEmpty())
			return "Enter Username";
		

		

		LoginDTO userLoginDTO = new LoginDTO();
		userLoginDTO.setLogin_id(userName);
		userLoginDTO.setLogin_password(userPassword);
		userLoginDTO.setLogin_person_role(userRole);
		userLoginDTO.setLogin_person_department(userSpeciality);
		userLoginDTO.setCompany_code(companycode);
		userLoginDTO.setLogin_geolocation(geolocationmessage);
		LoginDTO loginDTO = LoginService.validateLogin(userLoginDTO);
		
		if (loginDTO == null){
			JSFFacesUtil.showMessage( "Login Failed",userLoginDTO.getError_msg(),false);
			
		        userPassword="";
			return null;
		}

		UserContext userContext = (UserContext) facesContext.getApplication()
				.evaluateExpressionGet(facesContext, "#{UserContext}", UserContext.class);

		
	String	baseurl = LoginService.baseurl.get(loginDTO.getSession_id());
		baseurl = baseurl==null?"":baseurl;
		
		userContext.setLogin_audit_id(loginDTO.getLogin_audit_id());
		userContext.setUserPersonID(loginDTO.getLogin_person_id());
		userContext.setUserName(loginDTO.getPersonName());
		//userContext.setUserIPAddress(loginDTO.getLogin_ip_address());
		//userContext.setUserMachineName(loginDTO.getLogin_ip_machine());
		
		
		
			 
		
		loc_name = loginDTO.getLoc_name();
		
		
		
		FacesServicePrimeFaces service1 = new FacesServicePrimeFaces();
		userContext.setMenumodel(service1.getPrimeFacesMegaMenuModel(1,1) ); 
			 return_value="/user/home";
			 
			 JSFFacesUtil.redirect(return_value);
					
			
			
				
				
		
   }
   catch(Exception e)
   {
	   Log.exception(e);
	  
	   return null;
   }
	return "";
}
//button  action end

public String changePassword()
{
	errorMessage="";
	if (userName == null)
	{
		errorMessage = "Enter Username";
		return "";
	}
	if (userName.length()< 1)
	{
		errorMessage = "Enter Valid Username";
	}
	if (oldPassword.length() == 0)
	{
		errorMessage = "Enter Old Password";
	}
	if (newPassword.length() < 8)
	{		
		errorMessage = "New Password must be minimum of 8 Characters";
	}
	if (!newPassword.equals(newPasswordConfirm))
	{
		errorMessage = "Error : Passwords does not match";
	}
	if (errorMessage.length() == 0)
	{
		if (LoginService.changePassword(userName, oldPassword, newPassword, ""))
		{
			errorMessage = "Password has been changed";
			passwordChangeMessage="Password Changed. Login with new Password";
		}
		else
		{
			errorMessage = "Error : Unable to change the Password";
		}
	}
	
		
	return errorMessage;
}

//menu  start

	 
   
     
   


//menu end
public void flush()
{
	passwordChangeMessage="";
	errorMessage="";
	oldPassword="";
	newPassword="";
}


/*public void selectOrg () {
	
	
		 deptselectedlist=new ArrayList<Comp_department_mtrDTO>();
		org.bte.hospital.security.UserManager permobj=new org.bte.hospital.security.UserManagerImpl();
		deptselectedlist=permobj.getAvailableDepartments(userContext.getOrg_id(),  userContext.getUserLoginID());
		SelectItem option;	 	   
		specialitylist=new ArrayList<SelectItem>();	   
		for(int i=0;i<deptselectedlist.size();i++)
		{
			option = new SelectItem(deptselectedlist.get(i).getDept_id(), deptselectedlist.get(i).getDept_name());	    	 
			specialitylist.add(option);
		}		
	
	
	}*/
/*	public void selectDeptId() throws IOException{
		for(int i=0;i<deptselectedlist.size();i++)
		{
			if(userContext.getDept_id()==deptselectedlist.get(i).getDept_id()){
				userSpecialityName=deptselectedlist.get(i).getDept_name();
				break;
			}
		}	
		FacesServicePrimeFaces face = new FacesServicePrimeFaces();
		userContext.setUserRole(0);
		org.bte.hospital.security.UserManager permobj=new org.bte.hospital.security.UserManagerImpl();
		userrolelist =new ArrayList<SelectItem>();
		 userrolearraylist=permobj.getSelectedPermissions(userContext.getDept_id(), userContext.getUserLoginID(), userContext.getOrg_id());
		 if(userrolearraylist !=null && userrolearraylist.size() == 1){
			 userContext.setUserRole(userrolearraylist.get(0).getPermission_role_id());
			 userrolearraylist.get(0).setMenuItem(face.getRFMenuItem(userrolearraylist.get(0).getPermission_role_id()));
			 SelectItem option = new SelectItem(userrolearraylist.get(0).getPermission_role_id(), userrolearraylist.get(0).getPermission_role());	    	 
			    userrolelist.add(option);
			redirect();
		}else if(userrolearraylist !=null){
			SelectItem option;	 	
			option=new SelectItem(0, "-Select-");
			userrolelist.add(option);
			for(int i=0;i<userrolearraylist.size();i++)
			{
				userrolearraylist.get(i).setMenuItem(face.getRFMenuItem(userrolearraylist.get(i).getPermission_role_id()));
			    option = new SelectItem(userrolearraylist.get(i).getPermission_role_id(), userrolearraylist.get(i).getPermission_role());	    	 
			    userrolelist.add(option);
		
				
			}
			redirect();
		}
	}*/
	
	public String redirect() throws IOException
	{	
		
	
		
		return "Success";
	}


	public String getUserSpecialityName() {
		return userSpecialityName;
	}

	public void setUserSpecialityName(String userSpecialityName) {
		this.userSpecialityName = userSpecialityName;
	}

	

	public boolean isShowsidepanel() {
		return showsidepanel;
	}

	public void setShowsidepanel(boolean showsidepanel) {
		this.showsidepanel = showsidepanel;
	}
	
	

	public int getTemp_userrole() {
		return temp_userrole;
	}

	public void setTemp_userrole(int temp_userrole) {
		this.temp_userrole = temp_userrole;
	}

	public String getTemp_pagename() {
		return temp_pagename;
	}

	public void setTemp_pagename(String temp_pagename) {
		this.temp_pagename = temp_pagename;
	}



	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public String getUserrole_label() {
		return userrole_label;
	}

	public void setUserrole_label(String userrole_label) {
		this.userrole_label = userrole_label;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public void focusFunction(){
		if(userName=="" || userName==null){
			focus="inForm:username";
			return;
		}
		if(userPassword=="" || userPassword==null){
			focus="inForm:password";
			return;
		}
		actionname();
	}

	public List<String> getImagelist() {
		return imagelist;
	}

	public void setImagelist(List<String> imagelist) {
		this.imagelist = imagelist;
	}

	public String getGeolocationmessage() {
		return geolocationmessage;
	}

	public void setGeolocationmessage(String geolocationmessage) {
		this.geolocationmessage = geolocationmessage;
	}

	public int getGeolocation_flag() {
		return geolocation_flag;
	}

	public void setGeolocation_flag(int geolocation_flag) {
		this.geolocation_flag = geolocation_flag;
	}
		
		
	


}




