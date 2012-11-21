package pl.edu.pjwstk.project.objects;

import java.util.List;

public interface PlaneInterface {
	
	boolean addPlane(Plane obj);
	void removePlane();
	List<PlaneInterface> getAll();
	void addPassenger();
	void removePassenger();
	void removeAllPassengers();
	
	
	

}
