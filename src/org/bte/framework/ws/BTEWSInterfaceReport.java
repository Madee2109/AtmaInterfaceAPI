package org.bte.framework.ws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.bte.core.utils.HibernateUtil;
import org.bte.framework.report.ReportDTO;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

public abstract class BTEWSInterfaceReport implements BTEWSInterface{

	 byte[] bytes;
	 HttpServletRequest req;
	 ServletResponse res;
	 public  WSRequestDTO reqdto=null;
	 String contenttype="";
	 public boolean inital(WSRequestDTO reqdto,HttpServletRequest req,ServletResponse res) {
		 this.reqdto = reqdto;
			this.req =req;
			this.res = res;
			return true;
	}


	
	public void writeResult() {
try {
			
			
			res.setContentType(contenttype);
			res.getOutputStream().write(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void getResponse() {
		reqdto.setWs_req_response(contenttype);
	}

	public void generateReport(String format,String report_name,Map reportArgs){

	

		
		String file_name="report";
		try {
			
			String url = req.getRequestURL().toString();
			url = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
		
			
			List<ReportDTO> list = getReportList(report_name);
			 InputStream reportStream = new URL(url+list.get(0).getReport_file_name()).openStream();
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream,reportArgs,ClientServerDBConnection.getConnection(reqdto.getUserdto())); 
			 
			 
			JRExporter exporter = null;
			
			if(format.equalsIgnoreCase("xlsx")){
				exporter = new JRXlsxExporter();
				reportArgs.put(JRParameter.IS_IGNORE_PAGINATION, true);	
				reportArgs.put(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);	
				reportArgs.put(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);	
				
				reportArgs.put("IS_IGNORE_PAGINATION", true);	
				reportArgs.put("net.sf.jasperreports.export.xls.remove.empty.space.between.rows", "true");
				contenttype="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
				file_name=file_name+".xlsx";
			}else{
				contenttype="application/pdf";
				file_name=file_name+".pdf";
				exporter = new JRPdfExporter();
			}
			 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	 			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
				 exporter.exportReport();
			    bytes = byteArrayOutputStream.toByteArray();
			   // Files.write(Paths.get("/home/btec-server/Documents/settlement11.pdf"), bytes);
			       
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	
	}
	
	public List<ReportDTO> getReportList(String reportname){
		List<ReportDTO> reportList = new ArrayList<ReportDTO>();
		
		Session session = HibernateUtil.getSession();
		try{
			String strSQL = " SELECT  report_title,report_footer, t.`report_name`, t.`report_file_name`, t.`report_type`, report_notes  "
					+ " FROM tb_reports t "
					+ " WHERE report_name = ? ";
			
	
			reportList = session.createSQLQuery(strSQL).setParameter(0, reportname).setResultTransformer(Transformers.aliasToBean(ReportDTO.class)).list();
			HibernateUtil.closeSession();
		}catch(Exception e){
			HibernateUtil.closeSession();
		}
		
		return reportList;
	
	}
	
	
}
