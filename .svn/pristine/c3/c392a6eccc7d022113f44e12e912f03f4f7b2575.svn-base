package org.bte.framework.faces;

import java.util.Comparator;
import java.util.Map;

public class CustomComparator implements Comparator<Map<String,Object>>{


	RFDataTableColumn col;
		public CustomComparator(RFDataTableColumn col){
			this.col = col;
		}
		public int compare(Map<String,Object> o1, Map<String,Object> o2) {
			// TODO Auto-generated method stub
			String prop = col.getColumn_value();
			if(col.getSort_flag()==1){
				if(o2.get(prop)  == null){
					return 1;
				}
				if(o1.get(prop)  == null){
					return -1;
				}
				//String a1= o1.get(prop).toString();
				//String a2= o2.get(prop).toString();
				
				
				if(col.getColumn_class().contains("String")){
					col.setSort_icon("fa fa-sort-alpha-asc");
					return o1.get(prop).toString().compareTo(o2.get(prop).toString());
				}if(col.getColumn_class().contains("Double")){
					col.setSort_icon("fa fa-sort-numeric-asc");
					return ((Double)o1.get(prop)).compareTo(((Double)o2.get(prop)));
					//return (Double.parseDouble(o2.get(prop).toString()) > Double.parseDouble(o1.get(prop).toString()))?-1:1;
					
				}
			}else{
				if(o2.get(prop)  == null){
					return -1;
				}
				if(o1.get(prop)  == null){
					return 1;
				}
				if(col.getColumn_class().contains("String")){
					col.setSort_icon("fa fa-sort-alpha-desc");
					return o2.get(prop).toString().compareTo(o1.get(prop).toString());
				}if(col.getColumn_class().contains("Double")){
					col.setSort_icon("fa fa-sort-numeric-desc");
					//return (Double.parseDouble(o1.get(prop).toString()) > Double.parseDouble(o2.get(prop).toString()))?-1:1;
					return ((Double)o2.get(prop)).compareTo(((Double)o1.get(prop)));
				}
			}
			
			return 0;
		}
	
}
