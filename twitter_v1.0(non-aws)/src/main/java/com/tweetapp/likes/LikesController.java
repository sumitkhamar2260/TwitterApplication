package com.tweetapp.likes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class LikesController {
	
	@Autowired
	private LikesService likesService;
	

	
	@GetMapping("/tweet/likes/{tid}")
	public String getAll(@PathVariable String tid){
		return likesService.getAll(tid);
//		return a;
	}
	
	@PutMapping("/tweet/{uname}/like/{tid}")
	public String updateLikes(@PathVariable String uname,@PathVariable String tid, @RequestBody Likes likes) {
		System.out.println("abc");
		String updatedLikes1 = likesService.updateLikes(uname, tid, likes);	
		System.out.println(updatedLikes1);
		return updatedLikes1;
	}
	
}
