package org.bte.core.person;

public class ContactDetailsMtrDTO {

	private int cd_personid;
	private int cd_index=0;
	private String cd_mobile;
	private String cd_city;
	private int cd_country;
	private String cd_emailid;
	private String cd_name;
	private boolean cd_defult;
	private int cd_status;
	private int cd_id;
	private String cd_landmark;
	private String cd_flatname;


	private String cd_no;
	private String cd_phno;
	private int cd_pincode;
	private int cd_state;
	private String cd_streetname1;
	private String cd_streetname2;
	private String ct_locality;
	
	private String cd_offphno;
	private String cd_fax;
	
	//newly added
	private String cd_streetname3;
	private String cd_emerct_ctname1;
	
	private String cd_emerct_ctname2;
	private String cd_emerct_ctno1;
	private String cd_emerct_ctno2;
	
	private int cd_emerct_relation1;	 
	private int cd_emerct_relation2;	 
	private int cd_adrress_type;
	
	public String getCd_emerct_ctname1() {
		return cd_emerct_ctname1;
	}
	public void setCd_emerct_ctname1(String cd_emerct_ctname1) {
		this.cd_emerct_ctname1 = cd_emerct_ctname1;
	}
	public String getCd_emerct_ctname2() {
		return cd_emerct_ctname2;
	}
	public void setCd_emerct_ctname2(String cd_emerct_ctname2) {
		this.cd_emerct_ctname2 = cd_emerct_ctname2;
	}
	public String getCd_emerct_ctno1() {
		return cd_emerct_ctno1;
	}
	public void setCd_emerct_ctno1(String cd_emerct_ctno1) {
		this.cd_emerct_ctno1 = cd_emerct_ctno1;
	}
	public int getCd_emerct_relation1() {
		return cd_emerct_relation1;
	}
	public void setCd_emerct_relation1(int cd_emerct_relation1) {
		this.cd_emerct_relation1 = cd_emerct_relation1;
	}
	public int getCd_emerct_relation2() {
		return cd_emerct_relation2;
	}
	public void setCd_emerct_relation2(int cd_emerct_relation2) {
		this.cd_emerct_relation2 = cd_emerct_relation2;
	}
	public int getCd_adrress_type() {
		return cd_adrress_type;
	}
	public void setCd_adrress_type(int cd_adrress_type) {
		this.cd_adrress_type = cd_adrress_type;
	}
	public String getCd_streetname3() {
		return cd_streetname3;
	}
	public void setCd_streetname3(String cd_streetname3) {
		this.cd_streetname3 = cd_streetname3;
	}
	public int getCd_personid() {
		return cd_personid;
	}
	public void setCd_personid(int cd_personid) {
		this.cd_personid = cd_personid;
	}
	public int getCd_index() {
		return cd_index;
	}
	public void setCd_index(int cd_index) {
		this.cd_index = cd_index;
	}
	public String getCd_mobile() {
		return cd_mobile;
	}
	public void setCd_mobile(String cd_mobile) {
		this.cd_mobile = cd_mobile;
	}
	public String getCd_city() {
		return cd_city;
	}
	public void setCd_city(String cd_city) {
		this.cd_city = cd_city;
	}
	public int getCd_country() {
		return cd_country;
	}
	public void setCd_country(int cd_country) {
		this.cd_country = cd_country;
	}
	public String getCd_emailid() {
		return cd_emailid;
	}
	public void setCd_emailid(String cd_emailid) {
		this.cd_emailid = cd_emailid;
	}
	public String getCd_name() {
		return cd_name;
	}
	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}
	
	
	public String getCd_emerct_ctno2() {
		return cd_emerct_ctno2;
	}
	public void setCd_emerct_ctno2(String cd_emerct_ctno2) {
		this.cd_emerct_ctno2 = cd_emerct_ctno2;
	}
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	
	public String getCd_flatname() {
		return cd_flatname;
	}
	public void setCd_flatname(String cd_flatname) {
		this.cd_flatname = cd_flatname;
	}
	public String getCd_no() {
		return cd_no;
	}
	public void setCd_no(String cd_no) {
		this.cd_no = cd_no;
	}
	public String getCd_phno() {
		return cd_phno;
	}
	public void setCd_phno(String cd_phno) {
		this.cd_phno = cd_phno;
	}
	public int getCd_pincode() {
		return cd_pincode;
	}
	public void setCd_pincode(int cd_pincode) {
		this.cd_pincode = cd_pincode;
	}
	public int getCd_state() {
		return cd_state;
	}
	public void setCd_state(int cd_state) {
		this.cd_state = cd_state;
	}
	public String getCd_streetname1() {
		return cd_streetname1;
	}
	public void setCd_streetname1(String cd_streetname1) {
		this.cd_streetname1 = cd_streetname1;
	}
	public String getCd_streetname2() {
		return cd_streetname2;
	}
	public void setCd_streetname2(String cd_streetname2) {
		this.cd_streetname2 = cd_streetname2;
	}
	
	public String getCd_offphno() {
		return cd_offphno;
	}
	public void setCd_offphno(String cd_offphno) {
		this.cd_offphno = cd_offphno;
	}
	public String getCd_fax() {
		return cd_fax;
	}
	public void setCd_fax(String cd_fax) {
		this.cd_fax = cd_fax;
	}
	public void setCt_locality(String ct_locality) {
		this.ct_locality = ct_locality;
	}
	public String getCt_locality() {
		return ct_locality;
	}
	
	public int getCd_status() {
		return cd_status;
	}
	public void setCd_status(int cd_status) {
		this.cd_status = cd_status;
	}
	public String getCd_landmark() {
		return cd_landmark;
	}
	public void setCd_landmark(String cd_landmark) {
		this.cd_landmark = cd_landmark;
	}
	public boolean isCd_defult() {
		return cd_defult;
	}
	public void setCd_defult(boolean cd_defult) {
		this.cd_defult = cd_defult;
	}
	
		

}
