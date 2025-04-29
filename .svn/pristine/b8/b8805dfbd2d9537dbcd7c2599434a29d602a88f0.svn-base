package org.bte.core.utils;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import org.hibernate.SessionFactory;

public class SIGNUP_Util_DTO {

	public List<Timer> listOfTimers;
	public SessionFactory sessionFactory;
	private String project_db_schema;
	private String project_db_password;
	private String project_db_ip;
	private String project_db_username;
	private String project_db_port;
	private String project_db_url;
	private String log_show_sql;
	private Date product_ex_date;
	private Date product_amc_ex_date;
	private String project_db_schema_history;
	private boolean project_db_scheduler;
	
	public SIGNUP_Util_DTO(String ip ,String schema   , String user, String pass,String port){
		String url="jdbc:mysql://"+ip+":"+port+"/"+schema+"?sql_mode=''";
		project_db_schema = schema;
		project_db_password = pass;
		project_db_ip = ip;
		project_db_username = user;
		project_db_port = port;
		project_db_url = url;
	}
	public SIGNUP_Util_DTO(String url  , String user, String pass){
		project_db_password = pass;
		project_db_username = user;
		project_db_url = url;
	}
	public String getProject_db_schema() {
		return project_db_schema;
	}
	public void setProject_db_schema(String project_db_schema) {
		this.project_db_schema = project_db_schema;
	}
	public String getProject_db_password() {
		return project_db_password;
	}
	public void setProject_db_password(String project_db_password) {
		this.project_db_password = project_db_password;
	}
	public String getProject_db_ip() {
		return project_db_ip;
	}
	public void setProject_db_ip(String project_db_ip) {
		this.project_db_ip = project_db_ip;
	}
	public String getProject_db_username() {
		return project_db_username;
	}
	public void setProject_db_username(String project_db_username) {
		this.project_db_username = project_db_username;
	}
	public String getProject_db_port() {
		return project_db_port;
	}
	public void setProject_db_port(String project_db_port) {
		this.project_db_port = project_db_port;
	}
	public String getProject_db_url() {
		return project_db_url;
	}
	public void setProject_db_url(String project_db_url) {
		this.project_db_url = project_db_url;
	}
	public List<Timer> getListOfTimers() {
		return listOfTimers;
	}
	public void setListOfTimers(List<Timer> listOfTimers) {
		this.listOfTimers = listOfTimers;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public String getLog_show_sql() {
		return log_show_sql;
	}
	public void setLog_show_sql(String log_show_sql) {
		this.log_show_sql = log_show_sql;
	}
	public Date getProduct_ex_date() {
		return product_ex_date;
	}
	public void setProduct_ex_date(Date product_ex_date) {
		this.product_ex_date = product_ex_date;
	}
	public Date getProduct_amc_ex_date() {
		return product_amc_ex_date;
	}
	public void setProduct_amc_ex_date(Date product_amc_ex_date) {
		this.product_amc_ex_date = product_amc_ex_date;
	}
	public String getProject_db_schema_history() {
		return project_db_schema_history;
	}
	public void setProject_db_schema_history(String project_db_schema_history) {
		this.project_db_schema_history = project_db_schema_history;
	}
	public boolean isProject_db_scheduler() {
		return project_db_scheduler;
	}
	public void setProject_db_scheduler(boolean project_db_scheduler) {
		this.project_db_scheduler = project_db_scheduler;
	}
	
	
	
}