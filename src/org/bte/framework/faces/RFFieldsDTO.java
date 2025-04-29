package org.bte.framework.faces;

import java.util.List;

import javax.faces.component.UIComponent;

public class RFFieldsDTO {

	private int rf_fields_id;
	private int rf_page_id;
	private String rf_fields_key;
	private int rf_fields_validator_type;
	private int rf_fields_component_id;
	private int rf_fields_isleaf;
	private int rf_fields_parrent_id;
	private int rf_fields_add_flag;
	private int rf_fields_status;
	private String rf_fields_component_class;
	private List<RFFieldsAttDTO> taglist;
	
	private UIComponent fieldsobj;
	private int rf_fields_default_flag;
	private String rf_fields_default_value_expression;
	private String rf_fields_default_value_condition;
	private String rf_fields_setmethod;
	private String rf_fields_value_class;
	private String rf_fields_add_style_script;
	public int getRf_fields_id() {
		return rf_fields_id;
	}
	public void setRf_fields_id(int rf_fields_id) {
		this.rf_fields_id = rf_fields_id;
	}
	public int getRf_page_id() {
		return rf_page_id;
	}
	public void setRf_page_id(int rf_page_id) {
		this.rf_page_id = rf_page_id;
	}
	public String getRf_fields_key() {
		return rf_fields_key;
	}
	public void setRf_fields_key(String rf_fields_key) {
		this.rf_fields_key = rf_fields_key;
	}
	public int getRf_fields_validator_type() {
		return rf_fields_validator_type;
	}
	public void setRf_fields_validator_type(int rf_fields_validator_type) {
		this.rf_fields_validator_type = rf_fields_validator_type;
	}
	
	public int getRf_fields_component_id() {
		return rf_fields_component_id;
	}
	public void setRf_fields_component_id(int rf_fields_component_id) {
		this.rf_fields_component_id = rf_fields_component_id;
	}
	public UIComponent getFieldsobj() {
		return fieldsobj;
	}
	public void setFieldsobj(UIComponent fieldsobj) {
		this.fieldsobj = fieldsobj;
	}
	public int getRf_fields_isleaf() {
		return rf_fields_isleaf;
	}
	public void setRf_fields_isleaf(int rf_fields_isleaf) {
		this.rf_fields_isleaf = rf_fields_isleaf;
	}
	public int getRf_fields_parrent_id() {
		return rf_fields_parrent_id;
	}
	public void setRf_fields_parrent_id(int rf_fields_parrent_id) {
		this.rf_fields_parrent_id = rf_fields_parrent_id;
	}
	public int getRf_fields_add_flag() {
		return rf_fields_add_flag;
	}
	public void setRf_fields_add_flag(int rf_fields_add_flag) {
		this.rf_fields_add_flag = rf_fields_add_flag;
	}
	public int getRf_fields_status() {
		return rf_fields_status;
	}
	public void setRf_fields_status(int rf_fields_status) {
		this.rf_fields_status = rf_fields_status;
	}
	public List<RFFieldsAttDTO> getTaglist() {
		return taglist;
	}
	public void setTaglist(List<RFFieldsAttDTO> taglist) {
		this.taglist = taglist;
	}
	public String getRf_fields_component_class() {
		return rf_fields_component_class;
	}
	public void setRf_fields_component_class(String rf_fields_component_class) {
		this.rf_fields_component_class = rf_fields_component_class;
	}
	public int getRf_fields_default_flag() {
		return rf_fields_default_flag;
	}
	public void setRf_fields_default_flag(int rf_fields_default_flag) {
		this.rf_fields_default_flag = rf_fields_default_flag;
	}
	public String getRf_fields_default_value_expression() {
		return rf_fields_default_value_expression;
	}
	public void setRf_fields_default_value_expression(
			String rf_fields_default_value_expression) {
		this.rf_fields_default_value_expression = rf_fields_default_value_expression;
	}
	public String getRf_fields_default_value_condition() {
		return rf_fields_default_value_condition;
	}
	public void setRf_fields_default_value_condition(
			String rf_fields_default_value_condition) {
		this.rf_fields_default_value_condition = rf_fields_default_value_condition;
	}
	public String getRf_fields_setmethod() {
		return rf_fields_setmethod;
	}
	public void setRf_fields_setmethod(String rf_fields_setmethod) {
		this.rf_fields_setmethod = rf_fields_setmethod;
	}
	public String getRf_fields_value_class() {
		return rf_fields_value_class;
	}
	public void setRf_fields_value_class(String rf_fields_value_class) {
		this.rf_fields_value_class = rf_fields_value_class;
	}
	public String getRf_fields_add_style_script() {
		return rf_fields_add_style_script;
	}
	public void setRf_fields_add_style_script(String rf_fields_add_style_script) {
		this.rf_fields_add_style_script = rf_fields_add_style_script;
	}
	
	
	
	
}
