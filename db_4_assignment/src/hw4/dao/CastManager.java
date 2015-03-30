package hw4.dao;

import hw4.dto.Actor;
import hw4.dto.Cast;
import hw4.dto.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CastManager extends BaseDAO{
	
	public void createCast(Cast newCast) {
		String sql = "insert into Casts(name,actor,movie) values(?,?,?)";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager manager = new MovieManager();
		ActorManager actmanager = new ActorManager();
		int movieId;
		int actorId;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			Actor actor = newCast.getActor();
			Movie movie = newCast.getMovie();
			movieId = manager.selectMovieIdForTitle(movie.getTitle());
			actorId = actmanager.selectActorIdForFullName(actor.getFirstName(), actor.getLastName());
			stmt.setString(1,newCast.getCharacterName());
			stmt.setInt(2,actorId);
			stmt.setInt(3,movieId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public List<Cast> readAllCasts() {
		String sql = "select * from casts";
		ResultSet rs = null;
		List<Cast> casts = new ArrayList();
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager manager = new MovieManager();
		ActorManager actmanager = new ActorManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Cast cast = new Cast();
				Movie movie = new Movie();
				Actor actor = new Actor();
				int movieId;
				int actorId;
				cast.setId(rs.getInt(1));
				cast.setCharacterName(rs.getString(2));
				actorId = rs.getInt(3);
				movieId = rs.getInt(4);
				movie = manager.readMovie(movieId);
				actor = actmanager.readActor(actorId);
				
				cast.setMovie(movie);
				cast.setActor(actor);
				casts.add(cast);
			}
			return casts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public List<Cast> readAllCastForActor(int actorId) {
		String sql = "select * from casts where actor=?";
		ResultSet rs = null;
		List<Cast> casts = new ArrayList();
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager manager = new MovieManager();
		ActorManager actmanager = new ActorManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,actorId);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Cast cast = new Cast();
				Movie movie = new Movie();
				Actor actor = new Actor();
				int movieId;
				int id;
				cast.setId(rs.getInt(1));
				cast.setCharacterName(rs.getString(2));
				id = rs.getInt(3);
				movieId = rs.getInt(4);
				movie = manager.readMovie(movieId);
				actor = actmanager.readActor(id);
				
				cast.setMovie(movie);
				cast.setActor(actor);
				casts.add(cast);
			}
			return casts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public List<Cast> readAllCastsForMovieId(int movieId) {
		String sql = "select * from casts where movie=?";
		ResultSet rs = null;
		List<Cast> casts = new ArrayList();
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager manager = new MovieManager();
		ActorManager actmanager = new ActorManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,movieId);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Cast cast = new Cast();
				Movie movie = new Movie();
				Actor actor = new Actor();
				cast.setId(rs.getInt(1));
				cast.setCharacterName(rs.getString(2));
				actor.setId(rs.getInt(3));
				movie.setId(rs.getInt(4));
				
				cast.setMovie(movie);
				cast.setActor(actor);
				casts.add(cast);
			}
			return casts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public Cast readCastForId(int castId) {
		String sql = "select * from Casts where id = ?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		String title;
		ResultSet rs = null;
		MovieManager manager = new MovieManager();
		ActorManager actmanager = new ActorManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,castId);
			rs = stmt.executeQuery();
			Cast cast = new Cast();
			if (rs.next()) {
				Movie movie = new Movie();
				Actor actor = new Actor();
				int movieId;
				int id;
				cast.setId(rs.getInt(1));
				cast.setCharacterName(rs.getString(2));
				id = rs.getInt(3);
				movieId = rs.getInt(4);
				movie = manager.readMovie(movieId);
				actor = actmanager.readActor(id);
				
				cast.setMovie(movie);
				cast.setActor(actor);
			}
			return cast;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public void updateCast(int castId, String newCast) {
		String sql = "update casts set name=? where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, newCast);
			stmt.setInt(2, castId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public void  deleteCast(int castId) {
		String sql = "delete casts.* from cast where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, castId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}

}

