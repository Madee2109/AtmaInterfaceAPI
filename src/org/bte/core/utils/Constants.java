package org.bte.core.utils;

public class Constants {

	public static boolean GST_RULE_RUN = false;
	public static final String regex_int = "\\d+";
	public static final String regex_int_neg = "\\(\\d+\\)";
	static public int INVOICE_NIL=0;

	static public int INVOICE_GENERATE=1;

	static public int INVOICE_READY=2;

	static public int INVOICE_CREATE=3;

	static public int INVOICE_PAYMENT=4;

	static public int INVOICE_PARTLY_PAID=5;

	static public int INVOICE_FULLY_PAID=6;
	
	public static int STATUS_ACTIVE=1;
	public static int STATUS_INACTIVE=2;
	
	static public int SERVICE_RATE_TYPE_NORMAL=1;
	static public int SERVICE_RATE_TYPE_SLAB=2;

	static public int DEFAULT_COUNTRY=97;
	
	public static String DATETIMEFORMAT1="dd MMM yyyy HH:mm";
	public static String DATETIMEFORMAT2="dd MMM yyyy";
	
	public static  int PHARMACY_NOTDELIVERED=1;
	public static  int PHARMACY_DELIVERED=2;
	
	public static final int PAY_DELIVERY=1;
	public static final int DELIVERY_PAY=2;
	
	static public int TABLET_DRUG_TYPE=2;
	static public int  DRUG_CATEGORY=6;

	static public int AUDIT_OP_INSERT=1;

	static public int AUDIT_OP_UPDATE=2;

	static public int AUDIT_OP_DELETE=3;

	static public int AUDIT_OP_PAY=4;
	

	public static  int STOCK_MVMT_TYPE_INTERNAL_ISSUE=1;
	public static  int STOCK_MVMT_TYPE_JOBWORKS=2;
	public static  int STOCK_MVMT_TYPE_DELIVERY=3;
	public static  int STOCK_MVMT_TYPE_RETURNS=4;
	public static  int STOCK_MVMT_TYPE_TRANSFORMATION=5;
	
	public static  int STOCK_MVMT_REF_SALES=1;
	public static  int STOCK_MVMT_REF_JOBWORK=2;
	public static  int STOCK_MVMT_REF_INTERNAL_ISSUE=3;
	public static  int STOCK_MVMT_REF_INTERNAL_RETURN=4;
	public static  int STOCK_MVMT_REF_PURCHASE_RETURN=5;
	public static  int STOCK_MVMT_ITEM_TRANSFORMATION=7;
	public static  int STOCK_MVMT_REF_OPTICAL_DELIVERY=8;
	
	public static  int STORETYPE_PHARMACY=1;
	public static  int STORETYPE_OPTICALS=2;
	public static  int STORETYPE_GENERAL_ITEM=3;
	public static  int STORETYPE_IMPLANTS=4;
	public static  int STORETYPE_ASSETS=5;
	public static  int STORETYPE_SPARES=6;
	public static  int STORETYPE_LAB=7;
	public static  int STORETYPE_IOL=8;
	public static  int STORETYPE_CONTACT_LENS=9;
	public static  int STORETYPE_LINEN=10;
	
	static public int REF_PHARMACY_RETAIL_SALE=1;
	static public int REF_PHARMACY_OT_SALE=2;
	static public int REF_PHARMACY_WARD_SALE=3;
	
	static public int DIF_TRAN_ITEM_RETURN=5;
	static public int Encounter_type_of_visit_in_patient = 1;
	public static final int Encounter_type_of_visit_pharmacy = 5;
	public static final int DIF_TRAN_PHARMACY_SALES = 3;
	public static final int DIF_TRAN_VENDOR_PAYMENT=8;
	public static final int DIF_TRAN_PHARMACY_RETURN = 12;
	public static final int DIF_TRAN_PAYGEN=29;
	
	static final public int INDENT_ISSUE_STATUS_ISSUE=1;
	static final public int INDENT_ISSUE_STATUS_RECEIVE=2;

	static public final int DIRECT_INVOICE_RECEIPT=1;
	static public final int MRN_INVOICE_RECEIPT=2;
	static public final int OPTICAL_FITTING_RECEIPT=3;

	static public int SRC_SALES_RETURN=7;
	static public int SRC_MRN_RECEIPT=12;
	static public int SRC_MRN_RETURN=13;
	static public int SRC_PHARMACY_SALES=22;
	static public int SRC_CUSTOMER_ORDER=1000;
	static public int SRC_CUSTOMER_ORDER_INVOICE=1001;
	static public int SRC_STOCK_JOURNAL=1002;
	static public int SRC_STOCK_Verification=1003;
	static public int SRC_Sales_quote=1004;
	
	static public int SRC_PO=100;
	static public int SRC_VENDOR_INVOICE=101;
	static public int SRC_PAY_GEN=102;
	static public int SRC_indent_receive=103;
	static public int SRC_SALES_ORDER=105;
	static public int SRC_PAY_GEN_Advance=106;
	static public int SRC_PAY_GEN_Advance_Return=107;
	static public int SRC_CUSTOMER_Advance=108;
	static public int SRC_CUSTOMER_Receipt=109;
	static public int SRC_Asset_Receipt=110;
	static public int SRC_Asset_Sale=111;
	static public int SRC_Asset_Scrap=112;
	
	static public int PAY_CATEGORY_VENDOR_PAYMENT=1;
	static public int PAY_CATEGORY_SALARY_PAYMENT=2;
	static public int PAY_CATEGORY_PETTY_CASH=3;
	static public int PAY_CATEGORY_CONSULTANT_PAYMENT=4;
	static public int PAY_CATEGORY_NON_INVOICE_PAYMENT=5;
	static public int PAY_CATEGORY_RECURRING_PAYMENTS=6;
	static public int PAY_CATEGORY_EMPLOYEE_LOAN=7;
	static public int PAY_CATEGORY_VENDOR_ADVANCE=8;
	
	
	
	static public int PAYMENTMODE_CARD=1;
	static public int PAYMENTMODE_CHEQUE=2;
	static public int PAYMENTMODE_CASH=3;
	static public int PAYMENTMODE_ADVADJ=4;
	static public int PAYMENTMODE_EFT=5;
	static public int PAYMENTMODE_ECS=6;
	static public int PAYMENTMODE_INSADJ=7;
	static public int PAYMENTMODE_INSURANCE_REJECTION=8;
	static public int PAYMENTMODE_CORP_ADJ=9;
	static public int PAYMENTMODE_INTERNAL_ADJ=10;
	static public int PAYMENTMODE_LOYALTY_ADJ=11;
	static public int PAYMENTMODE_CREDIT=12;
	static public int PAYMENTMODE_CREDIT_REJECTION=13;
	
	
	static public int FIN_TRAN_RECEIPT=1;
	static public int FIN_TRAN_WITHDRAWALS=2;
	static public int FIN_TRAN_SALARY_PAYMENT=3;
	static public int FIN_TRAN_VENDOR_PAYMENT=4;
	static public int FIN_TRAN_LOAN=5;
	static public int FIN_TRAN_PETTY_CASH=6;
	static public int FIN_TRAN_SALES_RETURN=7;
	static public int FIN_TRAN_ADVANCE=8;
	static public int FIN_TRAN_ADVANCE_REFUND=9;
	static public int FIN_TRAN_INSURANCE_CLAIMS=10;
	static public int FIN_TRAN_BILLING_REFUND=11;
	static public int FIN_TRAN_CASH_EXPENSES=12;
	static public int FIN_TRAN_CONSULTANT_PAYMENT=13;
	static public int FIN_TRAN_REFERRAL_PAYMENT=14;
	static public int FIN_TRAN_MISCELLANEOUS_RECEIPTS=15;
	static public int FIN_TRAN_VENDOR_PAYMENT_RETURN=16;
	
	static public int FIN_BANK_PENDING_ACC=2;
	static public int FIN_BANK_HOLD_ACC=3;
	static public int FIN_BANK_CURRENT_ACC=1;
	
	static public int FIN_CHEQUE_TYPE_RECEIPT=1;
	static public int FIN_CHEQUE_TYPE_ISSUED=2;
	
	static public int CHEQUE_STATUS_RECEIVED=1;
	static public int CHEQUE_STATUS_DEPOSITED=2;
	static public int CHEQUE_STATUS_ISSUED=3;
	static public int CHEQUE_STATUS_CLEARED=4;
	static public int CHEQUE_STATUS_BOUNCED=5;
	
	public static int MRN_TYPE_PHARMACY=1;
	public static int MRN_TYPE_OPTICAL=2;
	public static int MRN_TYPE_GENERAL=3;
	public static int MRN_TYPE_LAB=4;
	public static int MRN_TYPE_ASSET=5;
	public static int MRN_TYPE_SPARE=6;
	public static int MRN_TYPE_LINEN=7;
	
	public static final int xls_run_status_inital = CodeList.getCodeFromLabel("xls_run_status", "inital");
	public static final int xls_run_status_validate_success = CodeList.getCodeFromLabel("xls_run_status", "validate_success");
	public static final int xls_run_status_validate_failed = CodeList.getCodeFromLabel("xls_run_status", "validate_failed");
	public static final int xls_run_status_process_success = CodeList.getCodeFromLabel("xls_run_status", "process_done");
	public static final int xls_run_status_process_failed = CodeList.getCodeFromLabel("xls_run_status", "process_failed");
	public static final int xls_run_status_data_freeze = CodeList.getCodeFromLabel("xls_run_status", "data_freeze");
	public static final int xls_run_status_cancelled = CodeList.getCodeFromLabel("xls_run_status", "Process_cancelled");
	
	public final static int MAX_INT_VALUE = 2147483647;

}
