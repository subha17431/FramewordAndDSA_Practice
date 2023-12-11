package api.restfulBooker;

public class PojoLoginCredentials {
	
	private String username;
	private String password;
	
	
	public PojoLoginCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	/*
	 * public void setUsername(String username) {
		LoginCredentials.username = username;
	}
	 */
	


	public String getPassword() {
		return password;
	}

	/*
	 * public void setPassword(String password) {
		LoginCredentials.password = password;
	}
	 */
	
	
	public PojoLoginCredentials() {
		
	}

}
