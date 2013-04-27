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
 * table:bus_status<br>
 * @author diego zhu
 * @version 1.0
 */

@Entity
@Table(name = "BusStatus", catalog = "ptms")
public class BusStatus implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "busid")
	private Bus bus;

	@Column(name = "name")
	private String name;

	@Column(name = "createtime")
	private String createtime;

	@Column(name = "description")
	private String description;

	@Column(name = "wheelpressure")
	private Integer wheelpressure;

	@Column(name = "temperature")
	private Integer temperature;

	@Column(name = "gasleft")
	private Integer gasleft;

	@Column(name = "locationx")
	private Double locationx;

	@Column(name = "locationy")
	private Double locationy;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bus getBus() {
		return this.bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
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

	public Integer getWheelpressure() {
		return this.wheelpressure;
	}

	public void setWheelpressure(Integer wheelpressure) {
		this.wheelpressure = wheelpressure;
	}

	public Integer getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Integer getGasleft() {
		return this.gasleft;
	}

	public void setGasleft(Integer gasleft) {
		this.gasleft = gasleft;
	}

	public Double getLocationx() {
		return this.locationx;
	}

	public void setLocationx(Double locationx) {
		this.locationx = locationx;
	}

	public Double getLocationy() {
		return this.locationy;
	}

	public void setLocationy(Double locationy) {
		this.locationy = locationy;
	}

	public String toString() {
		return "BusStatus:" + this.id + this.bus + this.name + this.createtime + this.description + this.wheelpressure + this.temperature + this.gasleft + this.locationx
		        + this.locationy;
	}

	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}

	public int hashCode() {
		return this.id;
	}
}
