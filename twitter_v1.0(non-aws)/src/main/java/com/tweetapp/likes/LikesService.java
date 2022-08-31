package com.tweetapp.likes;

import java.util.List;
//import java.util.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.twitter.TwitterRepository;
import com.tweetapp.twitter.twitterDatabase;
import com.tweetapp.userDetails.UserRepository;
import com.tweetapp.userDetails.Users;

@Service
public class LikesService {
	
	@Autowired
	private LikesRepository likesRepository;
	
	@Autowired
	private TwitterRepository tweetrepo;
	
	@Autowired
	private UserRepository user;
	
//	public Likes getLikesCount(long id) {
//		return likesRepository.getLikeById(id);
//	}
	
	public String getAll(String tid) {
		if(tid == null)
		{
			return "0";
		}
		else
		{
			return likesRepository.getLikesCount(tid).toString();
		}
	}
	
	public String updateLikes(String uname, String tid, Likes likes) {
		System.out.println("abc");
		twitterDatabase a = tweetrepo.findbytid(tid);
		Users b = user.findByuname(uname);
		List<Likes> c = likesRepository.preventduplication(uname, tid);
		//System.out.println("likkekeeeeeeekkekeee " + c);
		if(b==null)
		{
			return ("Like can not be done. Please register first");
		}
		else if(a==null)
		{
			return ("No such tweet available");
		}
		else
		{
			if(c.isEmpty()) 
			{
				likesRepository.save(likes);
				Integer like = likesRepository.getLikesCount(tid);
				return (like.toString());
			}
			else 
			{
				likesRepository.deleteByuname(uname, tid);
				Integer like = likesRepository.getLikesCount(tid);
				return (like.toString());
			}
		
		}
			
	}
	
//	public Likes deletelike(String lname, String tid) {
//		System.out.println("delete");
//		return likesRepository.deleteByuname(lname, tid);
//	}
	
//	public boolean check(long tweetId, String loginId) {
//		List<LikeCheck> l = likeCheckRepo.findAll();
//		
//		for(int i=0;i<l.size();i++) {
//			if(tweetId==l.get(i).getTweetId() && loginId.equals(l.get(i).getLoginId())) {
//				return true;
//			}
//				
//		}
//		return false;
//	}

}
