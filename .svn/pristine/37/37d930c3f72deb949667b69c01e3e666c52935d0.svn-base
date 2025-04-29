package org.bte.framework.audit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.bte.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;



public class AuditDAOImpl  implements AuditDAO 
{
	public ArrayList get_audit(Integer encid,Integer patid)
	{
		ArrayList audit= new ArrayList();
		try
		{
			Session session = HibernateUtil.getSession();	  				
			String sql ="select audit_activity as auditActivity FROM tb_audit where audit_id=?";
			List ss=session.createSQLQuery(sql).setParameter(0, encid).setResultTransformer(Transformers.aliasToBean(AuditDTO.class)).list();

			Iterator it = ss.iterator();
			if(!it.hasNext())
			{
				
			}
			else
			{  	    	  	      	  
				while(it.hasNext())
				{
					Object row = it.next();
					AuditDTO auditdto = (AuditDTO) (row);           
					audit.add(auditdto.getAuditActivity());
				}      
			}   

			HibernateUtil.closeSession();
		}

		catch(Exception e)
		{
			HibernateUtil.closeSession();
			HibernateUtil.logException(e);
			
		}
		return audit;
	}
	public boolean saveAuditNewSession(List<AuditDTO> list,String serverName)
	{	
		return false;
		/*Boolean status=true;
		Session session = getNewSession(serverName);	
		try
		{				
			beginTransaction();
			Iterator<AuditDTO> it=list.iterator();
			while(it.hasNext()){
				AuditDTO audit=(AuditDTO) it.next();
				tb_audit auditobj=new tb_audit();
				auditobj.setAuditActivity(audit.getAuditActivity());
				auditobj.setAuditId(audit.getAuditId());
				auditobj.setAuditUserid(audit.getAuditUserid());
				auditobj.setAuditOperation(audit.getAuditOperation());   
				auditobj.setAuditId(audit.getAuditId());
				auditobj.setAudit_encid(audit.getAuditencid());
				auditobj.setAudit_personid(audit.getAuditpersonid());
				auditobj.setOrg_id(audit.getOrg_id());
				auditobj.setAudit_ipaddress(audit.getAudit_ipaddress());
				auditobj.setAudit_machinename(audit.getAudit_machinename());
				auditobj.setAudit_information(audit.getAudit_information());
				auditobj.setAudit_loginsession(audit.getAudit_loginsession());
				session.saveOrUpdate(auditobj); 
				session.flush();
				session.evict(auditobj); 
			}
			commitTransaction();	   
			closeNewSession(session);

		}

		catch(Exception e)
		{
			rollbackTransaction();
			closeNewSession(session);
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("ExceptionObject",e);
			status=false;
		}
		return status;*/
	}
	public Boolean save_audit(List<AuditDTO> list)
	{
		return true;
		/*
		 * Boolean status=true; Session session = HibernateUtil.getSession(); try {
		 * HibernateUtil.beginTransaction(); for(AuditDTO audit :list){
		 * 
		 * 
		 * 
		 * tb_audit auditobj=new tb_audit();
		 * auditobj.setAuditActivity(audit.getAuditActivity());
		 * auditobj.setAuditId(audit.getAuditId());
		 * auditobj.setAuditUserid(audit.getAuditUserid());
		 * auditobj.setAuditOperation(audit.getAuditOperation());
		 * auditobj.setAuditId(audit.getAuditId());
		 * auditobj.setAudit_encid(audit.getAuditencid());
		 * auditobj.setAudit_personid(audit.getAuditpersonid());
		 * auditobj.setOrg_id(audit.getOrg_id());
		 * auditobj.setAudit_ipaddress(audit.getAudit_ipaddress());
		 * auditobj.setAudit_machinename(audit.getAudit_machinename());
		 * auditobj.setLogin_audit_id(audit.getLogin_audit_id());
		 * auditobj.setAudit_information(audit.getAudit_information());
		 * session.save(auditobj); session.flush(); session.evict(auditobj);
		 * 
		 * } HibernateUtil.commitTransaction(); HibernateUtil.closeSession();
		 * 
		 * }
		 * 
		 * catch(Exception e) { HibernateUtil.rollbackTransaction();
		 * HibernateUtil.closeSession(); HibernateUtil.logException(e);
		 * 
		 * status=false; } return status;
		 */}

	public List<AuditDTO> operationlist(){
		List<AuditDTO> auditdto_list = new ArrayList<AuditDTO>();
		Session session = HibernateUtil.getSession();
		String sql;
		try{
			sql="select c.cl_label as activity, c.cl_id as activityid from tb_code_list c where c.cl_group='AUDIT_ACTIVITY' order by c.cl_label ";
			auditdto_list=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(AuditDTO.class)).list();
			HibernateUtil.closeSession();
		}
		catch(Exception e){
			HibernateUtil.closeSession();
			HibernateUtil.logException(e);

		}
		return auditdto_list;
	}

	public List<AuditDTO> viewloglist(Date fromdate, Date todate, int person_id, int activity, int operation, int sort){
		List<AuditDTO> viewauditdto_list = new ArrayList<AuditDTO>();
		Session session = HibernateUtil.getSession();
		String sql;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s1,s2;
		try{
			sql="SELECT a.audit_id as auditId, a.audit_userid as auditUserid, a.audit_date as auditDate,  a.audit_activity as auditActivity, a.audit_operation as auditOperation, a.audit_encid as auditencid, a.audit_personid as auditpersonid, concat(b.person_fname,' ',coalesce(b.person_lname,''))as user_name, concat(c.person_fname,' ',coalesce(c.person_lname,'')) as person_name FROM tb_audit a, tb_person_mtr b, tb_person_mtr c  where  b.person_id = a.audit_userid and c.person_id = a.audit_personid";

			if(fromdate!=null){
				s1=dateFormat.format(fromdate);

				sql= sql + " and a.audit_date >= '"+s1+"' ";
			}
			if(todate!=null){
				s2=dateFormat.format(todate);
				sql= sql + " and a.audit_date <= '"+s2+"' + INTERVAL 1 DAY ";
			}
			if(person_id>0){
				sql=sql + " and a.audit_personid= '"+person_id+"' ";
			}
			if(activity>0){
				sql=sql+ " and a.audit_activity='"+activity+"'";
			}
			if(operation>0){
				sql=sql+ " and a.audit_operation='"+operation+"' ";
			}
			if(sort>0){
				if(sort==1)
					sql= sql+" order by a.audit_personid  desc";
				else if(sort==2)
					sql= sql+" order by a.audit_encid desc ";
				else
					sql= sql+" order by a.audit_date desc ";
			}
			viewauditdto_list=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(AuditDTO.class)).list();
			HibernateUtil.closeSession();
		}
		catch(Exception e){
			HibernateUtil.closeSession();
			HibernateUtil.logException(e);

		}
		return viewauditdto_list;
	}

	public List<AuditDTO> viewAuditLogList(Map<String, Object> obj){
		List<AuditDTO> auditList=new ArrayList<AuditDTO>();
		Session session = HibernateUtil.getSession();
		try{
			
			String sql="";
			sql=sql+"SELECT  a.`audit_id`as auditId,IFNULL(c.cl_label,'') as activity, a.`audit_date` as auditDate,b.person_fname, IFNULL(p.cl_label,'') as operationname, IFNULL(a.`audit_information`,'')as audit_information "
					+ " FROM tb_audit a,tb_code_list c,tb_code_list p,tb_person_mtr b "
					+ "WHERE c.cl_group='AUDIT_ACTIVITY' and p.cl_group='OPERATION' AND a.audit_activity=c.cl_id  AND a.audit_operation=p.cl_id and a.audit_userid = b.person_id  ";
			if(obj!=null){
				if(obj.get("from_date")!=null){
					Date fromdate=(Date)obj.get("from_date");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String FROM_DATE=formatter.format(fromdate);
					sql=sql +" AND DATE(a.`audit_date`) >= '"+FROM_DATE+"' ";
				}
				if(obj.get("to_date")!=null){
					Date fromdate=(Date)obj.get("to_date");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String TO_DATE=formatter.format(fromdate);
					sql=sql +" AND DATE(a.`audit_date`) <= '"+TO_DATE+"' ";
				}
				if(obj.get("auditActivity")!=null){
					sql=sql +"  AND c.cl_id="+obj.get("auditActivity").toString()+" ";
				}
				if(obj.get("auditOperation")!=null){
					sql=sql +"  AND p.cl_id="+obj.get("auditOperation").toString()+" ";
				}
				if(obj.get("user_id")!=null){
					sql=sql +" AND a.audit_userid="+obj.get("user_id").toString()+" ";
				}
				if(obj.get("limit")!=null){
					sql=sql +" order by a.audit_sno desc   Limit 0,"+obj.get("limit").toString()+" ";
				}
			}
			
			auditList=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(AuditDTO.class)).list();
			HibernateUtil.closeSession();
		}
		catch(Exception e){
			
			HibernateUtil.closeSession();
			HibernateUtil.logException(e);

		}
		return auditList;
		
	}
}
