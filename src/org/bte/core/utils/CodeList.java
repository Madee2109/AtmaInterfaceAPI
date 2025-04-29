package org.bte.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;





import org.bte.framework.error.Log;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class CodeList 
{
	static public Integer AUDIT_OP_REGISTRATION = 2;

	static List<CodeListDTO> codeArray = null;


	static String sqlStmt = "select cl_group, cl_id, cl_label, cl_default, cl_alternate_id_1,cl_flag,cl_order from tb_code_list where cl_flag=1 and cl_group = ? ";
	static String orderBy = " order by cl_order ";

	public static HashMap<String, Object> getCodeListHM (String codeGroup)
	{
		List<String> lArray = null;
		Integer iCnt = 0;
		CodeListDTO cDTO=null;
		Integer iDefault=0;
		HashMap<String,Object> hmList = null;

		List<CodeListDTO> cDTOArray = getCodeList(codeGroup,"",0);

		if (cDTOArray.size() == 0)
			return null;

		lArray = new ArrayList<String>();
		Iterator<CodeListDTO> itList = cDTOArray.iterator();
		for(iCnt=0; itList.hasNext();iCnt++)
		{
			cDTO = itList.next();
			lArray.add(cDTO.cl_id.toString());
			lArray.add(cDTO.cl_label);
			if (cDTO.cl_default == null)
				cDTO.cl_default = "";
			if (cDTO.cl_default.equals("1"))
				iDefault = cDTO.cl_id;
		}

		hmList = new HashMap<String,Object>();
		hmList.put("LIST", lArray);
		hmList.put("DEFAULT",iDefault);

		return hmList;
	}

	public static  List<CodeListDTO> getCodeList (String codeGroup, String codeLabel, Integer codeId)
	{
		//		
		String sqlStmt1 = null;
		List<CodeListDTO> labelList = null;


		if (!codeLabel.isEmpty())
			sqlStmt1 = "select cl_group, cl_id, cl_label, cl_default, cl_alternate_id_1,cl_flag,cl_order "
					+ " from tb_code_list "
					+ " where cl_flag=1 "
						+ " and cl_group = '"+codeGroup+"' " 
						+ " and cl_label = '"+codeLabel+"' " + orderBy;
		else if (codeId > 0)
			sqlStmt1 = "select cl_group, cl_id, cl_label, cl_default, cl_alternate_id_1,cl_flag,cl_order "
					+ " from tb_code_list "
					+ " where cl_flag=1 "
						+ " and cl_group = '"+codeGroup+"' " 
						+ " and cl_id = '"+codeId+"' " + orderBy;
		else
			sqlStmt1 = "select cl_group, cl_id, cl_label, cl_default, cl_alternate_id_1,cl_flag,cl_order "
					+ " from tb_code_list "
					+ " where cl_flag=1 "
						+ " and cl_group = '"+codeGroup+"' " ;
	//	Session session = HibernateUtil.getNewSession();
		Session session = HibernateUtil.getSession();
		Query qList =	session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class));
		//qList.setString(0, codeGroup);

		/*if (!codeLabel.isEmpty())
			qList.setString(1, codeLabel);
		else if (codeId > 0)
			qList.setInteger(1, codeId);
*/
		labelList = qList.list();

		//HibernateUtil.closeNewSession(session);
		HibernateUtil.closeSession();
		
		
		return labelList;
	}

	public static List<CodeListDTO> getCodeGroupList(CodeListDTO clval)
	{
		String sqlStmt1 = "select cl_group, cl_id, cl_label, IFNULL(cl_default,'') as cl_default, cl_alternate_id_1,cl_flag,cl_order ," +
				"(select MAX(cl_id) from tb_code_list  where cl_group = '"+clval.getCl_group()+"'  ) as maxcl_id," +
				"(select MAX(cl_order) from tb_code_list where cl_group = '"+clval.getCl_group()+"' ) as maxcl_order " +
				"from tb_code_list where cl_flag=1" ;
		
		if(clval.getCl_id()!=null && clval.getCl_id()!=0 )
			sqlStmt1=sqlStmt1+" AND cl_id='"+clval.getCl_id()+"'";
		
		if(clval.getCl_group()!=null && clval.getCl_group()!="" )
			sqlStmt1=sqlStmt1+" AND cl_group='"+clval.getCl_group()+"'";
		
		if(clval.getCl_label()!=null && clval.getCl_label()!="" )
			sqlStmt1=sqlStmt1+" AND cl_label='"+clval.getCl_label()+"'";
		
		if(clval.getCl_order()!=null && clval.getCl_order()!=0)
			sqlStmt1=1+" AND cl_order='"+clval.getCl_order()+"'";
		
		if(clval.getCl_default()!=null && clval.getCl_default().length()>0)
			sqlStmt1=sqlStmt1+" AND cl_default='"+clval.getCl_default()+"'";
		
		if(clval.getCl_group()==null || clval.getCl_group()=="" )
			sqlStmt1=sqlStmt1+"   group by cl_group";
				
		List<CodeListDTO> labelList = null;
		Session session = HibernateUtil.getSession();
		Query qList =	session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class));
		labelList = qList.list();
      	HibernateUtil.closeSession();
		return labelList;
	}
	public static Integer getCodeFromLabel (String codeGroup, String codeLabel)
	{
		List<CodeListDTO> CodeList = getCodeList(codeGroup, codeLabel, 0);
		
		return (CodeList==null || CodeList.isEmpty() ? 0 : CodeList.get(0).cl_id);
	}

	public static String getLabelFromCode (String codeGroup, Integer codeId)
	{
		List<CodeListDTO> CodeList = getCodeList(codeGroup, "", codeId);
	
		return (CodeList==null || CodeList.isEmpty() ? "" : CodeList.get(0).cl_label);
			
	}
	
	public static String getAlternateIdFromCode (String codeGroup, Integer codeId)
	{
		List<CodeListDTO> CodeList = getCodeList(codeGroup, "", codeId);
	
		return (CodeList==null || CodeList.isEmpty() ? "" : CodeList.get(0).cl_alternate_id_1);
			
	}
	public static String getLabelFromAlternateId (String codeGroup, String cl_alternate_id)
	{

		//		
		String sqlStmt1 = null;
		List<CodeListDTO> labelList = null;


		
			sqlStmt1 = "select cl_group, cl_id, cl_label, cl_default, cl_alternate_id_1,cl_flag,cl_order "
					+ " from tb_code_list "
					+ " where cl_flag=1 "
						+ " and cl_group = '"+codeGroup+"' " 
						+ " and cl_alternate_id_1 = '"+cl_alternate_id+"' " ;
		
	//	Session session = HibernateUtil.getNewSession();
		Session session = HibernateUtil.getSession();
		Query qList =	session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class));
		//qList.setString(0, codeGroup);

		/*if (!codeLabel.isEmpty())
			qList.setString(1, codeLabel);
		else if (codeId > 0)
			qList.setInteger(1, codeId);
*/
		labelList = qList.list();

		//HibernateUtil.closeNewSession(session);
		HibernateUtil.closeSession();
		
		
		return labelList.get(0).getCl_label();
	
		
		
	}
	public static String getAlternateIdFromLabel (String codeGroup, String codeLabel)
	{
		List<CodeListDTO> CodeList = getCodeList(codeGroup, codeLabel, 0);
		
		return (CodeList==null || CodeList.isEmpty() ? "" : CodeList.get(0).cl_alternate_id_1);
	}
    public static List<CodeListDTO> SuggesionGroupLists(String suggest)
    {
    	List<CodeListDTO> groupFetch = new ArrayList<CodeListDTO>();
    	Session session = HibernateUtil.getSession();
    	try
		{   
	    	String sqlStmt1 = "select cl_group, cl_id, cl_label,cl_default,cl_alternate_id_1,cl_flag,cl_order " +
	    			          "from tb_code_list where cl_flag=1 and cl_group like  '"+suggest+"%' group by cl_group";
	    	groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
		    HibernateUtil.closeSession();
		    return groupFetch;
		}
		catch(Exception e)
		{
			Log.exception(e);
			HibernateUtil.closeSession();
			return null;
		}
    }

public static boolean insertCodeList(List<CodeListDTO> cdto)
{
	Session session = HibernateUtil.getSession();
	HibernateUtil.beginTransaction();
	Iterator it =cdto.iterator();
	
	try
	{	
	    while(it.hasNext())
		{
			CodeListDTO editdto = (CodeListDTO)it.next();
			
			if(editdto.getInsertstatus().intValue()==0)
			{
			String select="update tb_code_list set cl_id='"+editdto.getCl_id()+"',cl_order='"+editdto.getCl_order()+"'," +
			"cl_default='"+editdto.getCl_default()+"',cl_alternate_id_1='"+editdto.getCl_alternate_id_1()+"',cl_flag='"+editdto.cl_flag+"'" +
					"where cl_group='"+editdto.getCl_group()+"' and cl_label='"+editdto.getCl_label()+"' ";
			SQLQuery qry = session.createSQLQuery(select);
			if(qry.executeUpdate() == 0)
			{
				HibernateUtil.rollbackTransaction();
				HibernateUtil.closeSession();
				return false;
			}
			}
			else
			{
			String select="insert into tb_code_list (cl_group,cl_id,cl_label,cl_order,cl_default," +
					      "cl_alternate_id_1,cl_flag) values (?,?,?,?,?,?,?)";
		    Query sqlStmt =session.createSQLQuery(select) .setParameter(0,editdto.getCl_group())
		                                                  .setParameter(1,editdto.getCl_id())
		    											  .setParameter(2,editdto.getCl_label())
		    											  .setParameter(3,editdto.getCl_order())
		    											  .setParameter(4,editdto.getCl_default())
		    											  .setParameter(5,editdto.getCl_alternate_id_1())
		    											  .setParameter(6,editdto.getCl_flag());
			  if(sqlStmt.executeUpdate()==0)
			  {
				 HibernateUtil.rollbackTransaction();
				 HibernateUtil.closeSession();
			 	return false;
			  }
			 }
		}
	    
	    
			
		    	 HibernateUtil.commitTransaction();
				 HibernateUtil.closeSession();
				 return true;
	}
	catch(Exception e)
	{
				Log.exception(e);
				 HibernateUtil.rollbackTransaction();
				 HibernateUtil.closeSession();
				 return false;
	}		
}
public static boolean updateClDefault( String cl_group, int cl_id, String cl_default) 
{
	Session session = HibernateUtil.getSession();
	HibernateUtil.beginTransaction();
	String sql = new String();
	try 
	{
			sql = " update  tb_code_list " +
				  " set 	cl_default='"+cl_default+"'"+
				  " where   cl_group='"+cl_group+"' " +
							 "and cl_id='"+cl_id+"' ";
		    SQLQuery query = session.createSQLQuery(sql);
		    

		if (query.executeUpdate() == 0) 
		{
			HibernateUtil.rollbackTransaction();
			HibernateUtil.closeSession();
			return false;
		}
		
		
		
			

			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
	} 
	catch (Exception e) 
	{
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
		return false;
	}
}
public static List<SelectItem> getCodeListSelectItemlabel(String clGroup)
{
	List<SelectItem> result = new ArrayList<SelectItem>();
	Session session = HibernateUtil.getSession();
	try
	{   
    	String sqlStmt1 = "select  cl_label,cl_alternate_id_1 " +
    			          "from tb_code_list where cl_flag=1 and cl_group like  '"+clGroup+"' ORDER BY cl_order";
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(new SelectItem(groupFetch.get(i).getCl_label(),groupFetch.get(i).getCl_alternate_id_1()));
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}
public static List<SelectItem> getCodeListSelectItem(String clGroup)
{
	List<SelectItem> result = new ArrayList<SelectItem>();
	Session session = HibernateUtil.getSession();
	try
	{   
    	String sqlStmt1 = "select  cl_id,cl_label,cl_alternate_id_1 " +
    			          "from tb_code_list where cl_flag=1 and cl_group like  '"+clGroup+"' ORDER BY cl_order";
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(new SelectItem(groupFetch.get(i).getCl_id(),groupFetch.get(i).getCl_alternate_id_1()==null?groupFetch.get(i).getCl_label() :groupFetch.get(i).getCl_alternate_id_1()));
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}public static List<SelectItem> getCodeListSelectItemcl_label(String clGroup)
{
	List<SelectItem> result = new ArrayList<SelectItem>();
	Session session = HibernateUtil.getSession();
	try
	{   
    	String sqlStmt1 = "select  cl_id,cl_label,cl_alternate_id_1 " +
    			          "from tb_code_list where cl_flag=1 and cl_group like  '"+clGroup+"' ORDER BY cl_order";
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(new SelectItem(groupFetch.get(i).getCl_id(),groupFetch.get(i).getCl_label()));
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}
public static List<SelectItem> getCodeListSelectItem(String clGroup,String inist)
{
	List<SelectItem> result = new ArrayList<SelectItem>();
	if(inist==null || inist.trim().length()==0){
		return result;
	}
	Session session = HibernateUtil.getSession();
	try
	{   
    	String sqlStmt1 = "select  cl_id,cl_label,cl_alternate_id_1 " +
    			          "from tb_code_list where cl_flag=1 and cl_group like  '"+clGroup+"' AND cl_id in ("+inist+") ORDER BY cl_order";
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(new SelectItem(groupFetch.get(i).getCl_id(),groupFetch.get(i).getCl_alternate_id_1()==null?groupFetch.get(i).getCl_label() :groupFetch.get(i).getCl_alternate_id_1()));
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}
public static List<SelectItem> getCodeListSelectItemPaymentMode(String key)
{
	List<SelectItem> result = new ArrayList<SelectItem>();
	Session session = HibernateUtil.getSession();
	try
	{   
    	String sqlStmt1 = " select  cl_id,cl_alternate_id_1 " +
    			          " from tb_code_list , tb_code_list_payment_mode  where cl_id = payment_mode and cl_group like  'PAYMENTMODE'";
    		if(key.equals("payment_mode_billing_payment")){	         
    			sqlStmt1 = sqlStmt1 + " AND payment_mode_billing_payment = 1";
    		}
    		sqlStmt1 = sqlStmt1+ " ORDER BY cl_order";
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(new SelectItem(groupFetch.get(i).getCl_id(),groupFetch.get(i).getCl_alternate_id_1()));
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}

public static List<SelectItem> getCodeListSelectItemVoucherStatus(String key)
{
	List<SelectItem> result = new ArrayList<SelectItem>();
	Session session = HibernateUtil.getSession();
	try
	{   
		String sqlStmt1 = " select  c.cl_id,display_name AS cl_alternate_id_1 " +
		          " from tb_code_list c, tb_code_list_vchr_status c1  where c.cl_id = c1.cl_id AND cl_group = 'jrnl_vchr_status'";
	if(key.equals("daybook_selected_default")){	         
		sqlStmt1 = sqlStmt1 + " AND daybook_selected_default = 1";
	}else if(key.equals("unpost")){	         
		sqlStmt1 = sqlStmt1 + " AND unpost_status = 1";
	}
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(new SelectItem(groupFetch.get(i).getCl_id(),groupFetch.get(i).getCl_alternate_id_1()));
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}

public static List<Integer> getCodeListListVoucherStatus(String key)
{
	List<Integer> result = new ArrayList<Integer>();
	Session session = HibernateUtil.getSession();
	try
	{   
    	String sqlStmt1 = " select  c.cl_id,display_name AS cl_alternate_id_1 " +
    			          " from tb_code_list c, tb_code_list_vchr_status c1  where c.cl_id = c1.cl_id AND cl_group = 'jrnl_vchr_status'";
    		if(key.equals("daybook_selected_default")){	         
    			sqlStmt1 = sqlStmt1 + " AND daybook_selected_default = 1";
    		}
    		
    	List<CodeListDTO> groupFetch = session.createSQLQuery(sqlStmt1).setResultTransformer(Transformers.aliasToBean(CodeListDTO.class)).list();
    	if(groupFetch!=null)
    	for(int i=0;groupFetch.size()>i;i++){
    		result.add(groupFetch.get(i).getCl_id());
    	}
	    HibernateUtil.closeSession();
	    return result;
	}
	catch(Exception e)
	{
		Log.exception(e);
		HibernateUtil.closeSession();
		return null;
	}
}
}
