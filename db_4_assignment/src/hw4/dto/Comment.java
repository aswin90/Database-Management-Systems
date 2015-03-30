package hw4.dto;

import hw4.dto.Movie;
import hw4.dto.User;

import java.util.Date;

public class Comment {
	private int id;
	private String comment;
	private java.sql.Date date;
	public Movie movie;
	public User user;
	
	// No arg-Constructor
	public Comment() { }
	
	// All arg-Constructor
	public Comment(int id, String comment, java.sql.Date date, Movie movie, User user) {
		super();
		this.id = id;
		this.comment = comment;
		this.date = date;
		this.movie = movie;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
