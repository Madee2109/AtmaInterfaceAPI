package org.bte.core.person.staff;

import java.util.Date;
import java.util.List;


public class UserTemplateDTO {

	private int user_template_id;
	private String user_template_name;
	private int add_user_id;
	private Date add_date;
	private int user_template_home_page;
	
	 private List<Integer> menuitem;
		
	public int getUser_template_id() {
		return user_template_id;
	}
	public void setUser_template_id(int user_template_id) {
		this.user_template_id = user_template_id;
	}
	public String getUser_template_name() {
		return user_template_name;
	}
	public void setUser_template_name(String user_template_name) {
		this.user_template_name = user_template_name;
	}
	public int getAdd_user_id() {
		return add_user_id;
	}
	public void setAdd_user_id(int add_user_id) {
		this.add_user_id = add_user_id;
	}
	public Date getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
	
	
	public List<Integer> getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(List<Integer> menuitem) {
		this.menuitem = menuitem;
	}
	public int getUser_template_home_page() {
		return user_template_home_page;
	}
	public void setUser_template_home_page(int user_template_home_page) {
		this.user_template_home_page = user_template_home_page;
	}
	
	
	
}
