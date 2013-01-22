package pl.edu.pjwstk.project.services;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import pl.edu.pjwstk.project.objects.Person;
import pl.edu.pjwstk.project.objects.Plane;

public class DBmanagerTEST {

	
	private DBmanager db=DBmanager.getInstance();
	@Test
	public void addPlaneTest() {
		assertFalse(db.addPlane(new Plane(null, null, 0, 0, null, false)));
	}
	@Test
	public void removePlaneTest() {
		assertFalse(db.removePlane(new Plane(null, null, 0, 0, null, false)));
	}
	@Test
	public void getAllTest() {
		assertNotNull(db.getAll());
	}

}
