package net.diegozhu.j2ee.ptms.model;
 
/**
 * LineStation   */
public class LineStation implements java.io.Serializable {
 
    private static final long serialVersionUID = -8189834180916208821L;
	private LineStationId id;
	private Station station;
	private Line line;

	public LineStation() {
	}

	public LineStation(LineStationId id, Station station, Line line) {
		this.id = id;
		this.station = station;
		this.line = line;
	}

	public LineStationId getId() {
		return this.id;
	}

	public void setId(LineStationId id) {
		this.id = id;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Line getLine() {
		return this.line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

}
