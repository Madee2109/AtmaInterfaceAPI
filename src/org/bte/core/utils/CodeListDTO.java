package org.bte.core.utils;

import java.util.List;

import javax.faces.model.SelectItem;


public class CodeListDTO 
{

	public String  cl_group;
	public Integer cl_id;
	public String  cl_label;
	public String cl_default;
	public String cl_alternate_id_1;
    
	//newly added 
	public Integer cl_order;
	public Integer cl_flag;
	public String cl_flagLabel;
	public Integer maxcl_id;
	public Integer maxcl_order;
	public boolean change_status;
	public Integer insertstatus;
	
	//ADdded in Market
	List<SelectItem> SelectItemList;//
	public Integer cl_default_ClId;
	
	//newly addedd 
	private String cl_alternate_id_2;

	public Integer getMaxcl_order()
	{
		return maxcl_order;
	}
	public void setMaxcl_order(Integer maxclOrder) 
	{
		maxcl_order = maxclOrder;
	}
	public Integer getMaxcl_id()
	{
		return maxcl_id;
	}
	public void setMaxcl_id(Integer maxclId) 
	{
		maxcl_id = maxclId;
	}
	public Integer getCl_order() 
	{
		return cl_order;
	}
	public void setCl_order(Integer clOrder) 
	{
		cl_order = clOrder;
	}
	public Integer getCl_flag() 
	{
		return cl_flag;
	}
	public void setCl_flag(Integer clFlag) 
	{
		cl_flag = clFlag;
	}
	
	public String getCl_group()
	{
		return cl_group;
	}
	public void setCl_group(String clGroup) 
	{
		cl_group = clGroup;
	}
	public Integer getCl_id()
	{
		return cl_id;
	}
	public void setCl_id(Integer clId) 
	{
		cl_id = clId;
	}
	public String getCl_flagLabel() 
	{
		//cl_flagLabel=CodeList.getLabelFromCode("STATUS", cl_flag);
	    return cl_flagLabel;
	}
	public void setCl_flagLabel(String clFlagLabel) 
	{
		cl_flagLabel = clFlagLabel;
	}
	public String getCl_label()
	{
		return cl_label;
	}
	public void setCl_label(String clLabel) 
	{
		cl_label = clLabel;
	}
	public String getCl_default()
	{
		return cl_default;
	}
	public void setCl_default(String clDefault) 
	{
		cl_default = clDefault;
	}
	
	public void setCl_alternate_id_1(String clAlternateId_1) 
	{
		cl_alternate_id_1 = clAlternateId_1;
	}
	public String getCl_alternate_id_1() 
	{
		return cl_alternate_id_1;
	}
	public Integer getInsertstatus() 
	{
		return insertstatus;
	}
	public void setInsertstatus(Integer insertstatus) 
	{
		this.insertstatus = insertstatus;
	}
	
	public boolean isChange_status() 
	{
		return change_status;
	}
	public void setChange_status(boolean changeStatus) 
	{
		change_status = changeStatus;
	}
	public List<SelectItem> getSelectItemList() {
		return SelectItemList;
	}
	public void setSelectItemList(List<SelectItem> selectItemList) {
		SelectItemList = selectItemList;
	}
	public Integer getCl_default_ClId() {
		return cl_default_ClId;
	}
	public void setCl_default_ClId(Integer cl_default_ClId) {
		this.cl_default_ClId = cl_default_ClId;
	}
	public String getCl_alternate_id_2() {
		return cl_alternate_id_2;
	}
	public void setCl_alternate_id_2(String cl_alternate_id_2) {
		this.cl_alternate_id_2 = cl_alternate_id_2;
	}
	
}