package net.diegozhu.j2ee.ptms.model;
 
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
public class Station implements java.io.Serializable {
 
    private static final long serialVersionUID = 9130852038635260030L;
	
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
    @Column(name = "periority")
	private Integer periority;
    @Column(name = "locationX")
	private Double locationX;
    @Column(name = "locationY")
	private Double locationY;
    @Column(name = "availble")
	private Boolean availble;
	


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

	public Integer getPeriority() {
		return this.periority;
	}

	public void setPeriority(Integer periority) {
		this.periority = periority;
	}

	public Double getLocationX() {
		return this.locationX;
	}

	public void setLocationX(Double locationX) {
		this.locationX = locationX;
	}

	public Double getLocationY() {
		return this.locationY;
	}

	public void setLocationY(Double locationY) {
		this.locationY = locationY;
	}

	public Boolean getAvailble() {
		return this.availble;
	}

	public void setAvailble(Boolean availble) {
		this.availble = availble;
	}


}
