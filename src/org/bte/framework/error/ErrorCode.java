package org.bte.framework.error;

public  class ErrorCode {

	public static final int code_severity_info = 1;
	public static final int code_severity_WARN = 2;
	public static final int code_severity_error = 3;
	public static final int code_severity_fatal = 4;
	
	public static final int code_type_message_popup=1;
	public static final int code_type_growl=2;
	public static final int code_type_message_page_popup=3;
	public static final int code_type_message_on_page=4;
	public static final int code_type_sms=5;;
	public static final int code_type_email=6;
	
	public static final int error_code_db_link_failure=10;
	public static final int error_code_tally_link_failure=11;
	public static final int error_code_id_code_table_script_missing=12;
	public static final int error_code_rollback=13;
	public static final int error_code_find_exception=14;
	public static final int error_code_sql_exception_Unknown_entity=15;
	public static final int error_code_sql_exception_Table_Missing=16;
	
	public static final int error_code_login_failed=101;
	public static final int error_code_enter_item_name=102;
	public static final int error_code_select_ledger_group_parent=103;
	public static final int error_code_open_voucher_update_request=104;
	public static final int error_code_open_voucher_cancel_request=105;
	
	public static final int error_code_Tally_XML_FORMAT_MISSING=106;
	public static final int error_code_Ledger_already_exists=107;
	
	
}
