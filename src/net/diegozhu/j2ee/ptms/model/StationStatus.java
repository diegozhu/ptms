/*
 * ptms
 * Copyright (c) 2013 diegozhu All Rights Reserved.
 */
package net.diegozhu.j2ee.ptms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <br>
 * table:station_status<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Entity
@Table(name = "Station_Status", catalog = "ptms")
public class StationStatus implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "stationid")
	private Station station;

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "name")
	private String name;

	@Column(name = "createtime")
	private String createtime;

	@Column(name = "description")
	private String description;

	@Column(name = "trafficstatus")
	private Integer trafficstatus;

	@Column(name = "passagerstatus")
	private Integer passagerstatus;

	@Column(name = "status")
	private Integer status;

	@Column(name = "deleted")
	private Boolean deleted;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTrafficstatus() {
		return this.trafficstatus;
	}

	public void setTrafficstatus(Integer trafficstatus) {
		this.trafficstatus = trafficstatus;
	}

	public Integer getPassagerstatus() {
		return this.passagerstatus;
	}

	public void setPassagerstatus(Integer passagerstatus) {
		this.passagerstatus = passagerstatus;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String toString() {
		return "StationStatus:" + this.id + this.station + this.name + this.createtime + this.description + this.trafficstatus + this.passagerstatus + this.status + this.deleted;
	}

	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}

	public int hashCode() {
		return this.id;
	}
}
