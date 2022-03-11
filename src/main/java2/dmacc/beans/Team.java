package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Team {
	// attributes
	private String teamName;
	private String city;
	private String state;
	private String stadium;
	
	// constructors
	public Team() {
		// default
		super();
	}
	
	public Team(String name, String city, String state, String stadium) {
		super();
		this.teamName = name;
		this.city = city;
		this.state = state;
		this.stadium = stadium;
	}

	// getters and setters
	public String getName() {
		return teamName;
	}

	public void setName(String name) {
		this.teamName = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	// methods
	@Override
	public String toString() {
		return "Team [name=" + teamName + ", city=" + city + ", state=" + state + ", stadium=" + stadium + "]";
	}
}
