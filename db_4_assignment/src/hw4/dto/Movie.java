package hw4.dto;

import hw4.dto.Cast;
import hw4.dto.Comment;

import java.util.Date;
import java.util.HashSet;

public class Movie {
	
	private int id;
	private String title;
	private String posterImage;
	private java.sql.Date releaseDate;
	public HashSet<Cast> casts;
	public HashSet<Comment> comments;
	
	// No arg-constructor
    public Movie() { }
	
    // All arg-constructor
	public Movie(int id, String title, String posterImage, java.sql.Date releaseDate,
			HashSet<Cast> casts, HashSet<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.posterImage = posterImage;
		this.releaseDate = releaseDate;
		this.casts = casts;
		this.comments = comments;
	}

	public HashSet<Cast> getCasts() {
		return casts;
	}

	public void setCasts(HashSet<Cast> casts) {
		this.casts = casts;
	}

	public HashSet<Comment> getComments() {
		return comments;
	}

	public void setComments(HashSet<Comment> comments) {
		this.comments = comments;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	public java.sql.Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(java.sql.Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}

