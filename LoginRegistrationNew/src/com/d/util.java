package com.d;

public class util {

	private String Username; 			
	private String Gender;			
	private String EmailId; 		
	private String Country;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	@Override
	public String toString() {
		return "util [Username=" + Username + ", Gender=" + Gender + ", EmailId=" + EmailId + ", Country=" + Country
				+ "]";
	}
	
	
}
