package hw4.client;
import hw4.dao.*;
import hw4.dto.*;

public class Hw4Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Instantiate client
		Hw4Client client = new Hw4Client();
		
		// Instantiate User
		User user = new User();
		user.setUsername("sachin89");
		user.setPassword("cricket");
		user.setFirstName("sachinramesh");
		user.setLastName("tendulkar");
		user.setEmail("sachin89@gmail.com");
		user.setDate(new java.sql.Date(89,9,28));
		
		// Instantiate Movie
		Movie movie = new Movie();
		movie.setTitle("harrypotter");
		movie.setPosterImage("danielimage");
		movie.setReleaseDate(new java.sql.Date(90,9,17));
		
		// Instantiate Comment
		Comment comment = new Comment();
		comment.setComment("This is Sachin's comment for HarryPotter movie");
		comment.setMovie(movie);
		comment.setUser(user);
		comment.setDate(new java.sql.Date(90,9,17));
		
		// Instantiate Actor
		Actor actor = new Actor();
		actor.setFirstName("Ron");
		actor.setLastName("Weasley");
		actor.setDateOfBirth("12-02-2000");
		
		
		// Instantiate Cast
		Cast cast = new Cast();
		cast.setActor(actor);
		cast.setCharacterName("Hero");
		cast.setMovie(movie);
		
		// Instantiating all Manager classes
		UserManager usermanager = new UserManager();
		MovieManager moviemanager = new MovieManager();
		CommentManager commentmanager = new CommentManager();
		CastManager castmanager = new CastManager();
		ActorManager actormanager = new ActorManager();
		
		usermanager.createUser(user);
		moviemanager.createMovie(movie);
		
		commentmanager.createComment(comment);
		actormanager.createActor(actor);
		castmanager.createCast(cast);
		

	}

}
