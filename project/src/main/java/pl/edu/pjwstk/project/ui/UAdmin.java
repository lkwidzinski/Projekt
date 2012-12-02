package pl.edu.pjwstk.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.services.PlaneManager;

public class UAdmin implements UInterface{

	BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
	PlaneManager mgr=new PlaneManager();
	
	public UAdmin() throws IOException, SQLException{
		
		selector();
		
	}
	
	public void selector() throws IOException, SQLException{
		
		
		
		System.out.println("**********************************************");
		System.out.println("Welcome to the airport administrator access:");
		System.out.println("1. Check the status of all planes.");
		System.out.println("2. Add a plane to the DB.");
		System.out.println("3. Remove plane from DB.");
		System.out.println("4. Remove all passengers from a plane.");
		System.out.println("5. Go back.");
		System.out.println("Select option:");
		
		int x=0;
		try {
			x = Integer.parseInt(c.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch(x){
		case 1:   status();    ;break;
		case 2:   add();       ;break;
		case 3:   remove();    ;break;
		case 4:   update();    ;break;
		case 5:   goBack();    ;break;
		default: System.out.println("Invalid number.");
                 selector();   ;break;
		}
	}
	public void status() throws IOException, SQLException{
		
		PlaneManager mgr=new PlaneManager();
		System.out.println("***************************************************************************************");
		System.out.format("%15s||%10s||%8s||%10s||%15s||%8s\n","NAME","TAILNUMBER","CAPACITY","PASSENGERS","DESTINATION","READY");
		List<Plane> planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}
		continueWork();
		
	}
	
	public void add() throws IOException, SQLException{
		
		String name;
		String tailNumber;
		int capacity;
		int passengers;
		String destination;
		boolean readyToGo;
				
		System.out.println("******Adding plane**************");
		System.out.println("Name:");
		name=c.readLine();
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		System.out.println("Capacity:");
		capacity=Integer.parseInt(c.readLine());
		System.out.println("Nr of passengers:");
		passengers=Integer.parseInt(c.readLine());
		System.out.println("Destination:");
		destination=c.readLine();
		System.out.println("Is the plane ready fot flight?(true/false):");
		readyToGo=Boolean.parseBoolean(c.readLine());
		Plane plane=new Plane(name, tailNumber, capacity, passengers, destination, readyToGo);
		
		mgr.addPlane(plane);
		System.out.println("Added plane.");
		continueWork();
	}
	public void remove() throws IOException, SQLException{
		
		String tailNumber;
		System.out.println("******Removal of a plane**************");
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		mgr.removePlane(new Plane("", tailNumber, 0, 0, "", false));
		continueWork();
	}
	
	public void update() throws IOException, SQLException{
		String tailNumber;
		System.out.println("******Removing all passengers from a plane**************");
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		mgr.removeAllPassengers(new Plane("", tailNumber, 0, 0, "", false));
		continueWork();
		
	}
	
	public void goBack() throws IOException, SQLException{
		new USelector();
	}
	public void continueWork() throws IOException, SQLException{
		
		System.out.println("Continue?Y/N");
		String z=c.readLine();
		if(z.equalsIgnoreCase("Y")){
			selector();
		}
		else{
			System.out.println("Exiting application.");
			System.exit(0);
		}
		
	}
}
