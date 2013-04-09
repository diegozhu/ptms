package net.diegozhu.j2ee.ptms.model;

// Generated Apr 9, 2013 10:21:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bus generated by hbm2java
 */
public class Bus implements java.io.Serializable {

	private int id;
	private String name;
	private String createtime;
	private String description;
	private Integer driver;
	private Integer maxpassager;
	private String type;
	private Date purchasetime;
	private Date lefttime;
	private Set<BusLine> busLines = new HashSet<BusLine>(0);
	private Set<Events> eventses = new HashSet<Events>(0);
	private Set<BusStatus> busStatuses = new HashSet<BusStatus>(0);

	public Bus() {
	}

	public Bus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Bus(int id, String name, String createtime, String description,
			Integer driver, Integer maxpassager, String type,
			Date purchasetime, Date lefttime, Set<BusLine> busLines,
			Set<Events> eventses, Set<BusStatus> busStatuses) {
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.driver = driver;
		this.maxpassager = maxpassager;
		this.type = type;
		this.purchasetime = purchasetime;
		this.lefttime = lefttime;
		this.busLines = busLines;
		this.eventses = eventses;
		this.busStatuses = busStatuses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getDriver() {
		return this.driver;
	}

	public void setDriver(Integer driver) {
		this.driver = driver;
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

	public Date getPurchasetime() {
		return this.purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}

	public Date getLefttime() {
		return this.lefttime;
	}

	public void setLefttime(Date lefttime) {
		this.lefttime = lefttime;
	}

	public Set<BusLine> getBusLines() {
		return this.busLines;
	}

	public void setBusLines(Set<BusLine> busLines) {
		this.busLines = busLines;
	}

	public Set<Events> getEventses() {
		return this.eventses;
	}

	public void setEventses(Set<Events> eventses) {
		this.eventses = eventses;
	}

	public Set<BusStatus> getBusStatuses() {
		return this.busStatuses;
	}

	public void setBusStatuses(Set<BusStatus> busStatuses) {
		this.busStatuses = busStatuses;
	}

}
