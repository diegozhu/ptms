package net.diegozhu.j2ee.ptms.model;
 
import java.util.HashSet;
import java.util.Set;

/**
 * Eventtype   */
public class Eventtype implements java.io.Serializable {
 
    private static final long serialVersionUID = 8662645173144452953L;
	private int id;
	private String name;
	private String createtime;
	private String description;
	private Set<Events> eventses = new HashSet<Events>(0);

	public Eventtype() {
	}

	public Eventtype(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Eventtype(int id, String name, String createtime,
			String description, Set<Events> eventses) {
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.eventses = eventses;
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

	public Set<Events> getEventses() {
		return this.eventses;
	}

	public void setEventses(Set<Events> eventses) {
		this.eventses = eventses;
	}

}
