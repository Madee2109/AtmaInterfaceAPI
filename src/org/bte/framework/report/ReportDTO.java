package org.bte.framework.report;

import java.util.Date;
import java.util.List;



public class ReportDTO {

	private int report_id;
	private String report_name;
	private String report_file_name;
	private int report_status;
	private String report_roles;
	private int report_type;
	private int report_security_clearance;
	private String report_params;
	private String report_class;
	private int report_user;
	private Date report_timestamp;
	private int report_page_width;
	private int report_page_height;
	private int report_lines_per_page;
	private int report_chars_per_row;
	private int report_printer_id;
	private String report_media;
	private int printer_id;
	private String printer_name;
	private String printer_path;
	private int dept_id;
	private int org_id;
	private String dept_name;
	
	private String xltemplate_name;
	private int report_excelid;
	private int export_type;
	private boolean report_pdf;
	private boolean report_xls;
	private boolean report_docx;
	private boolean report_html_view;
	private boolean report_xml;
	
	private int user_role;
	private String user_role_name;
	private String report_notes;

	private boolean report_group_default;
	private String report_title;
	private String report_footer;
	private int report_print_copy;
	private String report_group;
	private boolean  report_email;
	
	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	public String getUser_role_name() {
		return user_role_name;
	}

	public void setUser_role_name(String user_role_name) {
		this.user_role_name = user_role_name;
	}

	public String getXltemplate_name() {
		return xltemplate_name;
	}

	public void setXltemplate_name(String xltemplateName) {
		xltemplate_name = xltemplateName;
	}

	public int getReport_excelid() {
		return report_excelid;
	}

	public void setReport_excelid(int reportExcelid) {
		report_excelid = reportExcelid;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int deptId) {
		dept_id = deptId;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int orgId) {
		org_id = orgId;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String deptName) {
		dept_name = deptName;
	}

	public int getPrinter_id() {
		return printer_id;
	}

	public void setPrinter_id(int printer_id) {
		this.printer_id = printer_id;
	}

	public String getPrinter_name() {
		return printer_name;
	}

	public void setPrinter_name(String printer_name) {
		this.printer_name = printer_name;
	}

	public String getPrinter_path() {
		return printer_path;
	}

	public void setPrinter_path(String printer_path) {
		this.printer_path = printer_path;
	}

	public int getReport_page_height() {
		return report_page_height;
	}

	public void setReport_page_height(int report_page_height) {
		this.report_page_height = report_page_height;
	}

	public int getReport_lines_per_page() {
		return report_lines_per_page;
	}

	public void setReport_lines_per_page(int report_lines_per_page) {
		this.report_lines_per_page = report_lines_per_page;
	}

	public int getReport_chars_per_row() {
		return report_chars_per_row;
	}

	public void setReport_chars_per_row(int report_chars_per_row) {
		this.report_chars_per_row = report_chars_per_row;
	}

	public int getReport_printer_id() {
		return report_printer_id;
	}

	public void setReport_printer_id(int report_printer_id) {
		this.report_printer_id = report_printer_id;
	}

	public String getReport_media() {
		return report_media;
	}

	public void setReport_media(String report_media) {
		this.report_media = report_media;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int reportId) {
		report_id = reportId;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String reportName) {
		report_name = reportName;
	}

	public String getReport_file_name() {
		return report_file_name;
	}

	public void setReport_file_name(String reportFileName) {
		report_file_name = reportFileName;
	}

	public int getReport_status() {
		return report_status;
	}

	public void setReport_status(int reportStatus) {
		report_status = reportStatus;
	}

	public String getReport_roles() {
		return report_roles;
	}

	public void setReport_roles(String reportRoles) {
		report_roles = reportRoles;
	}

	public int getReport_type() {
		return report_type;
	}

	public void setReport_type(int reportType) {
		report_type = reportType;
	}

	public int getReport_security_clearance() {
		return report_security_clearance;
	}

	public void setReport_security_clearance(int reportSecurityClearance) {
		report_security_clearance = reportSecurityClearance;
	}

	public String getReport_params() {
		return report_params;
	}

	public void setReport_params(String reportParams) {
		report_params = reportParams;
	}

	public String getReport_class() {
		return report_class;
	}

	public void setReport_class(String reportClass) {
		report_class = reportClass;
	}

	public int getReport_user() {
		return report_user;
	}

	public void setReport_user(int reportUser) {
		report_user = reportUser;
	}

	public Date getReport_timestamp() {
		return report_timestamp;
	}

	public void setReport_timestamp(Date reportTimestamp) {
		report_timestamp = reportTimestamp;
	}

	public int getReport_page_width() {
		return report_page_width;
	}

	public void setReport_page_width(int report_page_width) {
		this.report_page_width = report_page_width;
	}

	public int getExport_type() {
		return export_type;
	}

	public void setExport_type(int export_type) {
		this.export_type = export_type;
	}

	public boolean isReport_pdf() {
		return report_pdf;
	}

	public void setReport_pdf(boolean report_pdf) {
		this.report_pdf = report_pdf;
	}

	public boolean isReport_xls() {
		return report_xls;
	}

	public void setReport_xls(boolean report_xls) {
		this.report_xls = report_xls;
	}

	public boolean isReport_docx() {
		return report_docx;
	}

	public void setReport_docx(boolean report_docx) {
		this.report_docx = report_docx;
	}

	public String getReport_notes() {
		return report_notes;
	}

	public void setReport_notes(String report_notes) {
		this.report_notes = report_notes;
	}

	public boolean isReport_group_default() {
		return report_group_default;
	}

	public void setReport_group_default(boolean report_group_default) {
		this.report_group_default = report_group_default;
	}

	public String getReport_title() {
		return report_title;
	}

	public void setReport_title(String report_title) {
		this.report_title = report_title;
	}

	public int getReport_print_copy() {
		return report_print_copy;
	}

	public void setReport_print_copy(int report_print_copy) {
		this.report_print_copy = report_print_copy;
	}

	public String getReport_group() {
		return report_group;
	}

	public void setReport_group(String report_group) {
		this.report_group = report_group;
	}

	public boolean isReport_email() {
		return report_email;
	}

	public void setReport_email(boolean report_email) {
		this.report_email = report_email;
	}

	

	public boolean isReport_html_view() {
		return report_html_view;
	}

	public void setReport_html_view(boolean report_html_view) {
		this.report_html_view = report_html_view;
	}

	public boolean isReport_xml() {
		return report_xml;
	}

	public void setReport_xml(boolean report_xml) {
		this.report_xml = report_xml;
	}

	public String getReport_footer() {
		return report_footer;
	}

	public void setReport_footer(String report_footer) {
		this.report_footer = report_footer;
	}

	
	
}
