package devproblem_api;

import java.io.Serializable;

public class Tank implements Serializable {

	private static final long serialVersionUID = -3128208635872448450L;

	private int id;
	private String code;
	private double capacity;
	private Wine contents;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public Wine getContents() {
		return contents;
	}

	public void setContents(Wine contents) {
		this.contents = contents;
	}
}
