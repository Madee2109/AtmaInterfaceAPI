package org.bte.core.person;

public class ContactPersonDTO {
	
	private int cd_personid;
	private int cd_serial_id=0;
	private String cd_contactname;
	private String cd_designation;
	private String cd_contactno;
	private String cd_extension;
	private String cd_mobileno;
	private String cd_emailid;
	
	private String cd_address;
	private int cd_relation;
	private double cd_income;
	
	
	public int getCd_personid() {
		return cd_personid;
	}
	public void setCd_personid(int cd_personid) {
		this.cd_personid = cd_personid;
	}
	public int getCd_serial_id() {
		return cd_serial_id;
	}
	public void setCd_serial_id(int cd_serial_id) {
		this.cd_serial_id = cd_serial_id;
	}
	public void setCd_contactname(String cd_contactname) {
		this.cd_contactname = cd_contactname;
	}
	public String getCd_contactname() {
		return cd_contactname;
	}
	public void setCd_designation(String cd_designation) {
		this.cd_designation = cd_designation;
	}
	public String getCd_designation() {
		return cd_designation;
	}
	public void setCd_contactno(String cd_contactno) {
		this.cd_contactno = cd_contactno;
	}
	public String getCd_contactno() {
		return cd_contactno;
	}
	public void setCd_extension(String cd_extension) {
		this.cd_extension = cd_extension;
	}
	public String getCd_extension() {
		return cd_extension;
	}
	public void setCd_mobileno(String cd_mobileno) {
		this.cd_mobileno = cd_mobileno;
	}
	public String getCd_mobileno() {
		return cd_mobileno;
	}
	public void setCd_emailid(String cd_emailid) {
		this.cd_emailid = cd_emailid;
	}
	public String getCd_emailid() {
		return cd_emailid;
	}
	public String getCd_address() {
		return cd_address;
	}
	public void setCd_address(String cd_address) {
		this.cd_address = cd_address;
	}
	public int getCd_relation() {
		return cd_relation;
	}
	public void setCd_relation(int cd_relation) {
		this.cd_relation = cd_relation;
	}
	public double getCd_income() {
		return cd_income;
	}
	public void setCd_income(double cd_income) {
		this.cd_income = cd_income;
	}

}
