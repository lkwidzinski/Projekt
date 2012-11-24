package pl.edu.pjwstk.project.domain;

import pl.edu.pjwstk.project.objects.Plane;
import pl.edu.pjwstk.project.services.PlaneManager;

public class ExamplePlaneMaker {
	
	public ExamplePlaneMaker(){
		
		Plane pl0=new Plane("nazwa2","tail",2,2,"dest2",true);
		Plane pl1=new Plane("nazwa","tail",1,1,"dest",true);
		Plane pl2=new Plane("nazwa2","tail",2,2,"dest2",true);
		Plane pl3=new Plane("nazwa","tail",1,1,"dest",true);
		Plane pl4=new Plane("nazwa2","tail",2,2,"dest2",true);
		Plane pl5=new Plane("nazwa","tail",1,1,"dest",true);
		Plane pl6=new Plane("nazwa2","tail",2,2,"dest2",true);
		Plane pl7=new Plane("nazwa","tail",1,1,"dest",true);
		Plane pl8=new Plane("nazwa2","tail",2,2,"dest2",true);
		Plane pl9=new Plane("nazwa2","tail",2,2,"dest2",true);
		
		PlaneManager mgr=new PlaneManager();
		
		mgr.addPlane(pl0);
		mgr.addPlane(pl1);
		mgr.addPlane(pl2);
		mgr.addPlane(pl3);
		mgr.addPlane(pl4);
		mgr.addPlane(pl5);
		mgr.addPlane(pl6);
		mgr.addPlane(pl7);
		mgr.addPlane(pl8);
		mgr.addPlane(pl9);
	}

}
