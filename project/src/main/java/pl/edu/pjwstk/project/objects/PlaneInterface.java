package pl.edu.pjwstk.project.objects;

import java.sql.SQLException;
import java.util.List;

public interface PlaneInterface {
	
	boolean addPlane(Plane obj);
	boolean removePlane(Plane obj);
	List<Plane> getAll();
	boolean addPassenger(Plane obj,Person p) throws SQLException;
	boolean removePassenger(Plane obj);
	boolean removeAllPassengers(Plane obj);
	
	
	

}
