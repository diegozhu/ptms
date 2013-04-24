package net.diegozhu.j2ee.ptms.model;
 
/**
 * LineStatus   */
public class LineStatus implements java.io.Serializable {
 
    private static final long serialVersionUID = -5166407868072173794L;
	private int id;
	private Line line;
	private String name;
	private String createtime;
	private String description;
	private Integer status;

	public LineStatus() {
	}

	public LineStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public LineStatus(int id, Line line, String name, String createtime,
			String description, Integer status) {
		this.id = id;
		this.line = line;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
