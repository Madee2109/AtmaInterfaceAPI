package org.bte.bean.ws;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.bte.bean.JSFFacesUtil;
import org.bte.framework.ws.BTEWSService;
import org.bte.framework.ws.WSParamDTO;
import org.bte.framework.ws.WSServiceDTO;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.shaded.json.JSONObject;

@ManagedBean ( name = "APIDetail" )
@ViewScoped
public class APIDetail {

	private WSServiceDTO serobj ;
	private List<WSServiceDTO> service_list = new ArrayList<WSServiceDTO>();
	private boolean showparam;
	 private TreeNode paramtree;
	public APIDetail() {
		
		onload();
	}
	
	public void onload(){
		paramtree = new DefaultTreeNode();
		serobj = BTEWSService.getServiceList(JSFFacesUtil.getParam("service_id")).get(0);
		setService_list(BTEWSService.getServiceListExample(serobj.getWs_service_id()));
		List<WSParamDTO> paramlist = BTEWSService.getServiceParamList(serobj.getWs_service_id());
		if(paramlist!=null && paramlist.size()>0) {
			showparam = true;
			loadtree(0, paramlist, paramtree);
		}
	}
	private void loadtree(int parent,List<WSParamDTO> paramlist,TreeNode root) {
		for(WSParamDTO ob:paramlist) {
			if(parent == ob.getWs_param_parent()) {
				TreeNode subtree = new DefaultTreeNode(ob,root);
				if(ob.getWs_param_type()==1 || ob.getWs_param_type()==2) {
					subtree.setExpanded(true);
					loadtree(ob.getWs_param_id(), paramlist, subtree);
				}
			}
		}
	}
	public WSServiceDTO getSerobj() {
		return serobj;
	}
	public void setSerobj(WSServiceDTO serobj) {
		this.serobj = serobj;
	}

	public List<WSServiceDTO> getService_list() {
		return service_list;
	}

	public void setService_list(List<WSServiceDTO> service_list) {
		this.service_list = service_list;
	}

	public boolean isShowparam() {
		return showparam;
	}

	public void setShowparam(boolean showparam) {
		this.showparam = showparam;
	}

	public TreeNode getParamtree() {
		return paramtree;
	}

	public void setParamtree(TreeNode paramtree) {
		this.paramtree = paramtree;
	}


	
}
