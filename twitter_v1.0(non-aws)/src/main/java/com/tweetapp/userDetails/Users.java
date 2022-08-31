package com.tweetapp.userDetails;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document("Users")
public class Users {
	
	@Id
	private UUID uid = UUID.randomUUID();
	
	@NonNull
	@Indexed(unique = true)
	private String uname;
	
	@NonNull
	@Indexed(unique = true)
	private String email;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String password;
	@NonNull
	private String contactNumber;
	
	
	
	public Users() {
	}



	public Users(String uname, String firstName, String lastName, String email, String password,
			String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.uname = uname;
		this.password = password;
		this.contactNumber = contactNumber;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public UUID getUid() {
		return uid;
	}



	public void setUid(UUID uid) {
		this.uid = uid;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", contactNumber=" + contactNumber + "]";
	}
	
	
}
