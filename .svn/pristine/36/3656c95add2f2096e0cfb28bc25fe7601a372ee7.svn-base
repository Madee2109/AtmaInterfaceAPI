package org.bte.bean.ws;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bte.bean.JSFFacesUtil;
import org.bte.framework.ws.BTEWSService;
import org.bte.framework.ws.WSServiceDTO;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.shaded.json.JSONObject;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfDocument;

@ManagedBean ( name = "APIRun" )
@ViewScoped
public class APIRun {

	private WSServiceDTO serobj ;
	private String request_ex;
	private String response_ex;
	private String url;
	InputStream media_stream;
	private String contenttype="";
	private String filename="";
	   private boolean showmedia;
	   private boolean downloadflag;
	public APIRun() {
		
		onload();
	}
	
	public void onload(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(facesContext==null) {
			//return CodeList.getLabelFromCode("subreport", 1);
		}else {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			 url = req.getRequestURL().toString();
			url = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/wsservice";
			
			
		}
		int service_ex_id=JSFFacesUtil.getParam("service_ex_id");
		if(service_ex_id>0) {
			serobj = BTEWSService.getServiceExample(service_ex_id).get(0);
			request_ex = serobj.getWs_service_request_ex();
			JSONObject jsonmain = new JSONObject(request_ex);
			if(jsonmain.isNull("client_id")==false){
				jsonmain.put("client_id", "atma-arh-diahome");
			}
			if(jsonmain.isNull("client_aut_token")==false){
				jsonmain.put("client_aut_token", "atma-arh-diahome-102");
			}
			request_ex = jsonmain.toString(1);
		}
		
	}
	
public  void run() {
	response_ex = "";
	 contenttype="";
	 downloadflag = false;
	 if(showmedia){
		 JSFFacesUtil.viewPDFclear();
		 showmedia = false;
	 }
	
		try{
		URLConnection connection = new URL(url).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json" );
		
		
		
		OutputStream output = connection.getOutputStream();
		 output.write(request_ex.getBytes());
		
		 media_stream = connection.getInputStream();
		 contenttype = connection.getContentType();

		if(contenttype.contains("json")){
			response_ex = IOUtils.toString(media_stream);
			filename = "filename.json";
			downloadflag = true;
		}else if(contenttype.contains("pdf")){
			showmedia = true;
			JSFFacesUtil.viewPDF(media_stream);
			filename="filename.pdf";
			downloadflag = true;
		}
		output.close();
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

		public void download() {
			try{
			
			
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			HttpServletResponse response = (HttpServletResponse) externalContext
					.getResponse();
			
			externalContext.setResponseContentType(contenttype);
			externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + filename+ "\"");
			if(contenttype.endsWith("json")) {
				response.getOutputStream().write(response_ex.getBytes());
			}else {
			//IOUtils.copy(in, response.getOutputStream());
			}
			response.setContentType(contenttype);  
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename+ "\""); 
			response.getOutputStream().flush();
			response.getOutputStream().close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequest_ex() {
		return request_ex;
	}

	public void setRequest_ex(String request_ex) {
		this.request_ex = request_ex;
	}

	public String getResponse_ex() {
		return response_ex;
	}

	public void setResponse_ex(String response_ex) {
		this.response_ex = response_ex;
	}

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	

	
	public boolean isShowmedia() {
		return showmedia;
	}

	public void setShowmedia(boolean showmedia) {
		this.showmedia = showmedia;
	}

	public boolean isDownloadflag() {
		return downloadflag;
	}

	public void setDownloadflag(boolean downloadflag) {
		this.downloadflag = downloadflag;
	}
	
}
