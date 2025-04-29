package org.bte.framework.faces;

public class RFMenuItemDTO {

	private int menu_item_id;
	private int menu_item_for;
	private int menu_item_for_refid;
	private int menu_item_dep_version;
	private String menu_item_value;
	private int menu_item_page;
	private int menu_item_home_page;
	private int menu_item_component_id;
	private int menu_item_status;
	private String menu_item_action;
	private int menu_item_parent_id;
	private int menu_item_leaf;
	private int menu_item_order;
	private int menu_item_default;
	private String menu_item_ui_id;
	private String menu_item_style;
	private String menu_item_submit_mode;
	private String menu_item_bypassUpdates;
	private String menu_item_oncomplete;
	private String menu_item_reRender;
	private String menu_item_rendered;
	private String menu_item_page_name;
	private String menu_item_icon;
	private boolean menu_item_expanded;
	private int menu_item_column_max;
	private int menu_item_column;
	
	private boolean home_page_flag;
	public RFMenuItemDTO(){
		
	}
	public int getMenu_item_id() {
		return menu_item_id;
	}
	public void setMenu_item_id(int menuItemId) {
		menu_item_id = menuItemId;
	}
	
	public int getMenu_item_dep_version() {
		return menu_item_dep_version;
	}
	public void setMenu_item_dep_version(int menuItemDepVersion) {
		menu_item_dep_version = menuItemDepVersion;
	}
	public String getMenu_item_value() {
		return menu_item_value;
	}
	public void setMenu_item_value(String menuItemValue) {
		menu_item_value = menuItemValue;
	}
	public int getMenu_item_page() {
		return menu_item_page;
	}
	public void setMenu_item_page(int menuItemPage) {
		menu_item_page = menuItemPage;
	}
	public int getMenu_item_home_page() {
		return menu_item_home_page;
	}
	public void setMenu_item_home_page(int menuItemHomePage) {
		menu_item_home_page = menuItemHomePage;
	}
	
	public int getMenu_item_status() {
		return menu_item_status;
	}
	public void setMenu_item_status(int menuItemStatus) {
		menu_item_status = menuItemStatus;
	}
	public String getMenu_item_action() {
		return menu_item_action;
	}
	public void setMenu_item_action(String menuItemAction) {
		menu_item_action = menuItemAction;
	}
	public int getMenu_item_parent_id() {
		return menu_item_parent_id;
	}
	public void setMenu_item_parent_id(int menuItemParentId) {
		menu_item_parent_id = menuItemParentId;
	}
	public int getMenu_item_leaf() {
		return menu_item_leaf;
	}
	public void setMenu_item_leaf(int menuItemLeaf) {
		menu_item_leaf = menuItemLeaf;
	}
	public int getMenu_item_order() {
		return menu_item_order;
	}
	public void setMenu_item_order(int menuItemOrder) {
		menu_item_order = menuItemOrder;
	}
	public int getMenu_item_default() {
		return menu_item_default;
	}
	public void setMenu_item_default(int menuItemDefault) {
		menu_item_default = menuItemDefault;
	}
	public void setMenu_item_component_id(int menu_item_component_id) {
		this.menu_item_component_id = menu_item_component_id;
	}
	public int getMenu_item_component_id() {
		return menu_item_component_id;
	}
	public String getMenu_item_ui_id() {
		return menu_item_ui_id;
	}
	public void setMenu_item_ui_id(String menuItemUiId) {
		menu_item_ui_id = menuItemUiId;
	}
	public String getMenu_item_style() {
		return menu_item_style;
	}
	public void setMenu_item_style(String menuItemStyle) {
		menu_item_style = menuItemStyle;
	}
	public String getMenu_item_submit_mode() {
		return menu_item_submit_mode;
	}
	public void setMenu_item_submit_mode(String menuItemSubmitMode) {
		menu_item_submit_mode = menuItemSubmitMode;
	}
	public String getMenu_item_bypassUpdates() {
		return menu_item_bypassUpdates;
	}
	public void setMenu_item_bypassUpdates(String menuItemBypassUpdates) {
		menu_item_bypassUpdates = menuItemBypassUpdates;
	}
	public String getMenu_item_oncomplete() {
		return menu_item_oncomplete;
	}
	public void setMenu_item_oncomplete(String menuItemOncomplete) {
		menu_item_oncomplete = menuItemOncomplete;
	}
	public String getMenu_item_reRender() {
		return menu_item_reRender;
	}
	public void setMenu_item_reRender(String menuItemReRender) {
		menu_item_reRender = menuItemReRender;
	}
	public String getMenu_item_rendered() {
		return menu_item_rendered;
	}
	public void setMenu_item_rendered(String menuItemRendered) {
		menu_item_rendered = menuItemRendered;
	}
	public void setMenu_item_for(int menu_item_for) {
		this.menu_item_for = menu_item_for;
	}
	public int getMenu_item_for() {
		return menu_item_for;
	}
	public void setMenu_item_for_refid(int menu_item_for_refid) {
		this.menu_item_for_refid = menu_item_for_refid;
	}
	public int getMenu_item_for_refid() {
		return menu_item_for_refid;
	}
	public String getMenu_item_page_name() {
		return menu_item_page_name;
	}
	public void setMenu_item_page_name(String menu_item_page_name) {
		this.menu_item_page_name = menu_item_page_name;
	}
	public boolean isMenu_item_expanded() {
		return menu_item_expanded;
	}
	public void setMenu_item_expanded(boolean menu_item_expanded) {
		this.menu_item_expanded = menu_item_expanded;
	}
	public String getMenu_item_icon() {
		return menu_item_icon;
	}
	public void setMenu_item_icon(String menu_item_icon) {
		this.menu_item_icon = menu_item_icon;
	}
	public int getMenu_item_column_max() {
		return menu_item_column_max;
	}
	public void setMenu_item_column_max(int menu_item_column_max) {
		this.menu_item_column_max = menu_item_column_max;
	}
	public int getMenu_item_column() {
		return menu_item_column;
	}
	public void setMenu_item_column(int menu_item_column) {
		this.menu_item_column = menu_item_column;
	}
	public boolean isHome_page_flag() {
		return home_page_flag;
	}
	public void setHome_page_flag(boolean home_page_flag) {
		this.home_page_flag = home_page_flag;
	}
	
	
	
	
}
