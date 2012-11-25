package pl.edu.pjwstk.project.services;

import java.util.List;

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

	public boolean addPassenger(Plane obj) {
		return db.addPassenger(obj);
	}

	public boolean removePassenger(Plane obj) {
		return db.removePassenger(obj);
	}

	public boolean removeAllPassengers(Plane obj) {
		return db.removeAllPassengers(obj);
	}
	
	
}
