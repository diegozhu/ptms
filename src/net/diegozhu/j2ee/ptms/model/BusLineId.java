package net.diegozhu.j2ee.ptms.model;
 
/**
 * BusLineId   */
public class BusLineId implements java.io.Serializable {
 
    private static final long serialVersionUID = -6466481116996421927L;
	private String name;
	private String createtime;
	private String description;
	private int busid;
	private int lineid;

	public BusLineId() {
	}

	public BusLineId(String name, int busid, int lineid) {
		this.name = name;
		this.busid = busid;
		this.lineid = lineid;
	}

	public BusLineId(String name, String createtime, String description,
			int busid, int lineid) {
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.busid = busid;
		this.lineid = lineid;
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

	public int getBusid() {
		return this.busid;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	public int getLineid() {
		return this.lineid;
	}

	public void setLineid(int lineid) {
		this.lineid = lineid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BusLineId))
			return false;
		BusLineId castOther = (BusLineId) other;

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
				&& (this.getBusid() == castOther.getBusid())
				&& (this.getLineid() == castOther.getLineid());
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
		result = 37 * result + this.getBusid();
		result = 37 * result + this.getLineid();
		return result;
	}

}
