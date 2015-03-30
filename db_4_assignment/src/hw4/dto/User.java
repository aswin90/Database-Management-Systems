package hw4.dto;

import hw4.dto.Comment;

import java.util.Date;
import java.util.HashSet;

public class User {
    
	private int id;
    private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private java.sql.Date date;
	public HashSet<Comment> comments;
	
	// No arg-constructor
	public User() {}
	
    // All arg-constructor
	public User(int id, String username, String password, String firstName,
			String lastName, String email, java.sql.Date date, HashSet<Comment> comments) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.comments = comments;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
}
