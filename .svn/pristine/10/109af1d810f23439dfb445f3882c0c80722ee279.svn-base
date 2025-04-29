package org.bte.framework.faces;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.component.UIParameter;
import javax.faces.el.MethodBinding;



import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.UIMenuItem;
import org.primefaces.component.submenu.UISubmenu;
import org.primefaces.model.menu.DefaultMenuColumn;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.bte.core.person.staff.StaffService;
import org.bte.framework.error.Log;
public class FacesServicePrimeFaces extends FacesService {
	private int COMPONENT_ID_PRIME_FACES_MENUBAR=6;
	private int COMPONENT_ID_PRIME_FACES_SUBMENU=7;
	private int COMPONENT_ID_PRIME_FACES_MENUITEM=8;
	private int COMPONENT_ID_PRIME_FACES_MENU_COLUMN=9;
	public List<RFMenuItemDTO> getRFMenuItem(int userrole){
		return facesManager.getRFMenuItem(userrole);
	}
	public MenuModel getPrimeFacesMegaMenuModel(int MenuRefFor,int menuRefId) {
		 
		MenuModel foldermodel = new DefaultMenuModel();
		
		try {
			
			 
			
			 
			
			RFMenuItemDTO rfMenuItemDTO=new RFMenuItemDTO();
			rfMenuItemDTO.setMenu_item_status(1);
			rfMenuItemDTO.setMenu_item_for(MenuRefFor);
			rfMenuItemDTO.setMenu_item_for_refid(menuRefId);
			List<RFMenuItemDTO> rfMenuItemDTOList=facesManager.getRFMenuItem(rfMenuItemDTO);
			
			if(rfMenuItemDTOList!=null){
				for(int i=0;i<rfMenuItemDTOList.size();i++){
					
						if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_SUBMENU){
							DefaultSubMenu Submenu =new DefaultSubMenu();
							Submenu.setIcon(rfMenuItemDTOList.get(i).getMenu_item_icon());
							Submenu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
							Submenu.setStyleClass(rfMenuItemDTOList.get(i).getMenu_item_style());
							foldermodel.getElements().add(Submenu);
							Map<Integer,DefaultMenuColumn> map = new HashMap<Integer,DefaultMenuColumn>();
							for(int k=0;k<rfMenuItemDTOList.get(i).getMenu_item_column_max();k++){
								DefaultMenuColumn column = new DefaultMenuColumn();
								
								DefaultSubMenu firstSubmenu = new DefaultSubMenu();
								firstSubmenu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
								column.getElements().add(firstSubmenu);
								firstSubmenu.setStyleClass("maintemplatemenusubmenucolumn");
								firstSubmenu.setExpanded(rfMenuItemDTOList.get(i).isMenu_item_expanded());
								map.put(k+1, column);
							}
							  
							// firstSubmenu.setRendered(rfMenuItemDTOList.get(i).getMenu_item_rendered().equals("true"));
							
							for(int j=0;j<rfMenuItemDTOList.size();j++){
								
									
									if(rfMenuItemDTOList.get(i).getMenu_item_id()==rfMenuItemDTOList.get(j).getMenu_item_parent_id() && rfMenuItemDTOList.get(j).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
										DefaultSubMenu s =(DefaultSubMenu) map.get(rfMenuItemDTOList.get(j).getMenu_item_column()).getElements().get(0);
										s.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(j)));
										
									}
								
							}
							for(Map.Entry<Integer,DefaultMenuColumn> s:map.entrySet()) {
								DefaultSubMenu sa=(DefaultSubMenu)s.getValue().getElements().get(0);
								if(sa.getElementsCount()>0) {
									Submenu.getElements().add(s.getValue());
								}
							}
							
							
						}else if(rfMenuItemDTOList.get(i).getMenu_item_parent_id()==0 && rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
							 foldermodel.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(i)));
						}
					
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			Log.exception(e);
		}
		return foldermodel;
	}
	 public MenuModel getPrimeFacesMegaMenuModel(int MenuRefFor,int menuRefId, int userid,int company_id,int org_id) {
		 
		MenuModel foldermodel = new DefaultMenuModel();
		
		try {
			
			 
			
			 
			StaffService staff_service = new StaffService();
			List permission = staff_service.getMenuItemPermission(userid,company_id,org_id);
			
			RFMenuItemDTO rfMenuItemDTO=new RFMenuItemDTO();
			rfMenuItemDTO.setMenu_item_status(1);
			rfMenuItemDTO.setMenu_item_for(MenuRefFor);
			rfMenuItemDTO.setMenu_item_for_refid(menuRefId);
			List<RFMenuItemDTO> rfMenuItemDTOList=facesManager.getRFMenuItem(rfMenuItemDTO);
			
			if(rfMenuItemDTOList!=null){
				for(int i=0;i<rfMenuItemDTOList.size();i++){
					if(permission.contains(rfMenuItemDTOList.get(i).getMenu_item_id()) ){
						if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_SUBMENU){
							DefaultSubMenu Submenu =new DefaultSubMenu();
							Submenu.setIcon(rfMenuItemDTOList.get(i).getMenu_item_icon());
							Submenu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
							Submenu.setStyleClass(rfMenuItemDTOList.get(i).getMenu_item_style());
							foldermodel.getElements().add(Submenu);
							Map<Integer,DefaultMenuColumn> map = new HashMap<Integer,DefaultMenuColumn>();
							for(int k=0;k<rfMenuItemDTOList.get(i).getMenu_item_column_max();k++){
								DefaultMenuColumn column = new DefaultMenuColumn();
								
								DefaultSubMenu firstSubmenu = new DefaultSubMenu();
								firstSubmenu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
								column.getElements().add(firstSubmenu);
								firstSubmenu.setStyleClass("maintemplatemenusubmenucolumn");
								firstSubmenu.setExpanded(rfMenuItemDTOList.get(i).isMenu_item_expanded());
								map.put(k+1, column);
							}
							  
							// firstSubmenu.setRendered(rfMenuItemDTOList.get(i).getMenu_item_rendered().equals("true"));
							
							for(int j=0;j<rfMenuItemDTOList.size();j++){
								if(permission.contains(rfMenuItemDTOList.get(j).getMenu_item_id()) ){
									
									if(rfMenuItemDTOList.get(i).getMenu_item_id()==rfMenuItemDTOList.get(j).getMenu_item_parent_id() && rfMenuItemDTOList.get(j).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
										DefaultSubMenu s =(DefaultSubMenu) map.get(rfMenuItemDTOList.get(j).getMenu_item_column()).getElements().get(0);
										s.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(j)));
										
									}
								}
							}
							for(Map.Entry<Integer,DefaultMenuColumn> s:map.entrySet()) {
								DefaultSubMenu sa=(DefaultSubMenu)s.getValue().getElements().get(0);
								if(sa.getElementsCount()>0) {
									Submenu.getElements().add(s.getValue());
								}
							}
							
							
						}else if(rfMenuItemDTOList.get(i).getMenu_item_parent_id()==0 && rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
							 foldermodel.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(i)));
						}
					}
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			Log.exception(e);
		}
		return foldermodel;
	}
	 public MenuModel getPrimeFacesMenuModel(int MenuRefFor,int menuRefId, int userid,int company_id,int org_id) {
		 
			MenuModel foldermodel = new DefaultMenuModel();
			 try {
				 DefaultSubMenu firstSubmenu =null;
				 
				 
				 
				StaffService staff_service = new StaffService();
				List permission = staff_service.getMenuItemPermission(userid,company_id,org_id);
				
				RFMenuItemDTO rfMenuItemDTO=new RFMenuItemDTO();
				rfMenuItemDTO.setMenu_item_status(1);
				rfMenuItemDTO.setMenu_item_for(MenuRefFor);
				rfMenuItemDTO.setMenu_item_for_refid(menuRefId);
				List<RFMenuItemDTO> rfMenuItemDTOList=facesManager.getRFMenuItem(rfMenuItemDTO);
				
				
				if(rfMenuItemDTOList!=null){
					for(int i=0;i<rfMenuItemDTOList.size();i++){
							
						if(permission.contains(rfMenuItemDTOList.get(i).getMenu_item_id()) ){
							if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_SUBMENU){
								 firstSubmenu = new DefaultSubMenu();
								 firstSubmenu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
								 firstSubmenu.setIcon(rfMenuItemDTOList.get(i).getMenu_item_icon());
								 firstSubmenu.setId(rfMenuItemDTOList.get(i).getMenu_item_ui_id());
								// firstSubmenu.setRendered(rfMenuItemDTOList.get(i).getMenu_item_rendered().equals("true"));
								 firstSubmenu.setExpanded(rfMenuItemDTOList.get(i).isMenu_item_expanded());
								
									for(int j=0;j<rfMenuItemDTOList.size();j++){
										if(permission.contains(rfMenuItemDTOList.get(j).getMenu_item_id()) ){
											if(rfMenuItemDTOList.get(i).getMenu_item_id()==rfMenuItemDTOList.get(j).getMenu_item_parent_id() && rfMenuItemDTOList.get(j).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
												
												firstSubmenu.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(j)));
											}
										}
									}
									 foldermodel.getElements().add(firstSubmenu);
								
							}else if(rfMenuItemDTOList.get(i).getMenu_item_parent_id()==0 && rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
								 foldermodel.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(i)));
							}
						}
						
					}
				}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					Log.exception(e);
				}
			return foldermodel;
		}
	
	public MenuModel getPrimeFacesMenuModel(int MenuRefFor,int menuRefId, String permissionValue) {
		 
		MenuModel foldermodel = new DefaultMenuModel();
		 try {
		
			 List<Integer> perlist=new ArrayList<Integer>();
			 for(String token:permissionValue.split(",")){
				 perlist.add(Integer.parseInt(token));
			 }
			RFMenuItemDTO rfMenuItemDTO=new RFMenuItemDTO();
			rfMenuItemDTO.setMenu_item_status(1);
			rfMenuItemDTO.setMenu_item_for(MenuRefFor);
			rfMenuItemDTO.setMenu_item_for_refid(menuRefId);
			List<RFMenuItemDTO> rfMenuItemDTOList=facesManager.getRFMenuItem(rfMenuItemDTO);
			DefaultSubMenu firstSubmenu =null;
			
			if(rfMenuItemDTOList!=null){
				for(int i=0;i<rfMenuItemDTOList.size();i++){
					if(perlist.contains(rfMenuItemDTOList.get(i).getMenu_item_id())){
						
					
						if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_SUBMENU){
							 firstSubmenu = new DefaultSubMenu();
							 firstSubmenu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
							 firstSubmenu.setId(rfMenuItemDTOList.get(i).getMenu_item_ui_id());
							// firstSubmenu.setRendered(rfMenuItemDTOList.get(i).getMenu_item_rendered().equals("true"));
							
							
								for(int j=0;j<rfMenuItemDTOList.size();j++){
									if(perlist.contains(rfMenuItemDTOList.get(j).getMenu_item_id()) && rfMenuItemDTOList.get(i).getMenu_item_id()==rfMenuItemDTOList.get(j).getMenu_item_parent_id() && rfMenuItemDTOList.get(j).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
										
										firstSubmenu.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(j)));
									}
								}
								 foldermodel.getElements().add(firstSubmenu);
							
						}else if(rfMenuItemDTOList.get(i).getMenu_item_parent_id()==0 && rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
							 foldermodel.getElements().add(getPrimeFacesMenuItemModel(rfMenuItemDTOList.get(i)));
						}
					}
				}
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				Log.exception(e);
			}
		return foldermodel;
	}
	private DefaultMenuItem getPrimeFacesMenuItemModel(  RFMenuItemDTO obj){
		 DefaultMenuItem menuItem = new DefaultMenuItem();
		
		menuItem.setId(obj.getMenu_item_ui_id());
		menuItem.setStyleClass(obj.getMenu_item_style()); 
		menuItem.setValue(obj.getMenu_item_value());
		menuItem.setIcon(obj.getMenu_item_icon());
		//menuItem.setSubmitMode(obj.getMenu_item_submit_mode());
		//menuItem.setRendered(obj.getMenu_item_rendered().equals("true"));
		//menuItem.setReRender(obj.getMenu_item_reRender());
		//menuItem.setBypassUpdates(obj.getMenu_item_bypassUpdates().equals("true"));
		menuItem.setOncomplete(obj.getMenu_item_oncomplete());
		//menuItem.setAjaxSingle(true);
		if(obj.getMenu_item_action()!=null && obj.getMenu_item_action().trim().length()>0){
			menuItem.setCommand(obj.getMenu_item_action());
			
		}
		//menuItem.setIcon(obj.getMenu_item_icon());
		//menuItem.setParam("menu_item_id", obj.getMenu_item_id());
		//menuItem.setParam("pageId", obj.getMenu_item_page());
		if(obj.getMenu_item_page_name()!=null) {
		menuItem.setParam("page_name", obj.getMenu_item_page_name());
		}
		
		return menuItem;
	
	}
	public Menubar getPrimeFacesMenu( Application app,int MenuRefFor,int menuRefId, String permissionValue) {
		Menubar myBarGrp =new Menubar();
		 try {
		
			List<Integer> perlist=new ArrayList<Integer>();
			for(String token:permissionValue.split(",")){
				perlist.add(Integer.parseInt(token));
			}
			RFMenuItemDTO rfMenuItemDTO=new RFMenuItemDTO();
			rfMenuItemDTO.setMenu_item_status(1);
			rfMenuItemDTO.setMenu_item_for(MenuRefFor);
			rfMenuItemDTO.setMenu_item_for_refid(menuRefId);
			List<RFMenuItemDTO> rfMenuItemDTOList=facesManager.getRFMenuItem(rfMenuItemDTO);
			UISubmenu menu=null;
			
			if(rfMenuItemDTOList!=null){
				for(int i=0;i<rfMenuItemDTOList.size();i++){
					if(perlist.contains(rfMenuItemDTOList.get(i).getMenu_item_id())){
						
						if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_SUBMENU){
							menu = new UISubmenu();
							menu.setId(rfMenuItemDTOList.get(i).getMenu_item_ui_id());
							menu.setTransient(true);
							//menu.setStyle(rfMenuItemDTOList.get(i).getMenu_item_style()); 
							menu.setLabel(rfMenuItemDTOList.get(i).getMenu_item_value());
							//menu.setSubmitMode(rfMenuItemDTOList.get(i).getMenu_item_submit_mode());
							menu.setRendered(rfMenuItemDTOList.get(i).getMenu_item_rendered().equals("true"));
							
							for(int j=0;j<rfMenuItemDTOList.size();j++){
								if(perlist.contains(rfMenuItemDTOList.get(j).getMenu_item_id()) && rfMenuItemDTOList.get(i).getMenu_item_id()==rfMenuItemDTOList.get(j).getMenu_item_parent_id() && rfMenuItemDTOList.get(j).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
									menu.getChildren().add(getPrimeFacesMenuItem(app,rfMenuItemDTOList.get(j)));
								}
							}
							
							myBarGrp.getChildren().add(menu);
						}else if(rfMenuItemDTOList.get(i).getMenu_item_parent_id()==0 && rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM){
							myBarGrp.getChildren().add(getPrimeFacesMenuItem(app,rfMenuItemDTOList.get(i)));
						}
					}
				}
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				Log.exception(e);
			}
		return myBarGrp;
	}
	private UIMenuItem getPrimeFacesMenuItem( Application app, RFMenuItemDTO obj){

		UIMenuItem menuItem = new 	UIMenuItem();
		menuItem.setId(obj.getMenu_item_ui_id());
		//menuItem.setStyle(obj.getMenu_item_style()); 
		menuItem.setValue(obj.getMenu_item_value());
		//menuItem.setSubmitMode(obj.getMenu_item_submit_mode());
		menuItem.setRendered(obj.getMenu_item_rendered().equals("true"));
		//menuItem.setReRender(obj.getMenu_item_reRender());
		//menuItem.setBypassUpdates(obj.getMenu_item_bypassUpdates().equals("true"));
		menuItem.setOncomplete(obj.getMenu_item_oncomplete());
		//menuItem.setAjaxSingle(true);
		if(obj.getMenu_item_action()!=null && obj.getMenu_item_action().trim().length()>0){
			MethodBinding mb = app.createMethodBinding(obj.getMenu_item_action(), new Class[0]);
	        menuItem.setAction (mb);
		}
		UIParameter param = new UIParameter();
	    param.setName("menu_item_id");
	    param.setValue(obj.getMenu_item_id());
	    UIParameter param1 = new UIParameter();
	    param1.setName("pageId");
	    param1.setValue(obj.getMenu_item_page());
	   
	    menuItem.getChildren().add(param);
	    menuItem.getChildren().add(param1);
		return menuItem;
	
	}
	/*public org.primefaces.component.layout.Layout getPageLayout( FacesContext fc,RFPageDTO pageDTO,List<RFPageLayoutDTO> layoutlist) {
		
		org.primefaces.component.layout.Layout layout=new org.primefaces.component.layout.Layout();
		//layout.setCloseTitle(null);
		//layout.setCollapseTitle(_collapseTitle);
		//layout.setExpandTitle(_expandTitle);
		layout.setFullPage(pageDTO.isErp_pagefullPage());
		layout.setId(pageDTO.getErp_pageui_id());
		if(pageDTO.getErp_pageonClose()!=null && !pageDTO.getErp_pageonClose().isEmpty())
			layout.setOnClose(pageDTO.getErp_pageonClose());
		if(pageDTO.getErp_pageonResize()!=null && !pageDTO.getErp_pageonResize().isEmpty())
			layout.setOnResize(pageDTO.getErp_pageonResize());
		if(pageDTO.getErp_pageonToggle()!=null && !pageDTO.getErp_pageonToggle().isEmpty())
			layout.setOnToggle(pageDTO.getErp_pageonToggle());
		if(pageDTO.getErp_pagestyle()!=null && !pageDTO.getErp_pagestyle().isEmpty())
			layout.setStyle(pageDTO.getErp_pagestyle());
		if(pageDTO.getErp_pagestyleClass()!=null && !pageDTO.getErp_pagestyleClass().isEmpty())
			layout.setStyleClass(pageDTO.getErp_pagestyleClass());
		if(pageDTO.getErp_pagewidgetVar()!=null && !pageDTO.getErp_pagewidgetVar().isEmpty())
			layout.setWidgetVar(pageDTO.getErp_pagewidgetVar());
		if(layoutlist!=null)
		for(int  i=0;layoutlist.size()>i;i++){
			
			org.primefaces.component.layout.LayoutUnit layoutobj=getLayoutUnit(fc,layoutlist.get(i),null);
			layout.getChildren().add(layoutobj);
			
			
		}
		return layout;
	}
	public org.primefaces.component.layout.LayoutUnit getLayoutUnit(FacesContext fc,RFPageLayoutDTO obj ,org.primefaces.component.layout.LayoutUnit layoutobj){
		if(layoutobj==null)
			layoutobj=new org.primefaces.component.layout.LayoutUnit();
		layoutobj.setId(obj.getLu_ui_id());
		if(obj.getLu_header()!=null && !obj.getLu_header().isEmpty())
			layoutobj.setHeader(obj.getLu_header());
		if(obj.getLu_styleClass()!=null && !obj.getLu_styleClass().isEmpty())
			layoutobj.setStyleClass(obj.getLu_styleClass());
		if(obj.getLu_resizable()!=null && !obj.getLu_resizable().isEmpty())
			layoutobj.setResizable(Boolean.parseBoolean(obj.getLu_resizable()));
		if(obj.getLu_closable()!=null && !obj.getLu_closable().isEmpty())
			layoutobj.setClosable(Boolean.parseBoolean(obj.getLu_closable()));
		if(obj.getLu_header()!=null && !obj.getLu_header().isEmpty())
			layoutobj.setCollapsible(Boolean.parseBoolean(obj.getLu_header()));
		
		try{
			HttpServletRequest req = (HttpServletRequest) fc.getCurrentInstance().getExternalContext().getRequest();
			String url = "http://host.com?param="+req.getRequestURL().toString();
			HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
			
			URL objURL=new URL(obj.getLu_pagename());
			FaceletContext faceletContext = (FaceletContext) fc.getCurrentInstance().getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);
	        faceletContext.includeFacelet(layoutobj,"http://host.com?param="+objURL);
			
			}
			catch(IOException e){
				Log.exception(e);
			}
		
		layoutobj.setCollapsed(_collapsed);
		layoutobj.setCollapseSize(_collapseSize);
		layoutobj.setEffect(_effect);
		layoutobj.setEffectSpeed(_effectSpeed);
		layoutobj.setFooter(_footer);
		layoutobj.setGutter(_gutter);
		
		layoutobj.setInView(isInView);
		layoutobj.setMaxSize(_maxSize);
		layoutobj.setMinSize(_minSize);
		layoutobj.setPosition(_position);
		layoutobj.setRendered(rendered);
		layoutobj.setRendererType(rendererType);
		layoutobj.setResizable(_resizable);
		layoutobj.setSize(_size);
		
		layoutobj.setTransient(transientFlag);
		layoutobj.setValueBinding(arg0, arg1);
		layoutobj.setValueExpression(arg0, arg1);
		layoutobj.setVisible(_visible);
		return layoutobj;
	}
	public TreeNode getMenu(Application app,Map<String,Object> obj){
		int menu_item_for=Integer.parseInt(obj.get("menu_item_for").toString());
		List<Integer> avamenuitem=new ArrayList<Integer>();
		if(obj.get("site_menuitem")!=null){
			String menuitemvalue=obj.get("site_menuitem").toString();
			
			if(!menuitemvalue.trim().isEmpty()){
				String[] site_menuitem=menuitemvalue.split(",");
				for (String token : site_menuitem)   
				{
					avamenuitem.add(Integer.parseInt(token));
				}
			}
		}
		
		RFMenuItemDTO rfMenuItemDTO=new RFMenuItemDTO();
		rfMenuItemDTO.setMenu_item_status(Constants.STATUS_ACTIVE);
		rfMenuItemDTO.setMenu_item_for(menu_item_for);
		rfMenuItemDTO.setMenu_item_for_refid(0);
		List<RFMenuItemDTO> rfMenuItemDTOList=facesManager.getRFMenuItem(rfMenuItemDTO);
		TreeNode root = new DefaultTreeNode(new DocumentCategoryDTO(),null);
		
		if(rfMenuItemDTOList!=null){
			for(int i=0;i<rfMenuItemDTOList.size();i++){
				if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_SUBMENU){
					if(avamenuitem.contains(rfMenuItemDTOList.get(i).getMenu_item_id())){
						rfMenuItemDTOList.get(i).setSiteSelected(true);
					}
					TreeNode treenode = new DefaultTreeNode(rfMenuItemDTOList.get(i),root);
					getNodeTree(rfMenuItemDTOList,treenode,rfMenuItemDTOList.get(i).getMenu_item_id(),avamenuitem);
					
				}else if(rfMenuItemDTOList.get(i).getMenu_item_component_id()==COMPONENT_ID_PRIME_FACES_MENUITEM && rfMenuItemDTOList.get(i).getMenu_item_parent_id()==0){
					
					getNodeTree(rfMenuItemDTOList,root,0,avamenuitem);
					
				}
			}
			
			
		}
		
			
		return root;
	}
	private void getNodeTree(List<RFMenuItemDTO> catlist,TreeNode treenode,int parentId,List<Integer> avamenuitem){
		for(int i=0;i<catlist.size();i++){
			if(catlist.get(i).getMenu_item_parent_id()==parentId){
				if(avamenuitem.contains(catlist.get(i).getMenu_item_id())){
					catlist.get(i).setSiteSelected(true);
				}
				TreeNode subtreenode = new DefaultTreeNode(catlist.get(i), treenode);
				if(catlist.get(i).getDoc_cat_childcount()>0)
					getNodeTree(catlist,subtreenode,catlist.get(i).getDoc_cat_id());
			}
		}
		
		
	}
	public String getTreeSelectedValue(TreeNode root){
		String value=null;
		if(root!=null){
			for(int i=0;i<root.getChildCount();i++){
				RFMenuItemDTO obj=(RFMenuItemDTO)root.getChildren().get(i).getData();
				if(obj.isSiteSelected()){
					value=value==null?obj.getMenu_item_id()+"":(value+","+obj.getMenu_item_id());
					String child=getTreeSelectedValue(root.getChildren().get(i));
					value=child==null?value:(value+","+child);
					
				}
				
			}
		}
		return value;
		
	}*/
	
	
}
