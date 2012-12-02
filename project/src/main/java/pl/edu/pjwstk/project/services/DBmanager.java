package pl.edu.pjwstk.project.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.edu.pjwstk.project.objects.Person;
import pl.edu.pjwstk.project.objects.Plane;

public final class DBmanager {

	private Connection connection;
	private Statement statement;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private ResultSet rs;
	private String createTable="CREATE TABLE Planes (id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
					" name varchar(20), tailnumber varchar(6), capacity int, passengers int," +
					"destination varchar(20), readytogo boolean);";
	private String createTable2="CREATE TABLE Persons (id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
			" firstname varchar(20), lastname varchar(20), pesel int,additionalinfo varchar(40));";
	private String createTable3="CREATE TABLE Planes_has_Persons (plane_id bigint," +
			"person_id bigint,FOREIGN KEY(plane_id) references Planes(id), FOREIGN KEY(person_id) references Persons(id));";
	
	//zapytania sql planes
	
	private String addPlaneSQL="INSERT INTO Planes (name,tailnumber,capacity,passengers,destination,readytogo) " +
			"VALUES (?,?,?,?,?,?);";
	private String removePlaneSQL="DELETE FROM Planes where tailnumber=?;";
	private String getAllSQL="SELECT * from Planes;";
	private String addPassengerSQL="UPDATE Planes SET passengers=passengers+1 WHERE tailnumber=?;";
	private String addPassengerSQL2="INSERT INTO Planes_has_Persons (plane_id,person_id) values (?,?);";
	private String removePassengerSQL="UPDATE Planes SET passengers=passengers-1 WHERE tailnumber=?;";
	private String removeAllPassengersSQL="UPDATE Planes SET passengers=0 WHERE tailnumber=?;";
	
	//zapytania sql persons
	
	private String addPersonSQL="INSERT INTO Persons (firstname,lastname,pesel,additionalinfo) " +
			"VALUES (?,?,?,?);";
	private String removePersonSQL="DELETE FROM Persons where pesel=?;";
	private String getAllPersonsSQL="SELECT * from Persons;";
	
	//statementy planes
	PreparedStatement addPlane;
	PreparedStatement removePlane;
	PreparedStatement getAll;
	PreparedStatement addPassenger;
	PreparedStatement removePassenger;
	PreparedStatement removeAllPassengers;
	
	//statementy persons
	PreparedStatement addPerson;
	PreparedStatement removePerson;
	PreparedStatement getAllPersons;
	
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
			rs.first();
			tableExists=false;
			while (rs.next()) {
				if ("Persons".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
				tableExists = true;
				break;
				}
			}
			
			if(!tableExists)
			{
			statement.executeUpdate(createTable2);

			}
			rs.first();
			tableExists=false;
			while (rs.next()) {
				if ("Planes_has_Persons".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
				tableExists = true;
				break;
				}
			}
			
			if(!tableExists)
			{
			statement.executeUpdate(createTable3);

			}
			addPlane=connection.prepareStatement(addPlaneSQL);
			removePlane=connection.prepareStatement(removePlaneSQL);
			getAll=connection.prepareStatement(getAllSQL);
			//addPassenger=connection.prepareStatement(addPassengerSQL);
			removePassenger=connection.prepareStatement(removePassengerSQL);
			removeAllPassengers=connection.prepareStatement(removeAllPassengersSQL);
			
			addPerson=connection.prepareStatement(addPersonSQL);
			removePerson=connection.prepareStatement(removePersonSQL);
			getAllPersons=connection.prepareStatement(getAllPersonsSQL);
			
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
	
	//plane
	public boolean addPlane(Plane obj) {
		try {
		addPlane.setString(1, obj.getName());
		addPlane.setString(2, obj.getTailNumber());
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
		removePlane.setString(1, obj.getTailNumber());
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
		Plane p = new Plane(rs.getString("name"), rs.getString("tailnumber"),rs.getInt("capacity"), rs.getInt("passengers"), rs.getString("destination"), rs.getBoolean("readytogo"));
		result.add(p);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return result;
		
	}
	public boolean addPassenger(Plane obj,Person p) throws SQLException {
		connection.setAutoCommit(false);
		try {
		int plane_id = 99;
		int person_id = 99;
		ResultSet rs2=getAll.executeQuery();
		while(rs2.next())
		{
		if(rs2.getString("tailnumber")==obj.getTailNumber())
		plane_id=rs2.getInt("id");
		}
		rs2=getAllPersons.executeQuery();
		while(rs2.next())
		{
		if(rs2.getInt("pesel")==p.getPesel())
		person_id=rs2.getInt("id");
		}
		addPassenger=connection.prepareStatement(addPassengerSQL);	
		addPassenger.setString(1, obj.getTailNumber());
		addPassenger.execute();
		addPassenger=connection.prepareStatement(addPassengerSQL2);
		addPassenger.setInt(1, plane_id);
		addPassenger.setInt(2, person_id);
		addPassenger.execute();
		connection.commit();
		} catch (SQLException e) {
		e.printStackTrace();
		connection.rollback();
		System.out.println("Blad przypisania pasazera do samolotu");
		}
		connection.setAutoCommit(false);
		return false;
	}
	public boolean removePassenger(Plane obj) {
		try {
		removePassenger.setString(1, obj.getTailNumber());
		return removePassenger.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	public boolean removeAllPassengers(Plane obj) {
		try {
		removeAllPassengers.setString(1, obj.getTailNumber());
		return removeAllPassengers.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	
	//person
	public boolean addPerson(Person obj) {
		try {
		addPerson.setString(1, obj.getFirstName());
		addPerson.setString(2, obj.getLastName());
		addPerson.setInt(3, obj.getPesel());
		addPerson.setString(4, obj.getAdditionalInfo());
		return addPerson.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	public boolean removePerson(Person obj) {
		try {
		removePerson.setInt(1, obj.getPesel());
		return removePerson.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}
	public List<Person> getAllPersons(){
		List<Person> result= new ArrayList<Person>();

		try {
		ResultSet rs= getAllPersons.executeQuery();
		while(rs.next())
		{
		Person p = new Person(rs.getString("firstname"), rs.getString("lastname"),rs.getInt("pesel"),rs.getString("additionalinfo"));
		result.add(p);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return result;
		
	}
}