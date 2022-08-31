package com.tweetapp.comments;


import java.util.List;
//import java.util.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class ReplyController {
	
	@Autowired
	private ReplyService rservice;
	
	@GetMapping("/reply/{tid}")
	public List<Reply> getAll(@PathVariable String tid){
		return rservice.getAll(tid);
	}
	
	@PostMapping("/tweets/{rname}/reply/{tid}")
	public String postComment(@PathVariable String rname, @PathVariable String tid, @RequestBody Reply rep){
		
		String postedreply = rservice.postReply(rname, tid, rep);
			
		return postedreply;
	}
	
//	@DeleteMapping("/comments/{tweetId}/delete")
//	public ResponseEntity<Void> deleteComment(@PathVariable long tweetId){
//		commentsService.deleteComments(tweetId);
//		return ResponseEntity.noContent().build();
//	}

}
