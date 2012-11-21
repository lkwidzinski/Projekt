package pl.edu.pjwstk.project.objects;

import java.util.List;

import pl.edu.pjwstk.project.services.DBmanager;

public class Plane{
	
	private String name;
	private int tailNumber;
	private int capacity;
	private int passengers;
	private String destination;
	private boolean readyToGo;
	
	public Plane(String name, int tailNumber, int capacity,int passengers, String destination, boolean readyToGo){
		this.name=name;
		this.tailNumber=tailNumber;
		this.capacity=capacity;
		this.passengers=passengers;
		this.destination=destination;
		this.readyToGo=readyToGo;
		
	}
	//get
	public String getName() {
		return name;
	}

	public int getTailNumber() {
		return tailNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getPassengers() {
		return passengers;
	}

	public String getDestination() {
		return destination;
	}

	public boolean isReadyToGo() {
		return readyToGo;
	}

	public String toString(){
	
		return "Planes name:"+name+" tailnumber:"+tailNumber+" capacity:"+capacity+" passengers:"+passengers+" destination:"+destination+" ready:"+readyToGo;
	}


}
