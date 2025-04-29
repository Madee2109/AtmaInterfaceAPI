package org.bte.framework.audit;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * The persistent class for the tb_audit database table.
 * 
 */
@Entity
@Table(name="tb_audit")
public class tb_audit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_sno")
	private int auditSno;

	@Column(name="audit_activity")
	private int auditActivity;

	@Column(name="audit_date")
	private Timestamp auditDate;

	@Column(name="audit_id")
	private int auditId;

	@Column(name="audit_operation")
	private int auditOperation;

	@Column(name="audit_userid")
	private int auditUserid;

	private String audit_information;
	private Integer audit_personid;

	private Integer audit_encid;

	private int org_id;
	
	private int login_audit_id;
	//siva code starts
	
	private String audit_ipaddress;
	private String audit_machinename;
	private String audit_loginsession;
	private int audit_save_status;
	
	public String getAudit_ipaddress() {
		return audit_ipaddress;
	}

	public void setAudit_ipaddress(String auditIpaddress) {
		audit_ipaddress = auditIpaddress;
	}

	public String getAudit_machinename() {
		return audit_machinename;
	}

	public void setAudit_machinename(String auditMachinename) {
		audit_machinename = auditMachinename;
	}

	//siva code ends

	
	public tb_audit() {
	}

	public int getAuditSno() {
		return this.auditSno;
	}

	public void setAuditSno(int auditSno) {
		this.auditSno = auditSno;
	}

	public int getAuditActivity() {
		return this.auditActivity;
	}

	public void setAuditActivity(int auditActivity) {
		this.auditActivity = auditActivity;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public int getAuditId() {
		return this.auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public int getAuditOperation() {
		return this.auditOperation;
	}

	public void setAuditOperation(int auditOperation) {
		this.auditOperation = auditOperation;
	}

	public int getAuditUserid() {
		return this.auditUserid;
	}

	public void setAuditUserid(int auditUserid) {
		this.auditUserid = auditUserid;
	}


	public Integer getAudit_personid() {
		return audit_personid;
	}

	public void setAudit_personid(Integer auditPersonid) {
		audit_personid = auditPersonid;
	}

	public Integer getAudit_encid() {
		return audit_encid;
	}

	public void setAudit_encid(Integer auditEncid) {
		audit_encid = auditEncid;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int orgId) {
		org_id = orgId;
	}

	public String getAudit_information() {
		return audit_information;
	}

	public void setAudit_information(String audit_information) {
		this.audit_information = audit_information;
	}

	public String getAudit_loginsession() {
		return audit_loginsession;
	}

	public void setAudit_loginsession(String audit_loginsession) {
		this.audit_loginsession = audit_loginsession;
	}

	public int getAudit_save_status() {
		return audit_save_status;
	}

	public void setAudit_save_status(int audit_save_status) {
		this.audit_save_status = audit_save_status;
	}

	public int getLogin_audit_id() {
		return login_audit_id;
	}

	public void setLogin_audit_id(int login_audit_id) {
		this.login_audit_id = login_audit_id;
	}



}
