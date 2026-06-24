package com.cb.common.dto;

public class CBMenusDetailsDTO {
	private String menuName;
	private String route;
	private String accessLevel;
	
	public CBMenusDetailsDTO() {
		super();
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
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
}
