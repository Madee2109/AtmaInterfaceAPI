package org.bte.framework.faces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.bte.bean.JSFFacesUtil;
import org.primefaces.component.commandbutton.CommandButton;


public class DataTableFrozen {



	
	
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
	
	private String datatablefrozen_css_name;
	private String datatablefrozen_css_style;
	
	
	private List<RFDataTableColumn> collist;
	private List<RFDataTableColumn> collist_all;

	private int dt_add_column_dt_id;

	private String dt_div_style;
	private String uid;
	
	private List data;
	private List filterdata;
	private int sort_col_id;
	private int sort_asc_type;
	public DataTableFrozen(String uid){
		this.uid = uid;
	}
	public void cleardata(){
		data = null;
		filterdata = null;
	}
	public void adddata(Object ob){
		data.add(ob);
		filterdata.add(ob);
		calculateFooter();
	}
	public void addColumn(String header,String exp,int footercal){
		RFDataTableColumn col = new RFDataTableColumn();
		col.setColumn_header(header);
		col.setColumn_value_exp("#{tablevar."+exp+"}");
		col.setColumn_value(exp);
		col.setColumn_footer_calculation(footercal);
		col.setColumn_footer_exp("#{cc.attrs.footervalue."+exp+"}");
		collist.add(col);
		collist_all.add(col);
	}
	public void removedata(Object ob){
		data.remove(ob);
		filterdata.remove(ob);
		calculateFooter();
	}
public void  actiondataTableFrozon(RFDataTableColumn col) throws ClassNotFoundException{
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		/**/
		String[] param = null;
				if(col.getColumn_method_exp_param()==null || col.getColumn_method_exp_param().length()>0){
					param= new String[0];
				}else{
					param = col.getColumn_method_exp_param().split(",");
				}
				Class[] class_obj = new Class[param.length];
				Object[] object_obj = new Object[param.length];
				
				for(int i=0;param.length>i;i++){
					ValueExpression	vexp =facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(),param[i], Object.class);
					object_obj[i] = vexp.getValue(facesContext.getELContext());
					class_obj[i] = object_obj[i].getClass();
				}
				
		
		MethodExpression	rexp =facesContext.getApplication().getExpressionFactory().createMethodExpression(facesContext.getELContext(), col.getColumn_method_exp(), null, class_obj);
		
		rexp.invoke(facesContext.getELContext(), new Object[]{object_obj});
		
		/*if(col.getColumn_method_update() !=null && col.getColumn_method_update().trim().length()>0){
			RequestContext.getCurrentInstance().update(col.getColumn_method_update());
		}*/
		//RequestContext.getCurrentInstance().execute("focusdivid('footer123')");
		
		}


	public String  footervaluedataTableFrozon(RFDataTableColumn col ) throws ClassNotFoundException{
		
		if(col.getColumn_footer_calculation()==1){
			
			double b = col.getFooter_cal_value();
			if(b==0){
				return "-";
			}else if(b>0){
				return formatwithoutpoint(b);
			}else{
				return "<div class='gstreconsummarynegative' >("+formatwithoutpoint(b*-1)+")</div>";
			}
		}
		
		if(col.getColumn_footer_exp()==null){
			return "";
		}
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		
			
			ValueExpression	rexp =facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(),col.getColumn_footer_exp(), Object.class);
			Object a = rexp.getValue(facesContext.getELContext());
			if( a==null ){
				return "-";
			}
			
			if(a instanceof Double){
				double b = (double)a;
				if(b==0){
					return "-";
				}else if(b>0){
					return formatwithoutpoint(b);
				}else{
					return "<div class='gstreconsummarynegative' >("+formatwithoutpoint(b*-1)+")</div>";
				}
			}
			return a+"";
		
		}
	public String actiononcomplate(RFDataTableColumn col ){

		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		if(col.getColumn_method_oncomplete()==null){
			return "hideProgress()";
		}
		
			
			ValueExpression	rexp =facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(),col.getColumn_method_oncomplete(), String.class);
			String a = (String) rexp.getValue(facesContext.getELContext());
			if( a==null ){
				return "hideProgress()";
			}
			
			
			return a+"hideProgress()";
	}
		public String  columnvaluedataTableFrozon(RFDataTableColumn col ) throws ClassNotFoundException{
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		
			
			ValueExpression	rexp =facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(),col.getColumn_value_exp(), Object.class);
			Object a = rexp.getValue(facesContext.getELContext());
			if( a==null ){
				return "-";
			}
			
			if(a instanceof Double){
				double b = (double)a;
				if(b==0){
					return "-";
				}else if(b>0){
					return formatwithoutpoint(b);
				}else{
					return "<div class='gstreconsummarynegative' >("+formatwithoutpoint(b*-1)+")</div>";
				}
			}
			return a+"";
		
		}
		private  String formatwithoutpoint(double a){

			long b = Math.round(a);
			if(b<1000){
				return b+"";
			}
			 String s = b+"";
			 String formatted = s.substring(s.length()-3);
			 s = s.substring(0, s.length()-3);
			  while(s.length()>1){
				  formatted = s.substring( s.length()-2)+","+formatted;
				  s = s.substring(0, s.length()-2);
			  }
			  if(s.length()==1){
				  formatted = s+","+formatted;
			  }
			 
		   
		    return formatted  ; 
		}
	public  void loadRFTable(String code){ 
		try{
		FacesServicePrimeFaces ser  = new FacesServicePrimeFaces();
		RFDataTable table = ser.getDataTable(1, code).get(0);
		dt_div_style = table.getDt_div_style();
		dt_header_text = table.getDt_header_text();
		dt_report_xls = table.isDt_report_xls();
	 	collist_all = ser.getDataTableColumn(1, null, table.getDt_id(),table.getDt_add_column_dt_id());
	 	collist = new ArrayList<RFDataTableColumn>();
			String css_name = "dynamictablecss_"+table.getDt_id();
			String css="";
			int width=0;
			int i=0;
		for(RFDataTableColumn col:collist_all) {
			
			if(col.isColumn_visible()){
				collist.add(col);
				if(col.getColumn_width()<=0){
					col.setColumn_width(100);
				}
				if(col.isColumn_sortable()){
					col.setSort_icon("fa fa-sort");
				}
				
				if(col.isColumn_filterable()){
					col.setColumn_filter_width(col.getColumn_width()<50?col.getColumn_width():50);
					if(col.getColumn_filterMatchMode()==null){
						col.setColumn_filterable(false);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("contains")){
						col.setColumn_filter_icon("%x%");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("startsWith")){
						col.setColumn_filter_icon("x%");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("endsWith")){
						col.setColumn_filter_icon("%x");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("lt")){
						col.setColumn_filter_icon(">x");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("lte")){
						col.setColumn_filter_icon("&#8804;x");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("gte")){
						col.setColumn_filter_icon("<x");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("equals")){
						col.setColumn_filter_icon("=x");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("numrange")){
						col.setColumn_filter_icon("&#8804;x&#8805;");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("dateEquals")){
						col.setColumn_filter_icon("=x");
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("dateRange")){
						col.setColumn_filter_icon("&#8804;x&#8805;");
					}
				}
				
				
				
				
				if(i<table.getDt_frozenColumns()){
					if(col.getColumn_type()==4){
	
					}
					
					
					css =css+ "."+css_name+" thead th:nth-child("+(i+1)+"){  left: "+width+"px;   width:"+col.getColumn_width()+"px;   min-width:"+col.getColumn_width()+"px;  z-index: 1;}"
							+ "."+css_name+" thead td:nth-child("+(i+1)+"){  left: "+width+"px;   width:"+col.getColumn_width()+"px;   min-width:"+col.getColumn_width()+"px;  z-index: 1;}"
							+ "."+css_name+" tbody td:nth-child("+(i+1)+") {  position: -webkit-sticky;   position: sticky; left:"+width+"px;  width:"+col.getColumn_width()+"px;  min-width:"+col.getColumn_width()+"px;   background: #fff; background-clip: padding-box; }"
							+ "."+css_name+" tfoot td:nth-child("+(i+1)+") {  position: -webkit-sticky;   position: sticky; left:"+width+"px;  width:"+col.getColumn_width()+"px;  min-width:"+col.getColumn_width()+"px;   background: var(--freezetabletable-footer-bg); background-clip: padding-box; }";
	
					/*String headerstyleclass = col.getColumn_header_style_class()==null?"":col.getColumn_header_style_class();
					String headerstyle = col.getColumn_header_style()==null?"":col.getColumn_header_style();
					String styleclass = col.getColumn_style_class()==null?"":col.getColumn_style_class();
					String style = col.getColumn_style()==null?"":col.getColumn_style();
					headerstyleclass = headerstyleclass +" freezetabletablecolumnheader";
					 headerstyle ="left: "+width+"px; width:"+col.getColumn_width()+"px; min-width:"+col.getColumn_width()+"px;"+headerstyle;
					 
					 styleclass = styleclass +" freezetabletablecolumn";
					 style ="left: "+width+"px; width:"+col.getColumn_width()+"px; min-width:"+col.getColumn_width()+"px;"+style;
				  
					  
					
					
					col.setColumn_header_style_class(headerstyleclass);
					col.setColumn_header_style(headerstyle);
					col.setColumn_style_class(styleclass);
					col.setColumn_style(style);*/
					width = width+col.getColumn_width();
					
					
				}
				i++;
			}
			
		}
		css = "<style>"+css+"</style>";
		setDatatablefrozen_css_name(css_name);
		setDatatablefrozen_css_style(css);
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	}
	public void exportXlSX(){
		SXSSFWorkbook wb = new SXSSFWorkbook(100);
		// DynamicReportExport.export(filterdata, collist_all,wb,"Excel Sheet",new ArrayList<String>());
		 String filename="result.xlsx";
			JSFFacesUtil.downloadXLSX(filename, wb);
	}
	public void resetValue( List data){
		this.data=data;
		filterdata = new ArrayList();
		filterdata.addAll(data);
		calculateFooter();
	}
	public void calculateFooter(){
		for(RFDataTableColumn col:collist){
			if(col.getColumn_footer_calculation()==1 && col.getColumn_value()!=null){
				
				col.setFooter_cal_value(0);
				
			}
			
		}
		for(Object ob:filterdata){
			Map<String,Object> map = (Map<String,Object>) ob;
			for(RFDataTableColumn col:collist){
				if(col.getColumn_footer_calculation()==1 && col.getColumn_value()!=null){
					
					col.setFooter_cal_value(col.getFooter_cal_value()+(map.get(col.getColumn_value())==null?0:Double.parseDouble(map.get(col.getColumn_value()).toString())));
					
				}
				/*if(col.isColumn_sortable()){
					col.setSort_icon("fa fa-sort");
				}*/
			}
		}
		
	}
	public void clickSort(RFDataTableColumn sele_col){
		if(sele_col.getColumn_id()==sort_col_id){
			sort_asc_type = sort_asc_type==1?2:1;
		}else{
			sort_col_id = sele_col.getColumn_id();
			sort_asc_type = 1;
		}
		sort(sele_col);
	}
	public void sort(RFDataTableColumn sele_col){
		for(RFDataTableColumn col:collist){
			col.setSort_icon("fa fa-sort");
			col.setSort_flag(0);
			
		}
		sele_col.setSort_flag(sort_asc_type);
		
		Collections.sort(filterdata,new CustomComparator(sele_col));
	}
	public void clickfilter(RFDataTableColumn sele_col1){
		
		Stream<Map<String,Object>> stream = data.stream();
		
		for (RFDataTableColumn col:collist) {
			if(col.isColumn_filterable()){
				if(col.getColumn_filter_value()!=null && col.getColumn_filter_value().isEmpty()==false){
					
					if(col.getColumn_filterMatchMode().equalsIgnoreCase("contains")){
						Predicate<Map<String,Object>> con = c -> c.get(col.getColumn_value())!=null &&  c.get(col.getColumn_value()).toString().toLowerCase().contains(col.getColumn_filter_value().toLowerCase());
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("startsWith")){
						Predicate<Map<String,Object>> con = c -> c.get(col.getColumn_value())!=null && c.get(col.getColumn_value()).toString().toLowerCase().startsWith(col.getColumn_filter_value().toLowerCase());
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("endsWith")){
						Predicate<Map<String,Object>> con = c -> c.get(col.getColumn_value())!=null && c.get(col.getColumn_value()).toString().toLowerCase().endsWith(col.getColumn_filter_value().toLowerCase());
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("lt")){
						Predicate<Map<String,Object>> con = c -> c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))<(Double.parseDouble(col.getColumn_filter_value()));
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("lte")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))<=(Double.parseDouble(col.getColumn_filter_value()));
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("gte")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))>=(Double.parseDouble(col.getColumn_filter_value()));
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("equals")){
						Predicate<Map<String,Object>> con = c -> c.get(col.getColumn_value())!=null && c.get(col.getColumn_value()).toString().equalsIgnoreCase(col.getColumn_filter_value());
						stream = stream.filter(con);
					}else if(col.getColumn_filterMatchMode().equalsIgnoreCase("numrange")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))>=(Double.parseDouble(col.getColumn_filter_value()));
						stream = stream.filter(con);
					}
				}
				
				
				if(col.getColumn_filter_value_to()!=null && col.getColumn_filter_value_to().isEmpty()==false){
					if(col.getColumn_filterMatchMode().equalsIgnoreCase("numrange")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))<=(Double.parseDouble(col.getColumn_filter_value_to()));
						stream = stream.filter(con);
					}
				
				}
				if(col.getColumn_filter_date_from()!=null ){
					if(col.getColumn_filterMatchMode().equalsIgnoreCase("dateEquals")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))<=(Double.parseDouble(col.getColumn_filter_value_to()));
						stream = stream.filter(con);
					}
				
					if(col.getColumn_filterMatchMode().equalsIgnoreCase("dateEquals")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))<=(Double.parseDouble(col.getColumn_filter_value_to()));
						stream = stream.filter(con);
					}
					
				}
				if(col.getColumn_filter_date_to()!=null ){
					
				
					if(col.getColumn_filterMatchMode().equalsIgnoreCase("dateEquals")){
						Predicate<Map<String,Object>> con = c ->  c.get(col.getColumn_value())!=null && ((Double)c.get(col.getColumn_value()))<=(Double.parseDouble(col.getColumn_filter_value_to()));
						stream = stream.filter(con);
					}
					
				}
				
			}
			
		}
		
		
		
		filterdata =	 (List<Map<String,Object>>) stream.collect(Collectors.toList()); 
		if(sort_col_id>0){
			//sort();
		}
		
		calculateFooter();
		
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
	public List<RFDataTableColumn> getCollist() {
		return collist;
	}
	public void setCollist(List<RFDataTableColumn> collist) {
		this.collist = collist;
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
	public String getDatatablefrozen_css_name() {
		return datatablefrozen_css_name;
	}
	public void setDatatablefrozen_css_name(String datatablefrozen_css_name) {
		this.datatablefrozen_css_name = datatablefrozen_css_name;
	}
	public String getDatatablefrozen_css_style() {
		return datatablefrozen_css_style;
	}
	public void setDatatablefrozen_css_style(String datatablefrozen_css_style) {
		this.datatablefrozen_css_style = datatablefrozen_css_style;
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
	public int getSort_col_id() {
		return sort_col_id;
	}
	public void setSort_col_id(int sort_col_id) {
		this.sort_col_id = sort_col_id;
	}
	
	
	
	

}
