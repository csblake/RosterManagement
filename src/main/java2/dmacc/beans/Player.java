package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Player {
	// attributes
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String height;
	private String position;
	private int number;
	private int yearsPro;
	@Autowired
	private Team team;
	
	// constructors
	public Player() {
		// default
		super();
		this.height = "6 ft. 6 in.";
	}
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public Player(String name, String height, String postion, int number, int yearsPro) {
		super();
		this.name = name;
		this.height = height;
		this.number = number;
		this.yearsPro = yearsPro;
	}
	
	public Player(int id, String name, String height, String position, int number, int yearsPro) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.number = number;
		this.yearsPro = yearsPro;
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if(number == 0) {
			this.number = -1;
		} else {
			this.number = number;
		}
	}

	public int getYearsPro() {
		return yearsPro;
	}

	public void setYearsPro(int yearsPro) {
		this.yearsPro = yearsPro;
	}
	

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	// methods
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", height=" + height + ", position=" + position + ", number="
				+ number + ", yearsPro=" + yearsPro + ", team=" + team + "]";
	}
}
