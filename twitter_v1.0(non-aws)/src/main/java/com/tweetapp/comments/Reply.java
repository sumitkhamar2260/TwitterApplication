package com.tweetapp.comments;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Reply")
public class Reply {

	LocalDateTime localDate = LocalDateTime.now();
	
	@Id
	private String rid = UUID.randomUUID().toString();
	private String tid;
	private String rname;
	private String reply;
	private LocalDateTime date = localDate;
	
	public Reply() {
	}

	public Reply(String rid, String tid, String rname, String reply, LocalDateTime date) {
		super();
		this.rid = rid;
		this.tid = tid;
		this.rname = rname;
		this.reply = reply;
		this.date = date;
	}
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	

	@Override
	public String toString() {
		return "Comments [rid=" + rid + ", tid=" + tid + ", rname=" + rname + ", reply=" + reply + ", date=" + date
				+ "]";
	}
	
	
	

	
}
