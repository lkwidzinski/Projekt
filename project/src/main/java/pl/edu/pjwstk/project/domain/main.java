package pl.edu.pjwstk.project.domain;

import pl.edu.pjwstk.project.objects.Plane;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Plane pl=new Plane("nazwa",1,1,1,"dest",true);
		pl.addPlane(pl);
		pl.addPlane(pl);
		

	}

}
