package net.diegozhu.j2ee.ptms.model;
 
/**
 * BusStatus   */
public class BusStatus implements java.io.Serializable {
 
    private static final long serialVersionUID = -5112063423210473842L;
	private int id;
	private Bus bus;
	private String name;
	private String createtime;
	private String description;
	private Integer wheelpressure;
	private Integer temperature;
	private Integer gasleft;
	private Double locationx;
	private Double locationy;

	public BusStatus() {
	}

	public BusStatus(int id, Bus bus, String name) {
		this.id = id;
		this.bus = bus;
		this.name = name;
	}

	public BusStatus(int id, Bus bus, String name, String createtime,
			String description, Integer wheelpressure, Integer temperature,
			Integer gasleft, Double locationx, Double locationy) {
		this.id = id;
		this.bus = bus;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.wheelpressure = wheelpressure;
		this.temperature = temperature;
		this.gasleft = gasleft;
		this.locationx = locationx;
		this.locationy = locationy;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

}
