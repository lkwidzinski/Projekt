package pl.edu.pjwstk.project.objects;

import java.util.List;

import pl.edu.pjwstk.project.services.DBmanager;

public class Plane implements PlaneInterface{
	
	private String name;
	private int tailNumber;
	private int capacity;
	private int passengers;
	private String destination;
	private boolean readyToGo;
	
	DBmanager db=DBmanager.getInstance();
	
	public Plane(String name, int tailNumber, int capacity, String destination, boolean readyToGo){
		this.name=name;
		this.tailNumber=tailNumber;
		this.capacity=capacity;
		this.destination=destination;
		this.readyToGo=readyToGo;
		
	}
	
	public void addPlane() {
		
	}
	public void removePlane() {
		
	}
	public List<PlaneInterface> getAll() {
		
		return null;
	}

	public void addPassenger() {
		// TODO Auto-generated method stub
		
	}

	public void removePassenger() {
		// TODO Auto-generated method stub
		
	}

	public void removeAllPassengers() {
		// TODO Auto-generated method stub
		
	}

}
