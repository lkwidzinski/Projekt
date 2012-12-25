package pl.edu.pjwstk.project.services;

import java.sql.SQLException;
import java.util.List;

import pl.edu.pjwstk.project.objects.Person;
import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.objects.PlaneInterface;

public class PlaneManager implements PlaneInterface{

	private DBmanager db=DBmanager.getInstance();
	
	public boolean addPlane(Plane obj) {
		return db.addPlane(obj);
	}

	public boolean removePlane(Plane obj) {
		return db.removePlane(obj);
	}

	public List<Plane> getAll() {
		
		return db.getAll();
	}

	public boolean addPassenger(Plane obj,Person p) throws SQLException {
		return db.addPassenger(obj,p);
	}

	public boolean removePassenger(Plane obj,Person p) throws SQLException {
		return db.removePassenger(obj,p);
	}

	public boolean removeAllPassengers(Plane obj) {
		return db.removeAllPassengers(obj);
	}
	
	
}
