package net.diegozhu.j2ee.ptms.model;
 
public class StationStatus implements java.io.Serializable {
 
    private static final long serialVersionUID = 647441663802610446L;
	private int id;
	private Line line;
	private String name;
	private String createtime;
	private String description;
	private Integer trafficstatus;
	private Integer passagerstatus;
	private int status;

	public StationStatus() {
	}

	public StationStatus(int id, Line line, String name, int status) {
		this.id = id;
		this.line = line;
		this.name = name;
		this.status = status;
	}

	public StationStatus(int id, Line line, String name, String createtime,
			String description, Integer trafficstatus, Integer passagerstatus,
			int status) {
		this.id = id;
		this.line = line;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.trafficstatus = trafficstatus;
		this.passagerstatus = passagerstatus;
		this.status = status;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}
