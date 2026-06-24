package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CB_MODULE_GROUP_MASTER")
public class CBModuleGroupEntity {

    @Id
    @Column(name="GROUP_ID")
    private Integer groupId;

    @Column(name="GROUP_NAME")
    private String groupName;

    @Column(name="IS_ACTIVE")
    private String active;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}