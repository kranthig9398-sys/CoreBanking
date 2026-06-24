package com.cb.common.dto;

import java.util.List;

public class CBMenusFInalResponseDTO {

	private Integer stateCode;
	private Integer loginLevel;
	private boolean bodCompleted;
	private List<CBMenuSectionDTO> sections;
	
	public CBMenusFInalResponseDTO() {
		super();
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getLoginLevel() {
		return loginLevel;
	}

	public void setLoginLevel(Integer loginLevel) {
		this.loginLevel = loginLevel;
	}

	public boolean isBodCompleted() {
		return bodCompleted;
	}

	public void setBodCompleted(boolean bodCompleted) {
		this.bodCompleted = bodCompleted;
	}

	public List<CBMenuSectionDTO> getSections() {
		return sections;
	}

	public void setSections(List<CBMenuSectionDTO> sections) {
		this.sections = sections;
	}
}
