package pl.edu.pjwstk.project.objects;

import java.util.List;

public interface PlaneInterface {
	
	boolean addPlane(Plane obj);
	boolean removePlane(Plane obj);
	List<Plane> getAll();
	boolean addPassenger(Plane obj);
	boolean removePassenger();
	boolean removeAllPassengers();
	
	
	

}
