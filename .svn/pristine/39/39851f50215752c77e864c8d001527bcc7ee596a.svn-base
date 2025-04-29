package org.bte.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.bte.bean.UserContext;
import org.bte.framework.error.ErrorCode;
import org.bte.framework.error.ExceptionHandler;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.bte.framework.error.Log;

public class IDSequenceGenerator {
	
	public static int getNextSequenceInt(String tableName){
		return Integer.parseInt(getNextSequence(tableName));
	}
	public static String getNextSequence(String seqName)
	{
		Session session = HibernateUtil.getSession();
		List <Core_table> idData;
		Date dt = Calendar.getInstance().getTime();
		Core_table id = null;
		String idString = null;
		String sql = " select id, table_name from id_coretable where table_name=?";
		String sql1 = "update id_coretable set id=id+1,date=? where table_name=?";

		HibernateUtil.beginTransaction();
		try
		{
			session.createSQLQuery(sql1).setParameter(0, dt).setParameter(1, seqName).executeUpdate();
			idData=session.createSQLQuery(sql).setParameter(0, seqName).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
			if (idData.size() == 0)
			{
				ExceptionHandler.putError(ErrorCode.error_code_id_code_table_script_missing,"table-name"+seqName);
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
			id = idData.get(0);
			idString = ""+id.getid();
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			ExceptionHandler.putError(ErrorCode.error_code_id_code_table_script_missing,e,"table-name"+seqName);
			
			return null;
		}
		
		
		  
		return idString;
		
	}
	
	
	
	
	public static String getBarcode(String table_name, int org_id){
		Session session = HibernateUtil.getSession();
		List<Core_table> idData;
		
		int id;
		String idString = null;
		HibernateUtil.beginTransaction();
		try
		{
			String sql1="update id_coretable set id=id+1 where table_name='"+table_name+"' and org_id="+org_id+"";
			SQLQuery qry=session.createSQLQuery(sql1);
			if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
				
			}
			String sql = "select id, prefix, suffix from id_coretable where table_name='"+table_name+"' and org_id="+org_id+"";
			idData=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
			if (idData.size() == 0)
			{
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
			
			id = idData.get(0).getid();
			StringBuffer s=new StringBuffer();
			
			
			if(idData.get(0).getPrefix()!=null)
				s.append(idData.get(0).getPrefix());
			
			s.append(id);
			
			if(idData.get(0).getSuffix()!=null)
				s.append(idData.get(0).getSuffix());
			
			idString = s.toString();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			e.printStackTrace();
			return null;
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		  
		return idString;
		
	}
	
	public static String getAssetTagId(int item_id){
		
		Session session = HibernateUtil.getSession();
		List<Core_table> idData;
		
		String idString = null;
		

		HibernateUtil.beginTransaction();
		try
		{
			String sql1="update tb_asset_group set asset_group_tag_last=asset_group_tag_last+1 where  item_id="+item_id+"";
			SQLQuery qry=session.createSQLQuery(sql1);
			if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
				
			}
			
			String sql = "select asset_group_tag_last AS  id, asset_group_tag_prefix AS  prefix from tb_asset_group where  item_id="+item_id+"";
			idData=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
			if (idData.size() == 0)
			{
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
			idString = idData.get(0).getPrefix()+idData.get(0).getid();
			
			
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			Log.exception(e);
			return null;
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		  
		return idString;
	}
	public static synchronized String getPrintNo(String table_name, int org_id,boolean printflag,HashMap<String,Object> obj)
	{
		
		Session session = HibernateUtil.getSession();
		List<Core_table> idData;
		SQLQuery qry;
		int id;
	
		DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
		
		HibernateUtil.beginTransaction();
		try
		{
			Date date =null;
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if(facesContext!=null) {
				UserContext userContext = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{UserContext}",UserContext.class);
				if(userContext!=null) {
					date = userContext.getTransaction_date();
				}
			}
			date = date == null?new Date():date;
			String datepattent = df1.format(date);
			String sql = "select id, prefix,rule,date ,id_format,suffix,core_id  "
					+ " from id_coretable where table_name='"+table_name+"' "
							+ " AND id_fromdate <= '"+datepattent+"' AND (id_todate >='"+datepattent+"' OR id_todate IS NULL ) ";
			idData=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
			if(idData.size()==0){
				
				ExceptionHandler.putError(ErrorCode.error_code_id_code_table_script_missing,"table-name"+table_name);
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
				
				id = idData.get(0).getid();
				String prefix=idData.get(0).getPrefix();
				id=id+1;
				String rule=idData.get(0).getRule();
				rule=rule==null? "" :rule.trim();
				if(rule.contains("checkprintflag") && printflag==false){
					HibernateUtil.commitTransaction();
					HibernateUtil.closeSession();
					return "";
			
				}
				
			sql="update id_coretable set id="+id+",date='"+datepattent+"' where core_id = "+idData.get(0).getCore_id();
			 qry=session.createSQLQuery(sql);
			if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
			
			
			id = idData.get(0).getid();
			
			String idString = "";
			String suffix=idData.get(0).getSuffix();
			
			if(idData.get(0).getId_format()!=null && idData.get(0).getId_format().trim().isEmpty()==false){
				idString = String.format(idData.get(0).getId_format().trim(),(id));
			}else{
				idString = id+"";
			}
			if(prefix != null){
				idString = prefix+idString;
			}
			if(suffix!=null){
				idString = idString+suffix;
			}
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return idString;
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			Log.exception(e);
			return null;
		}
	}
	
	/*
	
	public static String getPrintNo(String table_name, int org_id,boolean printflag,HashMap<String,Object> obj)
	{
		
		Session session = HibernateUtil.getSession();
		List<Core_table> idData;
		SQLQuery qry;
		int id;
	
		DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
		
		HibernateUtil.beginTransaction();
		try
		{
			String sql = "select id, prefix,rule,date ,id_format,suffix from id_coretable where table_name='"+table_name+"' and org_id="+org_id+"";
			idData=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
			if(idData.size()==0){
			
				sql = "insert into id_coretable (id, prefix,rule,date,table_name,org_id) values (?, ?, ?, ?, ?, ?)";
				Query sqlqry = 	 session.createSQLQuery(sql).setParameter(0, 0)
																.setParameter(1, "")
																.setParameter(2, "")
																.setParameter(3, df1.format(new Date()))
																.setParameter(4, table_name)
																.setParameter(5, org_id);
				if (sqlqry.executeUpdate() == 0) {
					HibernateUtil.rollbackTransaction();
					HibernateUtil.closeSession();
					return null;
				}
				 sql = "select id, prefix,rule,date,suffix  from id_coretable where table_name='"+table_name+"' and org_id="+org_id+"";
				idData=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
				if(idData==null || idData.size()==0){
					HibernateUtil.rollbackTransaction();
					HibernateUtil.closeSession();
					return null;
				}
				
			}
				
				id = idData.get(0).getid();
				String prefix=idData.get(0).getPrefix();
				id=id+1;
				String rule=idData.get(0).getRule();
				rule=rule==null? "" :rule.trim();
				if(rule.contains("checkprintflag") && printflag==false){
					HibernateUtil.commitTransaction();
					HibernateUtil.closeSession();
					return "";
			
				}
				if(rule.length()==0 || rule.contains("nochange")){
					
				}else if(rule.contains("changeyear")){
					DateFormat df=new SimpleDateFormat("yyyy");
					DateFormat dfy=new SimpleDateFormat("yy");
					int currentYear=Integer.parseInt(df.format(new Date()));
					int lastYear=Integer.parseInt(df.format(idData.get(0).getdate()));
					if(currentYear!=lastYear){
						id=1;
					}
					prefix=prefix.replace(dfy.format(idData.get(0).getdate()),dfy.format(new Date()));
					
				}else if(rule.contains("changefinyear")){
					DateFormat df=new SimpleDateFormat("MM");
					DateFormat dfy=new SimpleDateFormat("yy");
					int currentMonth=Integer.parseInt(df.format(new Date()));
					int lastMonth=Integer.parseInt(df.format(idData.get(0).getdate()));
					
					
					if( lastMonth<4 && currentMonth>=4 ){
						id=1;
						prefix=prefix.replace(dfy.format(idData.get(0).getdate()),dfy.format(new Date()));
					}
				}
			sql="update id_coretable set id="+id+",date='"+df1.format(new Date())+"' ,prefix='"+prefix+"' where table_name='"+table_name+"' and org_id="+org_id+"";
			 qry=session.createSQLQuery(sql);
			if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
			
			
			id = idData.get(0).getid();
			
			String idString = "";
			String suffix=idData.get(0).getSuffix();
			
			if(idData.get(0).getId_format()!=null && idData.get(0).getId_format().trim().isEmpty()==false){
				idString = String.format(idData.get(0).getId_format().trim(),(id));
			}else{
				idString = id+"";
			}
			if(prefix != null){
				idString = prefix+idString;
			}
			if(suffix!=null){
				idString = idString+suffix;
			}
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return idString;
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			Log.exception(e);
			return null;
		}
	}
	*/
/*Server*/
	
	public static String getAcknowledgmentID(String table_name, int org_id)
	{
		Session session = HibernateUtil.getSession();
		List<Core_table> idData;
		
		HibernateUtil.beginTransaction();
		String AckNumber="";
		try
		{
			
			String sql="update id_coretable set id=id+1 where table_name='"+table_name+"' and org_id="+org_id+"";
			SQLQuery qry=session.createSQLQuery(sql);
			if(qry.executeUpdate()==0){
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
				
			}
			String sql1 = "select id, prefix from id_coretable where table_name='"+table_name+"' and org_id="+org_id+"";
			idData=session.createSQLQuery(sql1).setResultTransformer(Transformers.aliasToBean(Core_table.class)).list();
			if (idData.size() == 0)
			{
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return null;
			}
			int id=0;
			id = idData.get(0).getid();
			StringBuffer s=new StringBuffer();
			
			
		
			s.append(idData.get(0).getPrefix());
			String s2=""+id;
			s.append(s2);
			AckNumber = s.toString();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			Log.exception(e);
			return null;
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		  
		return AckNumber;
		
	}
}
