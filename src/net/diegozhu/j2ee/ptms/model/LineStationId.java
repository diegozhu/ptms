package net.diegozhu.j2ee.ptms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LineStationId implements java.io.Serializable {

    private static final long serialVersionUID = -6289446112456622641L;
    
    @Id
	private String name;
	private String createtime;
	private String description;
	private int lineid;
	private int stationid;

	public LineStationId() {
	}

	public LineStationId(String name, int lineid, int stationid) {
		this.name = name;
		this.lineid = lineid;
		this.stationid = stationid;
	}

	public LineStationId(String name, String createtime, String description,
			int lineid, int stationid) {
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.lineid = lineid;
		this.stationid = stationid;
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

	public int getLineid() {
		return this.lineid;
	}

	public void setLineid(int lineid) {
		this.lineid = lineid;
	}

	public int getStationid() {
		return this.stationid;
	}

	public void setStationid(int stationid) {
		this.stationid = stationid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LineStationId))
			return false;
		LineStationId castOther = (LineStationId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getCreatetime() == castOther.getCreatetime()) || (this
						.getCreatetime() != null
						&& castOther.getCreatetime() != null && this
						.getCreatetime().equals(castOther.getCreatetime())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& (this.getLineid() == castOther.getLineid())
				&& (this.getStationid() == castOther.getStationid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getCreatetime() == null ? 0 : this.getCreatetime()
						.hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		result = 37 * result + this.getLineid();
		result = 37 * result + this.getStationid();
		return result;
	}

}
