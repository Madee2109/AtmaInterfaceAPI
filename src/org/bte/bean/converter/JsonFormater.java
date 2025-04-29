package org.bte.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.shaded.json.JSONObject;

@FacesConverter(value = "JsonFormater")
public class JsonFormater implements Converter {

	 public String getAsString(FacesContext context, UIComponent component, Object entity) {
		String  request_ex =entity.toString();
		try {
		if(request_ex !=null && request_ex.trim().length()>1){
			
			JSONObject jsonmain = new JSONObject(request_ex);
			request_ex = jsonmain.toString(1);
			//request_ex = request_ex.replaceAll("\n  \"", "<br/>&nbsp;&nbsp;\"");
			//request_ex = request_ex.replaceAll("\n \"", "<br/>&nbsp;\"");
			request_ex = request_ex.replaceAll(" ", "&nbsp;");
			request_ex = request_ex.replaceAll("\n", "<br/>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return request_ex;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String uuid) {
        
        return null;
    }

}
