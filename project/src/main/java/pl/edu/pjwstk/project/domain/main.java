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
	
		
		
		PlaneManager mgr=new PlaneManager();
		List<Plane> planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}

		planes=mgr.getAll();
		for(Plane p : planes){
			System.out.println(p);
		}

	}

}
