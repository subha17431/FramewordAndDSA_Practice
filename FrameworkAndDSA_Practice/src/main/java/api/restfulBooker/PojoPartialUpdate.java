package api.restfulBooker;

public class PojoPartialUpdate {
	
	private String firstname;
	private String lastname;
	
	public PojoPartialUpdate(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public PojoPartialUpdate() {}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
}
