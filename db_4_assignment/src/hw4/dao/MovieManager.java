package hw4.dao;

import hw4.dto.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieManager extends BaseDAO {
	
	public MovieManager() {
		
	}
	
	public void createMovie(Movie newMovie) {
		String sql = "insert into movie(title,posterImage,date) values(?,?,?)";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			//System.out.println("username::" + newMovie.getUsername());
			stmt.setString(1,newMovie.getTitle());
			stmt.setString(2,newMovie.getPosterImage());
			stmt.setDate(3,newMovie.getReleaseDate());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public List<Movie> readAllMovies() {
		String sql = "select * from movie";
		ResultSet rs = null;
		List<Movie> movies = new ArrayList();
		String title;
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				title = rs.getString("title");
				Movie movie = new Movie();
				movie.setTitle(title);
				movie.setPosterImage(rs.getString("image"));
				movie.setReleaseDate(rs.getDate("date"));
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public Movie readMovie(int id) {
		String sql = "select * from Movie where id = ?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		String title;
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				title = rs.getString("title");
				Movie movie = new Movie();
				movie.setTitle(title);
				movie.setPosterImage(rs.getString("image"));
				movie.setReleaseDate(rs.getDate("date"));
				return movie;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public void updateMovie(int movieId, Movie movie) {
		String sql = "update movie set title=? where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, movie.getTitle());
			stmt.setInt(2,movie.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public void  deleteMovie(int id) {
		String sql = "delete movie.* from movie where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public int selectMovieIdForTitle(String title) {
		String sql = "select id from movie where title=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		ResultSet rs = null;
		int id = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, title);
			rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return id;
	}


}
