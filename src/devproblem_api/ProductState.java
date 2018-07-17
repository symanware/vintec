package devproblem_api;

import java.io.Serializable;

public class ProductState implements Serializable {

	private static final long serialVersionUID = -62656732761826869L;

	private int id;
	private String description;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
