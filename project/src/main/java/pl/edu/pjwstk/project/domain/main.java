package pl.edu.pjwstk.project.domain;

import java.util.List;

import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.objects.PlaneInterface;
import pl.edu.pjwstk.project.services.PlaneManager;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Plane pl=new Plane("nazwa",1,1,1,"dest",true);
		Plane p2=new Plane("nazwa2",2,2,2,"dest2",true);
		PlaneManager mgr=new PlaneManager();
		mgr.addPlane(pl);
		mgr.addPlane(p2);
		
		List<Plane> planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}
		
		mgr.addPassenger(p2);
		mgr.removePassenger(pl);
		mgr.removeAllPassengers(p2);
		planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}

	}

}
