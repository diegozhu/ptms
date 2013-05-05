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

import java.util.Set;

/**
 * <br>
 * table:user<br>
 * @author diego zhu
 * @version 1.0
 */

@Entity
@Table(name = "User", catalog = "ptms")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;

	@Column(name = "name")
	private String name;

	@Column(name = "createtime")
	private String createtime;

	@Column(name = "description")
	private String description;

	@Column(name = "workid")
	private String workid;

	@Column(name = "personalid")
	private String personalid;

	@Column(name = "address")
	private String address;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "gender")
	private String gender;

	@Column(name = "jointime")
	private String jointime;

	@Column(name = "resigntime")
	private String resigntime;

	@Column(name = "password")
	private String password;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getWorkid() {
		return this.workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	public String getPersonalid() {
		return this.personalid;
	}

	public void setPersonalid(String personalid) {
		this.personalid = personalid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJointime() {
		return this.jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public String getResigntime() {
		return this.resigntime;
	}

	public void setResigntime(String resigntime) {
		this.resigntime = resigntime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User:" + this.id + this.role + this.name + this.createtime + this.description + this.workid + this.personalid + this.address + this.cellphone + this.gender
		        + this.jointime + this.resigntime + this.password;
	}

	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}

	public int hashCode() {
		return this.id;
	}
}
