package pl.edu.pjwstk.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class USelector {

	
	public USelector() throws IOException, SQLException{
		
		selector();
	}
	public void selector() throws IOException, SQLException {
		
		System.out.println("*********************************************");
		System.out.println("Welcome to the airport management application.");
		System.out.println("Please select operating mode:");
		System.out.println("1. Administrator.");
		System.out.println("2. User.");
		System.out.println("3. Exit.");
		
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
		case 1:   new UAdmin();   ;break;
		case 2:   new UUser();    ;break;
		case 3:   exit();         ;break;
		default: System.out.println("Invalid number.");
		         selector();      ;break;
		}
		
	}
	public void exit(){
		
		System.out.println("Exiting application.");
		System.exit(0);
		
	}
	

}
