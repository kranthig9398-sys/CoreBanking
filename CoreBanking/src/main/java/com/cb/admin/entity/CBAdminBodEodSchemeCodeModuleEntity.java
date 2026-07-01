package com.cb.admin.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CB_BOD_EOD_STATUS")
public class CBAdminBodEodSchemeCodeModuleEntity {
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "BOD_EOD_SEQ_GEN"
			)
	@SequenceGenerator(
			name = "BOD_EOD_SEQ_GEN",
			sequenceName = "CB_BOD_EOD_STATUS_SEQ",
			allocationSize = 1
			)
	@Column(name = "SID")
	private Long id;

	@Column(name = "SOL_ID")
	private Integer solId;
	
	@Column(name = "SCHEME_CODE")
	private Integer schemeCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "SOL_DATE")
	private Date solDate;

	@Column(name = "SOL_LEVEL")
	private Integer solLevel;

	@Column(name = "BOD_STATUS")
	private String bodStatus;

	@Column(name = "BOD_DONE_BY")
	private String bodDoneBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOD_DONE_DATE")
	private Date bodDoneDate;

	@Column(name = "EOD_STATUS")
	private String eodStatus;

	@Column(name = "EOD_DONE_BY")
	private String eodDoneBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EOD_DONE_DATE")
	private Date eodDoneDate;

	public CBAdminBodEodSchemeCodeModuleEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSolId() {
		return solId;
	}

	public void setSolId(Integer solId) {
		this.solId = solId;
	}

	public Date getSolDate() {
		return solDate;
	}

	public void setSolDate(Date solDate) {
		this.solDate = solDate;
	}

	public Integer getSolLevel() {
		return solLevel;
	}

	public void setSolLevel(Integer solLevel) {
		this.solLevel = solLevel;
	}

	public String getBodStatus() {
		return bodStatus;
	}

	public void setBodStatus(String bodStatus) {
		this.bodStatus = bodStatus;
	}

	public String getBodDoneBy() {
		return bodDoneBy;
	}

	public void setBodDoneBy(String bodDoneBy) {
		this.bodDoneBy = bodDoneBy;
	}

	public Date getBodDoneDate() {
		return bodDoneDate;
	}

	public void setBodDoneDate(Date bodDoneDate) {
		this.bodDoneDate = bodDoneDate;
	}

	public String getEodStatus() {
		return eodStatus;
	}

	public void setEodStatus(String eodStatus) {
		this.eodStatus = eodStatus;
	}

	public String getEodDoneBy() {
		return eodDoneBy;
	}

	public void setEodDoneBy(String eodDoneBy) {
		this.eodDoneBy = eodDoneBy;
	}

	public Date getEodDoneDate() {
		return eodDoneDate;
	}

	public void setEodDoneDate(Date eodDoneDate) {
		this.eodDoneDate = eodDoneDate;
	}

	public Integer getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(Integer schemeCode) {
		this.schemeCode = schemeCode;
	}
}