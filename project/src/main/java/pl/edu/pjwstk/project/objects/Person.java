package pl.edu.pjwstk.project.objects;

public class Person {
	
	String firstName;
	String lastName;
	int pesel;
	String additionalInfo;
	
	public Person(String firstName,String lastName, int pesel, String additionalInfo){
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.pesel=pesel;
		this.additionalInfo=additionalInfo;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String toString(){
		
		String s=String.format("%20s||%20s||%20s||%40s\n",firstName,lastName,pesel,additionalInfo);
		
		return s;
	}
	
}
