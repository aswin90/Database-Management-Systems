package hw4.dao;

import hw4.dto.Comment;
import hw4.dto.Movie;
import hw4.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentManager extends BaseDAO {
	
	public CommentManager() {
		
	}
	
	public void createComment(Comment newComment) {
		String sql = "insert into Comment(comment,date,movie,user) values(?,?,?,?)";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		String title;
		int id;
		MovieManager manager = new MovieManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			User user = newComment.getUser();
			Movie movie = newComment.getMovie();
			title = movie.getTitle();
			System.out.println(user.getUsername());
			System.out.println(movie.getId());
			id = manager.selectMovieIdForTitle(title);
			System.out.println(id);
			stmt.setString(1,newComment.getComment());
			stmt.setDate(2, newComment.getDate());
			stmt.setInt(3,id);
			stmt.setString(4,user.getUsername());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public List<Comment> readAllComments() {
		String sql = "select * from comment";
		ResultSet rs = null;
		List<Comment> comments = new ArrayList();
		BaseDAO instance = getInstance();
		UserManager manager = new UserManager();
		MovieManager moviemanager = new MovieManager();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Comment comment = new Comment();
				Movie movie = new Movie();
				User user = new User();
				String username;
				int movieId;
				comment.setId(rs.getInt(1));
				comment.setComment(rs.getString(2));
				comment.setDate(rs.getDate(3));
				movieId = rs.getInt(4);
				username = rs.getString(5);
				user = manager.readUser(username);
				movie = moviemanager.readMovie(movieId);
				comment.setMovie(movie);
				comment.setUser(user);
				comments.add(comment);
			}
			return comments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public List<Comment> readAllCommentsForUsername(String username) {
		String sql = "select * from comment where user=?";
		ResultSet rs = null;
		List<Comment> comments = new ArrayList();
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager moviemanager = new MovieManager();
		UserManager manager = new UserManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,username);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Comment comment = new Comment();
				Movie movie = new Movie();
				User user = new User();
				String name;
				int movieId;
				comment.setId(rs.getInt(1));
				comment.setComment(rs.getString(2));
				comment.setDate(rs.getDate(3));
				movieId = rs.getInt(4);
				name = rs.getString(5);
				user = manager.readUser(username);
				movie = moviemanager.readMovie(movieId);
				comment.setMovie(movie);
				comment.setUser(user);
				comments.add(comment);
			}
			return comments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public List<Comment> readAllCommentsForMovieId(int movieId) {
		String sql = "select * from comment where movie=?";
		ResultSet rs = null;
		List<Comment> comments = new ArrayList();
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager moviemanager = new MovieManager();
		UserManager manager = new UserManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,movieId);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Comment comment = new Comment();
				Movie movie = new Movie();
				User user = new User();
				String username;
				int id;
				comment.setId(rs.getInt(1));
				comment.setComment(rs.getString(2));
				comment.setDate(rs.getDate(3));
				id = rs.getInt(4);
				username = rs.getString(5);
				user = manager.readUser(username);
				movie = moviemanager.readMovie(id);
				comment.setMovie(movie);
				comment.setUser(user);
				comments.add(comment);
			}
			return comments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public Comment readCommentForId(int commentId) {
		String sql = "select * from Comment where id = ?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		String title;
		ResultSet rs = null;
		MovieManager moviemanager = new MovieManager();
		UserManager manager = new UserManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,commentId);
			rs = stmt.executeQuery();
			Comment comment = new Comment();
			if (rs.next()) {
				Movie movie = new Movie();
				User user = new User();
				String username;
				int id;
				comment.setId(rs.getInt(1));
				comment.setComment(rs.getString(2));
				comment.setDate(rs.getDate(3));
				id = rs.getInt(4);
				username = rs.getString(5);
				user = manager.readUser(username);
				movie = moviemanager.readMovie(id);
				comment.setMovie(movie);
				comment.setUser(user);
			}
			return comment;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public void updateComment(int commentId, String newComment) {
		String sql = "update comment set comment=? where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		MovieManager moviemanager = new MovieManager();
		UserManager manager = new UserManager();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, newComment);
			stmt.setInt(2, commentId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public void  deleteComment(int id) {
		String sql = "delete comment.* from comment where id=?";
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


}

