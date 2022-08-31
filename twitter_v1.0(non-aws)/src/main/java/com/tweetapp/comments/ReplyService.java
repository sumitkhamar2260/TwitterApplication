package com.tweetapp.comments;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.twitter.TwitterRepository;
import com.tweetapp.twitter.twitterDatabase;
import com.tweetapp.userDetails.UserRepository;
import com.tweetapp.userDetails.Users;


@Service

public class ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private TwitterRepository tweetrepo;
	
	@Autowired
	private UserRepository user;
	
	
	public List<Reply> getAll(String tid){
		return replyRepository.getAllBytweetId(tid, Sort.by(Sort.Direction.DESC, "date"));
	}
	
	public String postReply(String rname, String tid, Reply r) {
		twitterDatabase a = tweetrepo.findbytid(tid);
		Users b = user.findByuname(rname);
		if(b==null)
		{
			return ("Reply can not be done. Please register first");
		}
		else if(a==null)
		{
			return ("No such tweet available");
		}
		else
		{
			replyRepository.save(r);
			return ("Reply posted successfully");
		}
	}
	
//	public void deleteComments(long tweetId){
//		
//		List<Comments> c = commentsRepository.getAllBytweetId(tweetId);
//		
//		System.out.print(c);
//		
//		for(int i=0;i<c.size();i++) {
//			commentsRepository.delete(c.get(i));
//		}
//	}

}
