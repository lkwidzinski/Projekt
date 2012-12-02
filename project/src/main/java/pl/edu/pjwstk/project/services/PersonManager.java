package pl.edu.pjwstk.project.services;

import java.util.List;

import pl.edu.pjwstk.project.objects.Person;
import pl.edu.pjwstk.project.objects.PersonInterface;

public class PersonManager implements PersonInterface{
	
	private DBmanager db=DBmanager.getInstance();

	@Override
	public boolean addPerson(Person obj) {
		
		return db.addPerson(obj);
	}

	@Override
	public boolean removePerson(Person obj) {
		
		return db.removePerson(obj);
	}

	@Override
	public List<Person> getAll() {
	
		return db.getAllPersons();
	}

}
