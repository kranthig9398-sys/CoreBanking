package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CB_LEVEL_MASTER")
public class CBMenuLevelEntity {
	@Id
	@Column(name="LEVEL_ID")
	private int levelId;
	@Column(name="LEVEL_NAME")
	private String levelName;
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}
