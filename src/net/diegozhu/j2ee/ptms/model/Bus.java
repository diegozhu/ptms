package net.diegozhu.j2ee.ptms.model;
 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Bus   */
public class Bus implements java.io.Serializable {
 
    private static final long serialVersionUID = -5504398030244011138L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "createtime") 
	private String createtime;
	@Column(name = "description")
	private String description;
	@Column(name = "driver")
	private User driver;
	@Column(name = "maxpassager")
	private Integer maxpassager;
	@Column(name = "type")
	private String type;
	@Column(name = "purchasetime")
	private Date purchasetime;
	@Column(name = "lefttime")
	private Date lefttime;

	

	public Bus() {}

	public Bus(int id, String name) {
		this.id = id;
		this.name = name;
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



	public Integer getMaxpassager() {
		return this.maxpassager;
	}

	public void setMaxpassager(Integer maxpassager) {
		this.maxpassager = maxpassager;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPurchasetime() {
		return this.purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}

	public Date getLefttime() {
		return this.lefttime;
	}

	public void setLefttime(Date lefttime) {
		this.lefttime = lefttime;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}



}
