package hw4.dao;

import hw4.dto.Comment;
import hw4.dto.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager extends BaseDAO {

		public UserManager() {
			
		}
		public void createUser(User user) {
			String sql = "insert into User(username,password,firstName,lastName,email,date) values(?,?,?,?,?,?)";
			BaseDAO instance = getInstance();
			Connection connection = instance.getConnection();
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1,user.getUsername());
				stmt.setString(2,user.getPassword());
				stmt.setString(3,user.getFirstName());
				stmt.setString(4,user.getLastName());
				stmt.setString(5,user.getEmail());
				stmt.setDate(6, user.getDate());
				stmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(connection);
			}
		}
		
		public List<User> readAllUsers() {
			String sql = "select * from user";
			ResultSet rs = null;
			List<User> users = new ArrayList();
			String username;
			String password;
			BaseDAO instance = getInstance();
			Connection connection = instance.getConnection();
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					username = rs.getString("username");
					password = rs.getString("password");
					
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setFirstName(rs.getString("firstName"));
					user.setLastName(rs.getString("lastName"));
					user.setEmail(rs.getString("email"));
					user.setDate(rs.getDate("date"));
					users.add(user);
				}
				return users;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(connection);
			}
			return null;
		}
		
		public User readUser(String username) {
			String sql = "select * from User where username = ?";
			BaseDAO instance = getInstance();
			Connection connection = instance.getConnection();
			String name;
			String password;
			ResultSet rs = null;
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1,username);
				rs = stmt.executeQuery();
				if (rs.next()) {
					username = rs.getString(2);
					password = rs.getString(3);
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setFirstName(rs.getString(4));
					user.setLastName(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setDate(rs.getDate(7));
					return user;
				} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(connection);
			}
			return null;
		}
		
		public void updateUser(String username, User user) {
			String sql = "update user set username=? where username=?";
			BaseDAO instance = getInstance();
			Connection connection = instance.getConnection();
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, user.getUsername());
				stmt.setString(2, username);
				stmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(connection);
			}
		}
		
		public void  deleteUser(String username) {
			String sql = "delete user.* from user where username=?";
			BaseDAO instance = getInstance();
			Connection connection = instance.getConnection();
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(connection);
			}
		}
	}
