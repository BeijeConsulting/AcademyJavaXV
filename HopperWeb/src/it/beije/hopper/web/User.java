package it.beije.hopper.web;

public class User {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ email : ").append(this.email)
				.append(", lastName : ").append(this.lastName)
				.append(", firstName : ").append(this.firstName)
				.append(", password : ").append(this.password)
				.append(" }");
		
		return builder.toString();
	}
}
