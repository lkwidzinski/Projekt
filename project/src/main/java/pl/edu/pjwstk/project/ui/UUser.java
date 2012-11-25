package pl.edu.pjwstk.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.services.PlaneManager;

public class UUser implements UInterface{
	
	BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
	PlaneManager mgr=new PlaneManager();
	
	public UUser() throws IOException{
		selector();
	}

	public void selector() throws IOException {
		
		System.out.println("**********************************************");
		System.out.println("Welcome to the airport user access:");
		System.out.println("1. Check the status of all planes.");
		System.out.println("2. Check the planes with destination.");
		System.out.println("3. Add passenger.");
		System.out.println("4. Remove passenger.");
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
		case 1:   status();         ;break;
		case 2:   check();	        ;break;
		case 3:   addPassenger();   ;break;
		case 4:   removePassenger();;break;
		case 5:   goBack()          ;break;
		default: System.out.println("Invalid number.");
                 selector();        ;break;
		}
		
	}
	public void status() throws IOException{
		
		PlaneManager mgr=new PlaneManager();
		System.out.println("***************************************************************************************");
		System.out.format("%15s||%10s||%8s||%10s||%15s||%8s\n","NAME","TAILNUMBER","CAPACITY","PASSENGERS","DESTINATION","READY");
		List<Plane> planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}
		continueWork();
		
	}
	
	public void check() throws IOException{
		String destination;
		System.out.println("******Searching for planes with destination**************");
		System.out.println("Destination:");
		destination=c.readLine();
		List<Plane> planes=mgr.getAll();
		for(Plane p : planes){
			if (p.getDestination().equalsIgnoreCase(destination)){
				System.out.println(p);
			}
		}
		continueWork();
	}
	
	public void addPassenger() throws IOException{
		
		String tailNumber;
		System.out.println("******Adding passenger**************");
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		mgr.addPassenger(new Plane("", tailNumber, 0, 0, "", false));
		continueWork();
	}
	
	public void removePassenger() throws IOException{
		
		String tailNumber;
		System.out.println("******Removing passenger**************");
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		mgr.removePassenger(new Plane("", tailNumber, 0, 0, "", false));
		continueWork();
		
	}
	
	public void continueWork() throws IOException{
		
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

	@Override
	public void goBack() throws IOException {
		new USelector();	
	}
	

}
