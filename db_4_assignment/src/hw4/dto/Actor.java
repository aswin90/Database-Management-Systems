package hw4.dto;

import hw4.dto.Cast;

import java.util.HashSet;

public class Actor {
	
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	public HashSet<Cast> cast;
	
	public HashSet<Cast> getCast() {
		return cast;
	}

	public void setCast(HashSet<Cast> cast) {
		this.cast = cast;
	}

	public Actor(int id, String firstName, String lastName, String dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dob;
		cast = new HashSet();
	}
	public Actor() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
