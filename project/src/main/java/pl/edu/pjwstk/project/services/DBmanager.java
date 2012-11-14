package pl.edu.pjwstk.project.services;

import java.sql.*;

public final class DBmanager {

	private Connection connection;
	private Statement statement;
	private String url;
	private ResultSet rs;

	private DBmanager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			rs = connection.getMetaData().getTables(null, null, null,
			null);
			
			} catch (SQLException e) {
			e.printStackTrace();
			}
	
	}

	private static DBmanager instance;

	public static DBmanager getInstance() {

		if (instance == null)
			synchronized (DBmanager.class) {
				if (instance == null)
					instance = new DBmanager();
			}
		return instance;
	}
	
	//metody
	
	
}