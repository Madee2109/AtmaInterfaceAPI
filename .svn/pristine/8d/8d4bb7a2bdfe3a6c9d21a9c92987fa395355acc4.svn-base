package org.bte.core.utils;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="id_coretable")
public class Core_table {

	int id;
	String table_name;
	Date date;
	Integer org_id;
	int core_id;
	String suffix;
	String prefix;
	String rule;
	String id_format;
	Date id_fromdate;
	Date id_todate;
	
	public String getId_format() {
		return id_format;
	}
	public void setId_format(String id_format) {
		this.id_format = id_format;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	@Column(name="core_id")
	public int getCore_id() {
		return core_id;
	}
	public void setCore_id(int coreId) {
		core_id = coreId;
	}
	@Column(name="id")
	public int getid() {
		return this.id;
	}
	public void setid(int id) {
		this.id = id;
	}


	@Id
	@Column(name="table_name")
	public String gettable_name() {
		return this.table_name;
	}
	public void settable_name(String table_name) {
		this.table_name = table_name;
	}

	@Column(name="date")
	public Date getdate() {
		return this.date;
	}
	public void setdate(Date date) {
		this.date = date;
	}
	
	@Column(name="org_id")
	public Integer getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Integer orgId) {
		org_id = orgId;
	}
	@Column(name="suffix")
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	@Column(name="prefix")
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Date getId_fromdate() {
		return id_fromdate;
	}
	public void setId_fromdate(Date id_fromdate) {
		this.id_fromdate = id_fromdate;
	}
	public Date getId_todate() {
		return id_todate;
	}
	public void setId_todate(Date id_todate) {
		this.id_todate = id_todate;
	}
	
	


}
