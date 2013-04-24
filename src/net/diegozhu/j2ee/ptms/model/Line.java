package net.diegozhu.j2ee.ptms.model;
 
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Line   */
public class Line implements java.io.Serializable {
 
    private static final long serialVersionUID = 2035985403594421208L;
	private int id;
	private String name;
	private String createtime;
	private String description;
	private Date timespace;
	private Date starttime;
	private Date endtime;
	private Set<LineStation> lineStations = new HashSet<LineStation>(0);
	private Set<LineStatus> lineStatuses = new HashSet<LineStatus>(0);
	private Set<BusLine> busLines = new HashSet<BusLine>(0);
	private Set<Events> eventses = new HashSet<Events>(0);
	private Set<StationStatus> stationStatuses = new HashSet<StationStatus>(0);

	public Line() {
	}

	public Line(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Line(int id, String name, String createtime, String description,
			Date timespace, Date starttime, Date endtime,
			Set<LineStation> lineStations, Set<LineStatus> lineStatuses,
			Set<BusLine> busLines, Set<Events> eventses,
			Set<StationStatus> stationStatuses) {
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.timespace = timespace;
		this.starttime = starttime;
		this.endtime = endtime;
		this.lineStations = lineStations;
		this.lineStatuses = lineStatuses;
		this.busLines = busLines;
		this.eventses = eventses;
		this.stationStatuses = stationStatuses;
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

	public Date getTimespace() {
		return this.timespace;
	}

	public void setTimespace(Date timespace) {
		this.timespace = timespace;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Set<LineStation> getLineStations() {
		return this.lineStations;
	}

	public void setLineStations(Set<LineStation> lineStations) {
		this.lineStations = lineStations;
	}

	public Set<LineStatus> getLineStatuses() {
		return this.lineStatuses;
	}

	public void setLineStatuses(Set<LineStatus> lineStatuses) {
		this.lineStatuses = lineStatuses;
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

	public Set<StationStatus> getStationStatuses() {
		return this.stationStatuses;
	}

	public void setStationStatuses(Set<StationStatus> stationStatuses) {
		this.stationStatuses = stationStatuses;
	}

}
