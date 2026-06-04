package com.cb.common.dto;

public class CBMenuCommonDTO {

    private String menuName;
    private String route;
    private boolean isCanActive;
    
	public CBMenuCommonDTO(String menuName, String route, boolean isCanActive) {
		super();
		this.menuName = menuName;
		this.route = route;
		this.isCanActive = isCanActive;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public boolean isCanActive() {
		return isCanActive;
	}
	public void setCanActive(boolean isCanActive) {
		this.isCanActive = isCanActive;
	}
	@Override
	public String toString() {
		return "CBMenuCommonDTO [menuName=" + menuName + ", route=" + route + ", isCanActive=" + isCanActive + "]";
	}

}
