package org.bte.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.primefaces.PrimeFaces;


public class JSFFacesUtil {

	public static int getParam(String paramName){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Object data=facesContext.getExternalContext().getRequestParameterMap().get(paramName);
		if(data!=null){
			return Integer.parseInt(data.toString());
			
		}return 0;		
	}
	public static UserContext getUserContext(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UserContext userContext = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}",UserContext.class);
		return userContext;
	
	}
	public static String getRequestParam(String key){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, String> parameterMap = (Map<String, String>) externalContext.getRequestParameterMap();
		System.out.println(parameterMap.toString());
		return  parameterMap.get(key);
		

	}
	public static void pushFlashParam(String key,Object value){
		 Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		 flash.put(key, value);

	}
	public static Object getFlashParam(String key){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Object data=facesContext.getExternalContext().getRequestParameterMap().get(key);
		if(data!=null){
			return data;
			
		}
		
		Flash flash = facesContext.getExternalContext().getFlash();
		Object value = flash.get(key);
		flash.remove(key);
		return  value;

	}
	public static void viewPDF(InputStream in){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		PrimefacesMedia mediabean = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{PrimefacesMedia}",PrimefacesMedia.class);
		mediabean.write("result.pdf", "application/pdf", in);
		
	}
	public static void viewPDFclear(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		PrimefacesMedia mediabean = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{PrimefacesMedia}",PrimefacesMedia.class);
		mediabean.clear();
		
		
	}
	public static void download(String filename,InputStream in,String contenttype){

		try{
			
		
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		
		externalContext.setResponseContentType(contenttype);
	    externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + filename+ "\"");
	   
	    IOUtils.copy(in, response.getOutputStream());
		response.setContentType(contenttype);  
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename+ "\""); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void downloadXLSX(String filename,SXSSFWorkbook wb){

		try{
			
		
		
		String contenttype = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		
		externalContext.setResponseContentType(contenttype);
	    externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + filename+ "\"");
	    wb.write(response.getOutputStream());
		response.setContentType(contenttype);  
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename+ "\""); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public static  ValueExpression valueExpression(FacesContext context,String stringExpression ,Class classtype) {
		ValueExpression exp =context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(),
	            stringExpression, classtype);
		return exp;
	}
	public static void redirect(String page){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			facesContext.getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void showMessage(String message1,String notes,boolean saveMassage){
		if(saveMassage){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(message1));
	      //  RequestContext.getCurrentInstance().update("growl");
			
		}
		else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, message1, notes);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			//RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}
	
	public static void exeJavaScript(String script){
		PrimeFaces.current().executeScript(script);
		// RequestContext.getCurrentInstance().execute(script);
	}
	public static void openDialogBox(String page, Map<String, Object> options, Map<String, List<String>> param){
		/*RequestContext context = RequestContext.getCurrentInstance();
		context.openDialog(page, options, param);*/
		
		PrimeFaces.current().dialog().openDynamic(page, options, param);
		
	}
	public static void closeDialogBox(Object obl){
		/*RequestContext context = RequestContext.getCurrentInstance();
		context.closeDialog(obl);*/
		PrimeFaces.current().dialog().closeDynamic(obl);
	}
	public static void showMessageInDialog( FacesMessage message ){
		FacesContext.getCurrentInstance().addMessage(null, message);
		//  RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/*public static void updateComponentID(String id){
		
		//PrimeFaces.current().
		//RequestContext.getCurrentInstance().update(id);
	}*/
}
