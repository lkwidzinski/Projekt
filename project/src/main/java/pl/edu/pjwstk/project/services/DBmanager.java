package pl.edu.pjwstk.project.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.edu.pjwstk.project.objects.Plane;

public final class DBmanager {

	private Connection connection;
	private Statement statement;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private ResultSet rs;
	private String createTable="CREATE TABLE Planes (id bigint GENERATED BY DEFAULT AS IDENTITY," +
					" name varchar(20), tailnumber int, capacity int, passengers int," +
					"destination varchar(20), readytogo boolean);";
	private String addPlaneSQL="INSERT INTO Planes (name,tailnumber,capacity,passengers,destination,readytogo) " +
			"VALUES (?,?,?,?,?,?);";
	private String removePlaneSQL="DELETE FROM Planes where name=?;";
	private String getAllSQL="SELECT * from Planes;";
	private String addPassengerSQL="UPDATE Planes SET passengers=passengers+1 WHERE name=?";
	private String removePassengerSQL="UPDATE Planes SET passengers=passengers-1 WHERE name=?";
	private String removeAllPassengersSQL="UPDATE Planes SET passengers=0 WHERE name=?";
	
	
	PreparedStatement addPlane;
	PreparedStatement removePlane;
	PreparedStatement getAll;
	PreparedStatement addPassenger;
	PreparedStatement removePassenger;
	PreparedStatement removeAllPassengers;

	private DBmanager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			rs = connection.getMetaData().getTables(null, null, null,
			null);
			
			boolean tableExists=false;
			while (rs.next()) {
				if ("Planes".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
				tableExists = true;
				break;
				}
			}
			
			if(!tableExists)
			{
			statement.executeUpdate(createTable);

			}
			
			addPlane=connection.prepareStatement(addPlaneSQL);
			removePlane=connection.prepareStatement(removePlaneSQL);
			getAll=connection.prepareStatement(getAllSQL);
			addPassenger=connection.prepareStatement(addPassengerSQL);
			removePassenger=connection.prepareStatement(removePassengerSQL);
			removeAllPassengers=connection.prepareStatement(removeAllPassengersSQL);
			
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
	
	public boolean addPlane(Plane obj) {
		try {
		addPlane.setString(1, obj.getName());
		addPlane.setInt(2, obj.getTailNumber());
		addPlane.setInt(3, obj.getCapacity());
		addPlane.setInt(4, obj.getPassengers());
		addPlane.setString(5, obj.getDestination());
		addPlane.setBoolean(6, obj.isReadyToGo());
		return addPlane.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	public boolean removePlane(Plane obj) {
		try {
		removePlane.setString(1, obj.getName());
		return removePlane.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	
	public List<Plane> getAll(){
		List<Plane> result= new ArrayList<Plane>();

		try {
		ResultSet rs= getAll.executeQuery();
		while(rs.next())
		{
		Plane p = new Plane(rs.getString("name"), rs.getInt("tailnumber"),rs.getInt("capacity"), rs.getInt("passengers"), rs.getString("destination"), rs.getBoolean("readytogo"));
		result.add(p);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return result;
		
	}
	public boolean addPassenger(Plane obj) {
		try {
		addPassenger.setString(1, obj.getName());
		return addPassenger.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	public boolean removePassenger(Plane obj) {
		try {
		removePassenger.setString(1, obj.getName());
		return removePassenger.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	public boolean removeAllPassengers(Plane obj) {
		try {
		removeAllPassengers.setString(1, obj.getName());
		return removeAllPassengers.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
}