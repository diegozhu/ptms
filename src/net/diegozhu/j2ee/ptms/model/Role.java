package net.diegozhu.j2ee.ptms.model;
 
import java.util.HashSet;
import java.util.Set;

public class Role implements java.io.Serializable {
 
    private static final long serialVersionUID = -8661452491926673184L;
	private int id;
	private String name;
	private String createtime;
	private String description;
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role(int id, String name, String createtime, String description,
			Set<User> users) {
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.users = users;
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

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
