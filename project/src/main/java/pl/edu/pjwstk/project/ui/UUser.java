package pl.edu.pjwstk.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import pl.edu.pjwstk.project.objects.Person;
import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.services.PersonManager;
import pl.edu.pjwstk.project.services.PlaneManager;

public class UUser implements UInterface{
	
	BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
	PlaneManager mgr=new PlaneManager();
	
	public UUser() throws IOException, SQLException{
		selector();
	}

	public void selector() throws IOException, SQLException {
		
		System.out.println("**********************************************");
		System.out.println("Welcome to the airport user access:");
		System.out.println("1. Check the status of all planes.");
		System.out.println("2. Check the planes with destination.");
		System.out.println("3. Add passenger.");
		System.out.println("4. Remove passenger.");
		System.out.println("5. Add person to database.");
		System.out.println("6. Remove person from database.");
		System.out.println("7. Show all people in the DB.");
		System.out.println("8. Go back.");
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
		case 5:   addPersonDB();	;break;
		case 6:	  removePersonDB();	;break;
		case 7:   statusPerson()	;break;
		case 8:   goBack()          ;break;
		default: System.out.println("Invalid number.");
                 selector();        ;break;
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
	
	public void check() throws IOException, SQLException{
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
	
	public void addPassenger() throws IOException, SQLException{
		
		String tailNumber;
		int pesel;
		System.out.println("******Adding passenger**************");
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		System.out.println("PESEL:");
		pesel=Integer.parseInt(c.readLine());
		mgr.addPassenger(new Plane("", tailNumber, 0, 0, "", false),new Person("","",pesel,""));
		continueWork();
	}
	
	public void removePassenger() throws IOException, SQLException{
		
		String tailNumber;
		System.out.println("******Removing passenger**************");
		System.out.println("Tailnumber:");
		tailNumber=c.readLine();
		mgr.removePassenger(new Plane("", tailNumber, 0, 0, "", false));
		continueWork();
		
	}
	
	public void addPersonDB() throws IOException, SQLException{
		
		PersonManager mgr=new PersonManager();
		String firstName;
		String lastName;
		int pesel;
		String additionalInfo;
		
		System.out.println("******Adding person to database**************");
		System.out.println("First name:");
		firstName=c.readLine();
		System.out.println("Last name:");
		lastName=c.readLine();
		System.out.println("Pesel:");
		pesel=Integer.parseInt(c.readLine());
		System.out.println("Additional Info:");
		additionalInfo=c.readLine();
		
		mgr.addPerson(new Person(firstName,lastName,pesel,additionalInfo));
		System.out.println("Dodano do bazy.");
		continueWork();
	}
	public void removePersonDB() throws IOException, SQLException{
		PersonManager mgr=new PersonManager();
		int pesel;
		System.out.println("******Remove person from database**************");
		System.out.println("Pesel:");
		pesel=Integer.parseInt(c.readLine());
		mgr.removePerson(new Person("", "", pesel, ""));
		continueWork();
	}
	public void statusPerson() throws IOException, SQLException{
		
		PersonManager mgr=new PersonManager();
		System.out.println("***************************************************************************************");
		System.out.format("%20s||%20s||%20s||%40s\n","FIRST NAME","LAST NAME","PESEL","ADDITIONAL INFO");
		List<Person> persons=mgr.getAll();
		for(Person p : persons){
			System.out.println(p);
		}
		continueWork();
		
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

	@Override
	public void goBack() throws IOException, SQLException {
		new USelector();	
	}
	

}
