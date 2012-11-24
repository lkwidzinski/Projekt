package pl.edu.pjwstk.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.services.PlaneManager;

public class UAdmin implements UInterface{

	
	public UAdmin(){
		
		selector();
		
	}
	
	public void selector(){
		
		
		
		System.out.println("*********************************************");
		System.out.println("Welcome to the airport administrator access:");
		System.out.println("1. Check the status of all planes.");
		System.out.println("2. Show all available planes.");
		System.out.println("3. Add a plane to the DB.");
		System.out.println("4. Remove plane from DB.");
		System.out.println("5. Update status of a plane.");
		System.out.println("6. Exit.");
		System.out.println("Select option:");
		
		BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
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
		case 2:   available()  ;break;
		case 3:   add();       ;break;
		case 4:   remove();    ;break;
		case 5:   update();    ;break;
		case 6:   exit();      ;break;
		}
	}
	public void status(){
		
		PlaneManager mgr=new PlaneManager();
		System.out.println("***************************************************************************************");
		System.out.format("%15s||%10s||%8s||%10s||%15s||%8s\n","NAME","TAILNUMBER","CAPACITY","PASSENGERS","DESTINATION","READY");
		List<Plane> planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}
		
	}
	
	public void available(){
		
	}
	public void add(){
		
	}
	public void remove(){
		
	}
	
	public void update(){
		
	}
	
	public void exit(){
		
	}
}
