package devproblem_api;

import java.io.Serializable;

public class Owner implements Serializable {
	
	private static final long serialVersionUID = 4448594607675245599L;

	private int id;
	private String name;
	private String emailAddress;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
