import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	
	private String firstName;
	private String lastName;
	transient private Thread myThread;
	
	// Generated constructors
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.myThread=new Thread();
	}
	// generated to string 
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	// generated getter setter
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
	
		
}
