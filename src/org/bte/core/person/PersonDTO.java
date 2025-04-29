package org.bte.core.person;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class PersonDTO {
	
	public boolean tally_mig_flag;
	public String cd_name;
	public String cd_landmark;
	public String cd_city;
	public String cd_phno;
	
	
	public int emailaccept;
	public String contactemail;
	public int person_id;
	public int person_type;
	public int person_title;
	public String person_fname;
	public String person_mname;
	public String person_lname;
	public int person_sex;
	public String person_sex_label;
	public Date person_dob;
	public int person_orgnflag;
	public String city;
	public String locality;
	
	public int person_age;
	public int person_active;
	public int person_location;
	
	public String person_pan_no;
	public Date person_datereg;
	public int org_id;
	
	public int company_id;
	public int department_id;
	public int dept_id;
	public String dept_name;
	public int designation_id;
	public String doorno;
	public String streetname1;
	public String streetname2;
	public int state;
	public int pincode;
	public int country;
	public int status;
	public String person_fat_hus_name;
	public String person_mot_wife_name;
	public int person_marital_status;
	public String persontypelabel;
	
	public String person_uid;
	public String person_pp_no;
	
	public int user_id;
	public int person_company;
	
	
	
	public String person_abbreviation;
	
	
	public List<ContactPhoneDTO> contactphone_list;
	public List<ContactPersonDTO> contactperson_list;
	
	
	public ContactDetailsMtrDTO contactdetailsmtr_obj;
	public List<ContactDetailsMtrDTO> contactdetailsmtr_list=new ArrayList<ContactDetailsMtrDTO>();
	public List<PersonNotificationDTO> not_list;	

	public Date person_entry_date;

	public String cd_no;
	public int cd_index;
	public String cd_mobile;
	public String cd_streetname1;
	public String cd_streetname2;
	public String cd_flatname;
	public String ct_locality;
	public int cd_state;
	public String cd_state_label;
	public int cd_country;
	public String cd_country_label;
	//public int cd_pincode;
	public Integer cd_pincode;
	public String cd_offphno;
	public String cd_fax;
	public String cd_emailid;
		
	
	public int person_user_id;
	public String person_activeLabel;
	
	//newly added
	public int cd_id;
	
	public String password;
	public int person_nationality;
	public int person_occupation;
	public int person_religion;
	public int person_blood_group;
	public Date approx_dob;
	public String imagePath="../pages/images/patient1/patient1.jpg";
	
	//newly added
	private String person_guardian_name;
	private String person_language_known;	
	public List<SocialInfo> socialinfolist=new ArrayList<SocialInfo>();
	public String cd_streetname3;
	
	//newly added
	private String org_name;
	private String person_type_name;
	private String login_id;
	private String person_image_path;
	private int coa_id;
	private List<ContactDetailsMtrDTO> shipping = new ArrayList<ContactDetailsMtrDTO>();
	
	public String getPerson_type_name() {
		return person_type_name;
	}
	public void setPerson_type_name(String person_type_name) {
		this.person_type_name = person_type_name;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public Integer getCd_pincode() {
		return cd_pincode;
	}
	public void setCd_pincode(Integer cd_pincode) {
		this.cd_pincode = cd_pincode;
	}

	public String getCd_streetname3() {
		return cd_streetname3;
	}	
	public void setCd_streetname3(String cd_streetname3) {
		this.cd_streetname3 = cd_streetname3;
	}
	public List<SocialInfo> getSocialinfolist() {
		return socialinfolist;
	}
	public void setSocialinfolist(List<SocialInfo> socialinfolist) {
		this.socialinfolist = socialinfolist;
	}
	public String getPerson_guardian_name() {
		return person_guardian_name;
	}
	public void setPerson_guardian_name(String person_guardian_name) {
		this.person_guardian_name = person_guardian_name;
	}
	public String getPerson_language_known() {
		return person_language_known;
	}
	public void setPerson_language_known(String person_language_known) {
		this.person_language_known = person_language_known;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getPerson_nationality() {
		return person_nationality;
	}
	public void setPerson_nationality(int person_nationality) {
		this.person_nationality = person_nationality;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	
	public int getPerson_user_id() {
		return person_user_id;
	}
	public void setPerson_user_id(int person_user_id) {
		this.person_user_id = person_user_id;
	}
	public String getCd_no() {
		return cd_no;
	}
	public void setCd_no(String cd_no) {
		this.cd_no = cd_no;
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
	public String getCd_flatname() {
		return cd_flatname;
	}
	public void setCd_flatname(String cd_flatname) {
		this.cd_flatname = cd_flatname;
	}
	public String getCt_locality() {
		return ct_locality;
	}
	public void setCt_locality(String ct_locality) {
		this.ct_locality = ct_locality;
	}
	public int getCd_state() {
		return cd_state;
	}
	public void setCd_state(int cd_state) {
		this.cd_state = cd_state;
	}
	public String getCd_state_label() {
		return cd_state_label;
	}
	public void setCd_state_label(String cd_state_label) {
		this.cd_state_label = cd_state_label;
	}
	public int getCd_country() {
		return cd_country;
	}
	public void setCd_country(int cd_country) {
		this.cd_country = cd_country;
	}
	public String getCd_country_label() {
		return cd_country_label;
	}
	public void setCd_country_label(String cd_country_label) {
		this.cd_country_label = cd_country_label;
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
	public String getCd_emailid() {
		return cd_emailid;
	}
	public void setCd_emailid(String cd_emailid) {
		this.cd_emailid = cd_emailid;
	}
	
	public Date getPerson_entry_date() {
		return person_entry_date;
	}
	public void setPerson_entry_date(Date person_entry_date) {
		this.person_entry_date = person_entry_date;
	}
	
	public String getPerson_uid() {
		return person_uid;
	}
	public void setPerson_uid(String personUid) {
		person_uid = personUid;
	}
	public String getPerson_pp_no() {
		return person_pp_no;
	}
	public void setPerson_pp_no(String personPpNo) {
		person_pp_no = personPpNo;
	}
	public String getCd_city() {
		return cd_city;
	}
	public void setCd_city(String cd_city) {
		this.cd_city = cd_city;
	}
	public String getCd_phno() {
		return cd_phno;
	}
	public void setCd_phno(String cd_phno) {
		this.cd_phno = cd_phno;
	}
	
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreetname1() {
		return streetname1;
	}
	public void setStreetname1(String streetname1) {
		this.streetname1 = streetname1;
	}
	public String getStreetname2() {
		return streetname2;
	}
	public void setStreetname2(String streetname2) {
		this.streetname2 = streetname2;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public String getPersontypelabel() {
		
			return persontypelabel;
	
	}
	public void setPersontypelabel(String persontypelabel) {
		this.persontypelabel = persontypelabel;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPerson_company() {
		return person_company;
	}
	public void setPerson_company(int person_company) {
		this.person_company = person_company;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int personId) {
		person_id = personId;
	}
	public int getPerson_type() {
		return person_type;
	}
	public void setPerson_type(int personType) {
		person_type = personType;
	}
	public int getPerson_title() {
		return person_title;
	}
	public void setPerson_title(int personTitle) {
		person_title = personTitle;
	}
	public String getPerson_fname() {
		return person_fname;
	}
	public void setPerson_fname(String personFname) {
		person_fname = personFname;
	}
	public String getPerson_mname() {
		return person_mname;
	}
	public void setPerson_mname(String personMname) {
		person_mname = personMname;
	}
	public String getPerson_lname() {
		return person_lname;
	}
	public void setPerson_lname(String personLname) {
		person_lname = personLname;
	}
	public int getPerson_sex() {
		return person_sex;
	}
	public void setPerson_sex(int personSex) {
		person_sex = personSex;
	}
	public Date getPerson_dob() {
		return person_dob;
	}
	public void setPerson_dob(Date personDob) {
		person_dob = personDob;
	}
	public int getPerson_orgnflag() {
		return person_orgnflag;
	}
	public void setPerson_orgnflag(int personOrgnflag) {
		person_orgnflag = personOrgnflag;
	}
	
	public int getPerson_age() {
		return person_age;
	}
	public void setPerson_age(int personAge) {
		person_age = personAge;
	}
	public int getPerson_active() {
		return person_active;
	}
	public void setPerson_active(int personActive) {
		person_active = personActive;
	}
	public int getPerson_location() {
		return person_location;
	}
	public void setPerson_location(int personLocation) {
		person_location = personLocation;
	}
	
	public String getPerson_pan_no() {
		return person_pan_no;
	}
	public void setPerson_pan_no(String personPanNo) {
		person_pan_no = personPanNo;
	}
	public Date getPerson_datereg() {
		return person_datereg;
	}
	public void setPerson_datereg(Date personDatereg) {
		person_datereg = personDatereg;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int orgId) {
		org_id = orgId;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int companyId) {
		company_id = companyId;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int departmentId) {
		department_id = departmentId;
	}
	public String getPerson_fat_hus_name() {
		return person_fat_hus_name;
	}
	public void setPerson_fat_hus_name(String personFatHusName) {
		person_fat_hus_name = personFatHusName;
	}
	public String getPerson_mot_wife_name() {
		return person_mot_wife_name;
	}
	public void setPerson_mot_wife_name(String personMotWifeName) {
		person_mot_wife_name = personMotWifeName;
	}
	public int getPerson_marital_status() {
		return person_marital_status;
	}
	public void setPerson_marital_status(int personMaritalStatus) {
		person_marital_status = personMaritalStatus;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}
	public int getDesignation_id() {
		return designation_id;
	}
	
	
	
	public ContactDetailsMtrDTO getContactdetailsmtr_obj() {
		return contactdetailsmtr_obj;
	}
	public void setContactdetailsmtr_obj(ContactDetailsMtrDTO contactdetailsmtr_obj) {
		this.contactdetailsmtr_obj = contactdetailsmtr_obj;
	}
	public List<ContactPhoneDTO> getContactphone_list() {
		return contactphone_list;
	}
	public void setContactphone_list(List<ContactPhoneDTO> contactphone_list) {
		this.contactphone_list = contactphone_list;
	}
	public List<ContactPersonDTO> getContactperson_list() {
		return contactperson_list;
	}
	public void setContactperson_list(List<ContactPersonDTO> contactperson_list) {
		this.contactperson_list = contactperson_list;
	}
	
	
	public void setPerson_abbreviation(String person_abbreviation) {
		this.person_abbreviation = person_abbreviation;
	}
	public String getPerson_abbreviation() {
		return person_abbreviation;
	}
	
	public int getEmailaccept() {
		return emailaccept;
	}
	public void setEmailaccept(int emailaccept) {
		this.emailaccept = emailaccept;
	}
	public String getContactemail() {
		return contactemail;
	}
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	public String getCd_landmark() {
		return cd_landmark;
	}
	public void setCd_landmark(String cd_landmark) {
		this.cd_landmark = cd_landmark;
	}
	public void setPerson_activeLabel(String person_activeLabel) {
		this.person_activeLabel = person_activeLabel;
	}

	public String getPerson_activeLabel() {
		
			return person_activeLabel;
		
		
	}
	public List<ContactDetailsMtrDTO> getContactdetailsmtr_list() {
		return contactdetailsmtr_list;
	}
	public void setContactdetailsmtr_list(List<ContactDetailsMtrDTO> contactdetailsmtr_list) {
		this.contactdetailsmtr_list = contactdetailsmtr_list;
	}
	public String getCd_name() {
		return cd_name;
	}
	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}
	public int getPerson_occupation() {
		return person_occupation;
	}
	public void setPerson_occupation(int person_occupation) {
		this.person_occupation = person_occupation;
	}
	public int getPerson_religion() {
		return person_religion;
	}
	public void setPerson_religion(int person_religion) {
		this.person_religion = person_religion;
	}
	public int getPerson_blood_group() {
		return person_blood_group;
	}
	public void setPerson_blood_group(int person_blood_group) {
		this.person_blood_group = person_blood_group;
	}
	public Date getApprox_dob() {
		return approx_dob;
	}
	public void setApprox_dob(Date approx_dob) {
		this.approx_dob = approx_dob;
	}
	public String getPerson_sex_label() {
		return person_sex_label;
	}
	public void setPerson_sex_label(String person_sex_label) {
		this.person_sex_label = person_sex_label;
	}
	
	public String ageoncurrentdate(Date todate){
		if(person_dob!=null && todate!=null){
			Calendar now=Calendar.getInstance();
			Calendar curdob=Calendar.getInstance();
			now.setTime(todate);
			curdob.setTime(person_dob);
			
				
				
				int year1=now.get(Calendar.YEAR);
				int year2=curdob.get(Calendar.YEAR);
				
				int age_year=(year1-year2);
				int age_Month=0;
				
				int Month1=now.get(Calendar.MONTH);
				int Month2=curdob.get(Calendar.MONTH);
				if(Month2>Month1)
				{
					age_year--;
				}else if(Month1==Month2)
				{
					int day1=now.get(Calendar.DAY_OF_MONTH);
					int day2=curdob.get(Calendar.DAY_OF_MONTH);
					
					if(day2>day1)
					{
						age_year--;
					}
				}
				else if(Month2<Month1)
					age_Month=Month1-Month2;
				return ""+age_year;
				//setPerson_age(age_year);
				//setPerson_month(age_Month);
			
		}else{
			return "";
		}
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPerson_image_path() {
		return person_image_path;
	}
	public void setPerson_image_path(String person_image_path) {
		this.person_image_path = person_image_path;
	}
	public List<ContactDetailsMtrDTO> getShipping() {
		return shipping;
	}
	public void setShipping(List<ContactDetailsMtrDTO> shipping) {
		this.shipping = shipping;
	}
	public int getCoa_id() {
		return coa_id;
	}
	public void setCoa_id(int coa_id) {
		this.coa_id = coa_id;
	}

	
}
