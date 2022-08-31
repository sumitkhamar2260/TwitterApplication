package com.tweetapp.likes;

//import java.util.String;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Likes")
public class Likes {
	
	@Id
	private String lid = UUID.randomUUID().toString();
	private String tid;
	private String lname;
		
	public Likes() {
	}
	
	public Likes(String lid, String tid, String lname) {
		super();
		this.lid = lid;
		this.tid = tid;
		this.lname = lname;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Likes [lid=" + lid + ", tid=" + tid + ", lname=" + lname + "]";
	}

	
	

}
