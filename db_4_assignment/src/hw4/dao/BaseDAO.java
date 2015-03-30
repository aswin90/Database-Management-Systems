package hw4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	private static BaseDAO instance = null;
	
	public BaseDAO() { }
	
	public static BaseDAO getInstance() {
		if (instance == null) {
			System.out.println("create new instance");
			instance = new BaseDAO();
		} else {
			System.out.println("returning old");
		}
		
		return instance;
	}
	
	protected Connection getConnection() {
		Connection connection;
		String url = "jdbc:mysql://localhost/hwfour";
		String user = "root";
		String password = "admin";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
