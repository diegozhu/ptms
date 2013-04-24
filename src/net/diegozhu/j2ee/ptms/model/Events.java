package net.diegozhu.j2ee.ptms.model;
 
/**
 * Events   */
public class Events implements java.io.Serializable {
 
    private static final long serialVersionUID = 8516431294122722395L;
	private int id;
	private Bus bus;
	private Station station;
	private User user;
	private Eventtype eventtype;
	private Line line;
	private String name;
	private String createtime;
	private String description;
	private int responserid;

	public Events() {
	}

	public Events(int id, User user, Eventtype eventtype, String name,
			int responserid) {
		this.id = id;
		this.user = user;
		this.eventtype = eventtype;
		this.name = name;
		this.responserid = responserid;
	}

	public Events(int id, Bus bus, Station station, User user,
			Eventtype eventtype, Line line, String name, String createtime,
			String description, int responserid) {
		this.id = id;
		this.bus = bus;
		this.station = station;
		this.user = user;
		this.eventtype = eventtype;
		this.line = line;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.responserid = responserid;
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

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Eventtype getEventtype() {
		return this.eventtype;
	}

	public void setEventtype(Eventtype eventtype) {
		this.eventtype = eventtype;
	}

	public Line getLine() {
		return this.line;
	}

	public void setLine(Line line) {
		this.line = line;
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

	public int getResponserid() {
		return this.responserid;
	}

	public void setResponserid(int responserid) {
		this.responserid = responserid;
	}

}
