package pl.edu.pjwstk.project.ui;

public class UAdmin implements UInterface{

	
	public UAdmin(){
		
		
		System.out.println("*********************************************");
		System.out.println("Welcome to the airport administrator access:");
		System.out.println("1. Check the status of all planes.");
		System.out.println("2. Show all available planes.");
		System.out.println("3. Add a plane to the DB.");
		System.out.println("4. Remove plane from DB.");
		System.out.println("5. Update status of a plane.");
		System.out.println("6. Exit.");
		
	}
	
	public void selector(int x){
		
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
