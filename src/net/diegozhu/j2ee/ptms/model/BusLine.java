package net.diegozhu.j2ee.ptms.model;
 
/**
 * BusLine   */
public class BusLine implements java.io.Serializable {
 
    private static final long serialVersionUID = -2333926034667032588L;
	private BusLineId id;
	private Bus bus;
	private Line line;

	public BusLine() {
	}

	public BusLine(BusLineId id, Bus bus, Line line) {
		this.id = id;
		this.bus = bus;
		this.line = line;
	}

	public BusLineId getId() {
		return this.id;
	}

	public void setId(BusLineId id) {
		this.id = id;
	}

	public Bus getBus() {
		return this.bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Line getLine() {
		return this.line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

}
