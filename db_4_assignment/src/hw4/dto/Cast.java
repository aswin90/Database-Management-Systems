package hw4.dto;

import hw4.dto.Actor;
import hw4.dto.Movie;

public class Cast {
	private int id;
	private String characterName;
	public Actor actor;
	public Movie movie;
	
	// No arg-constructor
	public Cast () {}
	
	// All arg-constructor
	
	public Cast(int id, String characterName, Actor actor, Movie movie) {
		
		this.id = id;
		this.characterName = characterName;
		this.actor = actor;
		this.movie = movie;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Cast(String name) {
		characterName = name;
	}
	
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

}

