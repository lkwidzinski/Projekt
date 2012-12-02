package pl.edu.pjwstk.project.objects;

import java.util.List;

public interface PersonInterface {
	
	boolean addPerson(Person obj);
	boolean removePerson(Person obj);
	List<Person> getAll();

}
