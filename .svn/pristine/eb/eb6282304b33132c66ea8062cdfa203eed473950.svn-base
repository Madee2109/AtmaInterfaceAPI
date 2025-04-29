package org.bte.framework.faces;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;


public class RFDataTable {

	
			
	private String dt_code;
	private Integer dt_rows;
	private boolean dt_paginator;
	private boolean dt_lazy;
	private boolean dt_stickyHeader;
	private boolean dt_refresh;
	private String dt_refresh_action;
	private String dt_paginatorPosition ;

	private boolean dt_paginatorAlwaysVisible ;

	private int dt_pageLinks ;
	
	private boolean dt_report_pdf;
	private boolean dt_report_csv;
	private boolean dt_report_xls;
	private boolean dt_report_xml;
	
	private boolean dt_resizableColumns ;
	private int dt_frozenColumns ;
	private boolean dt_draggableColumns ;

	private int dt_frozenRows;
	
	private boolean dt_caseSensitiveSort ;
	private boolean dt_reflow ;
	private boolean dt_rowHover; 

	
	private int dt_id;

	private String dt_header_text;
	private String dt_footer_notes;
	
	private int dt_add_column_dt_id;

	private String uid;
	private String dt_div_style;
	private List data;
	private List filterdata;
	public RFDataTable(){
		
	}
	
	public RFDataTable(String uid){
		this.uid = uid;
	}
	
	public String getDt_header_text() {
		return dt_header_text;
	}
	public void setDt_header_text(String dt_header_text) {
		this.dt_header_text = dt_header_text;
	}
	public String getDt_footer_notes() {
		return dt_footer_notes;
	}
	public void setDt_footer_notes(String dt_footer_notes) {
		this.dt_footer_notes = dt_footer_notes;
	}
	
	public String getDt_paginatorPosition() {
		return dt_paginatorPosition;
	}
	public void setDt_paginatorPosition(String dt_paginatorPosition) {
		this.dt_paginatorPosition = dt_paginatorPosition;
	}
	public boolean isDt_paginatorAlwaysVisible() {
		return dt_paginatorAlwaysVisible;
	}
	public void setDt_paginatorAlwaysVisible(boolean dt_paginatorAlwaysVisible) {
		this.dt_paginatorAlwaysVisible = dt_paginatorAlwaysVisible;
	}
	public int getDt_pageLinks() {
		return dt_pageLinks;
	}
	public void setDt_pageLinks(int dt_pageLinks) {
		this.dt_pageLinks = dt_pageLinks;
	}
	public boolean isDt_report_pdf() {
		return dt_report_pdf;
	}
	public void setDt_report_pdf(boolean dt_report_pdf) {
		this.dt_report_pdf = dt_report_pdf;
	}
	public boolean isDt_report_csv() {
		return dt_report_csv;
	}
	public void setDt_report_csv(boolean dt_report_csv) {
		this.dt_report_csv = dt_report_csv;
	}
	public boolean isDt_report_xls() {
		return dt_report_xls;
	}
	public void setDt_report_xls(boolean dt_report_xls) {
		this.dt_report_xls = dt_report_xls;
	}
	public boolean isDt_report_xml() {
		return dt_report_xml;
	}
	public void setDt_report_xml(boolean dt_report_xml) {
		this.dt_report_xml = dt_report_xml;
	}
	public boolean isDt_resizableColumns() {
		return dt_resizableColumns;
	}
	public void setDt_resizableColumns(boolean dt_resizableColumns) {
		this.dt_resizableColumns = dt_resizableColumns;
	}
	public int getDt_frozenColumns() {
		return dt_frozenColumns;
	}
	public void setDt_frozenColumns(int dt_frozenColumns) {
		this.dt_frozenColumns = dt_frozenColumns;
	}
	public boolean isDt_draggableColumns() {
		return dt_draggableColumns;
	}
	public void setDt_draggableColumns(boolean dt_draggableColumns) {
		this.dt_draggableColumns = dt_draggableColumns;
	}
	public int getDt_frozenRows() {
		return dt_frozenRows;
	}
	public void setDt_frozenRows(int dt_frozenRows) {
		this.dt_frozenRows = dt_frozenRows;
	}
	public boolean isDt_caseSensitiveSort() {
		return dt_caseSensitiveSort;
	}
	public void setDt_caseSensitiveSort(boolean dt_caseSensitiveSort) {
		this.dt_caseSensitiveSort = dt_caseSensitiveSort;
	}
	public boolean isDt_reflow() {
		return dt_reflow;
	}
	public void setDt_reflow(boolean dt_reflow) {
		this.dt_reflow = dt_reflow;
	}
	public boolean isDt_rowHover() {
		return dt_rowHover;
	}
	public void setDt_rowHover(boolean dt_rowHover) {
		this.dt_rowHover = dt_rowHover;
	}
	public String getDt_code() {
		return dt_code;
	}
	public void setDt_code(String dt_code) {
		this.dt_code = dt_code;
	}
	public Integer getDt_rows() {
		return dt_rows;
	}
	public void setDt_rows(Integer dt_rows) {
		this.dt_rows = dt_rows;
	}
	public boolean isDt_paginator() {
		return dt_paginator;
	}
	public void setDt_paginator(boolean dt_paginator) {
		this.dt_paginator = dt_paginator;
	}
	public boolean isDt_lazy() {
		return dt_lazy;
	}
	public void setDt_lazy(boolean dt_lazy) {
		this.dt_lazy = dt_lazy;
	}
	public boolean isDt_stickyHeader() {
		return dt_stickyHeader;
	}
	public void setDt_stickyHeader(boolean dt_stickyHeader) {
		this.dt_stickyHeader = dt_stickyHeader;
	}
	public boolean isDt_refresh() {
		return dt_refresh;
	}
	public void setDt_refresh(boolean dt_refresh) {
		this.dt_refresh = dt_refresh;
	}
	public String getDt_refresh_action() {
		return dt_refresh_action;
	}
	public void setDt_refresh_action(String dt_refresh_action) {
		this.dt_refresh_action = dt_refresh_action;
	}
	public int getDt_id() {
		return dt_id;
	}
	public void setDt_id(int dt_id) {
		this.dt_id = dt_id;
	}
	
	public int getDt_add_column_dt_id() {
		return dt_add_column_dt_id;
	}
	public void setDt_add_column_dt_id(int dt_add_column_dt_id) {
		this.dt_add_column_dt_id = dt_add_column_dt_id;
	}
	
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public List getFilterdata() {
		return filterdata;
	}
	public void setFilterdata(List filterdata) {
		this.filterdata = filterdata;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDt_div_style() {
		return dt_div_style;
	}

	public void setDt_div_style(String dt_div_style) {
		this.dt_div_style = dt_div_style;
	}
	
	
	
	
}
