package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="CB_MENU_SECTION_MASTER")
	public class CBMenuSectionMasterEntity {

	    @Id
	    @Column(name="SECTION_ID")
	    private Integer sectionId;

	    @Column(name="SECTION_NAME")
	    private String sectionName;

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
	}