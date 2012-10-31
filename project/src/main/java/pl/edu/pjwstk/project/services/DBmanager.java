package pl.edu.pjwstk.project.services;

import java.sql.*;

public class DBmanager {
	
	private Connection connection;
	private Statement statement;
	private String url;

	
	public DBmanager(){
		
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
			null);
			boolean tableExists = false;
			while (rs.next()) {
			if ("Person".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
			tableExists = true;
			break;
			}
			}

			if (!tableExists)
			statement.executeUpdate(createTablePerson);

			addPersonStmt = connection
			.prepareStatement("INSERT INTO Person (name, yob) VALUES (?, ?)");
			deleteAllPersonsStmt = connection
			.prepareStatement("DELETE FROM Person");
			getAllPersonsStmt = connection
			.prepareStatement("SELECT id, name, yob FROM Person");

			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
}
