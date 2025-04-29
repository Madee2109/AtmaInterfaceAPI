package org.bte.bean.converter;


import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;





@FacesConverter(value = "ConverterDateTime")

public class ConverterDateTime  extends DateTimeConverter{

	public ConverterDateTime() {
		super();
		
        setPattern("dd MMM yyyy hh:mm a");
       
    }

   

}
