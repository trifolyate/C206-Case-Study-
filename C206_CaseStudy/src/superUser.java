
public class superUser {
	private String username;
	private String password;
	private String name;
	private String designation;

	public superUser(String username, String password, String name, String designation) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.designation = designation;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
