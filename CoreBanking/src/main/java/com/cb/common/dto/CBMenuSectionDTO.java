package com.cb.common.dto;

import java.util.List;

public class CBMenuSectionDTO {
	private Integer sectionId;
	private String sectionName;
	private List<CBMenusDetailsDTO> menus;
	
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public List<CBMenusDetailsDTO> getMenus() {
		return menus;
	}
	public void setMenus(List<CBMenusDetailsDTO> menus) {
		this.menus = menus;
	}
}
