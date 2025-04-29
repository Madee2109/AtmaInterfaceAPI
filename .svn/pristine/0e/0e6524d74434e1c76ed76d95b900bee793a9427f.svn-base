package org.bte.bean;

import java.io.IOException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.bte.framework.security.LoginService;
import org.primefaces.model.menu.MenuModel;

@ManagedBean ( name = "UserContext" )
@SessionScoped
public class UserContext {
	
	private String userName;
	private int userPersonID;
	private int login_audit_id;
	private int org_id;
	private MenuModel menumodel;
	
	public void logout()  {
		LoginService.logout();
		JSFFacesUtil.redirect("");
		
	}
	public void redirectMenuDiffFolder(ActionEvent event){
		
			String param=JSFFacesUtil.getRequestParam("page_name");
			
			JSFFacesUtil.redirect(param);
		
	}
	public Date getTransaction_date() {
		return null;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPersonID() {
		return userPersonID;
	}

	public void setUserPersonID(int userPersonID) {
		this.userPersonID = userPersonID;
	}

	public int getLogin_audit_id() {
		return login_audit_id;
	}

	public void setLogin_audit_id(int login_audit_id) {
		this.login_audit_id = login_audit_id;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public MenuModel getMenumodel() {
		return menumodel;
	}
	public void setMenumodel(MenuModel menumodel) {
		this.menumodel = menumodel;
	}
	
}