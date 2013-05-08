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
 * table:bus<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Entity
@Table(name = "Bus", catalog = "ptms")
public class Bus implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@Column(name = "name")
	private String name;

	@Column(name = "createtime")
	private String createtime;

	@Column(name = "description")
	private String description;

	@Column(name = "maxpassager")
	private Integer maxpassager;

	@ManyToOne
	@JoinColumn(name = "lineId")
	private Line line;

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "type")
	private String type;

	@Column(name = "purchasetime")
	private String purchasetime;

	@Column(name = "lefttime")
	private String lefttime;

	@Column(name = "deleted")
	private Boolean deleted;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Integer getMaxpassager() {
		return this.maxpassager;
	}

	public void setMaxpassager(Integer maxpassager) {
		this.maxpassager = maxpassager;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPurchasetime() {
		return this.purchasetime;
	}

	public void setPurchasetime(String purchasetime) {
		this.purchasetime = purchasetime;
	}

	public String getLefttime() {
		return this.lefttime;
	}

	public void setLefttime(String lefttime) {
		this.lefttime = lefttime;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String toString() {
		return "Bus:" + this.id + this.user + this.name + this.createtime + this.description + this.maxpassager + this.type + this.purchasetime + this.lefttime + this.deleted;
	}

	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}

	public int hashCode() {
		return this.id;
	}
}
