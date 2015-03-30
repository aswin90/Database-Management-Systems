package hw4.dao;

import hw4.dto.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorManager extends BaseDAO {
	
	public void createActor(Actor actor) {
		String sql = "insert into Actor(firstName,lastName,dateOfBirth) values(?,?,?)";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,actor.getFirstName());
			stmt.setString(2,actor.getLastName());
			stmt.setString(3,actor.getDateOfBirth());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public List<Actor> readAllActors() {
		String sql = "select * from Actor";
		ResultSet rs = null;
		List<Actor> actors = new ArrayList();
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setFirstName(rs.getString("firstName"));
				actor.setLastName(rs.getString("lastName"));
				actor.setDateOfBirth(rs.getString("dateOfBirth"));
				actors.add(actor);
			}
			return actors;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public Actor readActor(int actorId) {
		String sql = "select * from Actor where id = ?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,actorId);
			rs = stmt.executeQuery();
			Actor actor = new Actor();
			if (rs.next()) {
				actor.setId(rs.getInt(1));
				actor.setFirstName(rs.getString(2));
				actor.setLastName(rs.getString(3));
				actor.setDateOfBirth(rs.getString(4));
			}
			return actor;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
		return null;
	}
	
	public void updateActor(int actorId, Actor actor) {
		String sql = "update Actor set firstName=? where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,actor.getFirstName());
			stmt.setInt(2, actorId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public void  deleteActor(int actorId) {
		String sql = "delete actor.* from actor where id=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, actorId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	public int selectActorIdForFullName(String fName, String lName) {
		String sql = "select id from actor where firstName=? and lastName=?";
		BaseDAO instance = getInstance();
		Connection connection = instance.getConnection();
		ResultSet rs = null;
		int id = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fName);
			stmt.setString(2, lName);
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