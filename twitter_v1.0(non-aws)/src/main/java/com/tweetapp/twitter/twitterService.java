package com.tweetapp.twitter;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.tweetapp.userDetails.UserRepository;
import com.tweetapp.userDetails.Users;

@Service
public class twitterService {

	@Autowired
	private TwitterRepository tweetrepo;
	
	@Autowired
	private UserRepository userrepo;
	
	
	public String sharetweet(String uname, twitterDatabase t) {
		Users user = new Users();
		user = userrepo.findByuname(uname);
		if(user==null)
		{
			return "No such user available";
		}
		else
		{
			System.out.println(t.getTid());
			tweetrepo.save(t);
			return t.getTid();
		}
	}
	public twitterDatabase findbytweetid(String tid) {
		twitterDatabase a = tweetrepo.findbytid(tid);
		return a;
	}
	
	
	public List<twitterDatabase> show() {
		List<twitterDatabase> a = tweetrepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
		return a;
	}
	
	public List<twitterDatabase> showtweetsbyusername(String uname) {
		List<twitterDatabase> tweetsuname = tweetrepo.getTweetsByUname(uname,Sort.by(Sort.Direction.DESC, "date"));
		if(tweetsuname.isEmpty()) {
			return null;
		}
		else
		{
			return tweetsuname;
		}
	}
	
	public String deletetweet(String uname, String tid) {
		twitterDatabase a = tweetrepo.deletetweet1(uname,tid);
		if(a==null)
		{
			return "No such tweet is available";
		}
		else
		{
			return "Tweet deleted successfully";
		}
	}
	
	public String updatetweet(String uname, String tid, twitterDatabase t) {
		twitterDatabase a = tweetrepo.updatetweet1(uname,tid);
		if(a==null)
		{
			return "No such tweet is available";
		}
		else
		{
			tweetrepo.deletetweet1(uname,tid);
			tweetrepo.save(t);
			return "Tweet updated successfully";
		}

	}
	
	
	
}
