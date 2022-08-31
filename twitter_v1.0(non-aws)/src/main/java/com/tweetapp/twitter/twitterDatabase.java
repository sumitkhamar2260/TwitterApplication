package com.tweetapp.twitter;

//import java.text.DateFormat;
//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.tweetapp.likes.LikesService;

@Document("twitter")
public class twitterDatabase {
	
	LocalDateTime localDate = LocalDateTime.now();
	
	@Id
	private String tid=(UUID.randomUUID()).toString();
	@NonNull
	private String uname;
	@NonNull
	private String tweet;
	@NonNull
	private LocalDateTime date=localDate;
	
	public twitterDatabase() {
		super();
	}
	
	public twitterDatabase(String tid, String uname, String tweet,
			LocalDateTime date) {
		super();
		this.tid = tid;
		this.uname = uname;
		this.tweet = tweet;
		this.date = date;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "twitterDatabase [tid=" + tid + ", uname=" + uname + ", tweet="
				+ tweet + ", date=" + date + "]";
	}


	
	
	
	
	
}
