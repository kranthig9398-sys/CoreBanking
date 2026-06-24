package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="CB_STATE_MENU_MASTER")
public class CBMenuSectionEntity {

	@Id
	@Column(name="MENU_ID")
	private Long menuId;

	@Column(name="MENU_NAME")
	private String menuName;

	@Column(name="ROUTE_PATH")
	private String route;

	@Column(name="SECTION_ID")
	private Integer sectionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECTION_ID",referencedColumnName = "SECTION_ID",insertable = false,updatable = false)
	private CBMenuSectionMasterEntity sectionDeatails;

	@Column(name="MODULE_ID")
	private Integer stateCode;

	@Column(name="LOGIN_LEVEL")
	private int loginLevel;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LOGIN_LEVEL" ,referencedColumnName = "LEVEL_ID",insertable = false,updatable = false)
	private CBMenuLevelEntity cbLevelMenuDetails;

	@Column(name="IS_ACTIVE")
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

	public CBMenuSectionMasterEntity getSectionDeatails() {
		return sectionDeatails;
	}

	public void setSectionDeatails(CBMenuSectionMasterEntity sectionDeatails) {
		this.sectionDeatails = sectionDeatails;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public int getLoginLevel() {
		return loginLevel;
	}

	public void setLoginLevel(int loginLevel) {
		this.loginLevel = loginLevel;
	}

	public CBMenuLevelEntity getCbLevelMenuDetails() {
		return cbLevelMenuDetails;
	}

	public void setCbLevelMenuDetails(CBMenuLevelEntity cbLevelMenuDetails) {
		this.cbLevelMenuDetails = cbLevelMenuDetails;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}