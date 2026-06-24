package com.cb.common.dto;

public class CBModuleMenuCommonDTO {

	private String menuName;
	private String route;
	private boolean isCanActive;
	private Integer id;
	
	public CBModuleMenuCommonDTO() {
		super();
	}
	public CBModuleMenuCommonDTO(String menuName, String route, boolean isCanActive, Integer id) {
		super();
		this.menuName = menuName;
		this.route = route;
		this.isCanActive = isCanActive;
		this.id = id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CBMenuCommonDTO [menuName=" + menuName + ", route=" + route + ", isCanActive=" + isCanActive + ", id="
				+ id + "]";
	}
}