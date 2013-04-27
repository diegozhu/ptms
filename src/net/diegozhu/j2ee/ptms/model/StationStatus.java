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
 * @author diego zhu
 * @version 1.0
 */

@Entity
@Table(name = "StationStatus", catalog = "ptms")
public class StationStatus implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "stationid")
	private Station station;

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
	private int status;

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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String toString() {
		return "StationStatus:" + this.id + this.station + this.name + this.createtime + this.description + this.trafficstatus + this.passagerstatus + this.status;
	}

	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}

	public int hashCode() {
		return this.id;
	}
}
