package net.diegozhu.j2ee.ptms.model;


import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = -3536129715928094603L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "roleid")  
	private Role role;
    @Column(name = "name")  
	private String name;
    @Column(name = "createtime") 
	private String createtime;
    @Column(name = "description") 
	private String description;
    @Column(name = "workid") 
    private String workid;
    @Column(name = "personalid") 
    private String personalid;
    @Column(name = "address") 
    private String address;
    @Column(name = "cellphone") 
    private String cellphone;
    @Column(name = "gender") 
    private String gender;
    @Column(name = "jointime") 
    private Date jointime;
    @Column(name = "resigntime") 
    private Date resigntime;
    

    
	public User() {
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public User(int id, Role role, String name, String createtime,
			String description, String workid, String personalid,
			String address, String cellphone, String gender, Date jointime,
			Date resigntime, Set<Events> eventses) {
		this.id = id;
		this.role = role;
		this.name = name;
		this.createtime = createtime;
		this.description = description;
		this.workid = workid;
		this.personalid = personalid;
		this.address = address;
		this.cellphone = cellphone;
		this.gender = gender;
		this.jointime = jointime;
		this.resigntime = resigntime;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getWorkid() {
		return this.workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	public String getPersonalid() {
		return this.personalid;
	}

	public void setPersonalid(String personalid) {
		this.personalid = personalid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJointime() {
		return this.jointime;
	}

	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}

	public Date getResigntime() {
		return this.resigntime;
	}

	public void setResigntime(Date resigntime) {
		this.resigntime = resigntime;
	}
}
