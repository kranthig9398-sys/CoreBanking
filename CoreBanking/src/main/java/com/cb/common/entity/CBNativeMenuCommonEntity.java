package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cb_state_menu_master")
public class CBNativeMenuCommonEntity {

    @Id
    @Column(name="MENU_ID")
    private Long menuId;

    @Column(name="MENU_NAME")
    private String menuName;

    @Column(name="ROUTE_PATH")
    private String route;

    @Column(name="SECTION_ID")
    private Integer sectionId;

    @Column(name="MODULE_ID")
    private Integer moduleId;

    @Column(name="LOGIN_LEVEL")
    private Integer loginLevel;

    @Column(name="ACTIVE")
    private String active;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getLoginLevel() {
		return loginLevel;
	}

	public void setLoginLevel(Integer loginLevel) {
		this.loginLevel = loginLevel;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}
