package com.tweetapp.twitter;


import java.util.List;
import java.util.UUID;

//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class twitterController {
	
//	@Autowired
//	private TwitterRepository repo;
	
	@Autowired
	private twitterService tweetService;
	
	
	@PostMapping("/tweets/{uname}/add")
	public String sharetweet(@PathVariable String uname, @RequestBody twitterDatabase t){
		String a = tweetService.sharetweet(uname, t);
		return a;
	}
	
	@GetMapping("/tweets/all")
	public List<twitterDatabase> show() {
		List<twitterDatabase> a = tweetService.show();
		return a;
	}
	
//	@GetMapping("/tweets/{tid}")
//	public String gettweet(@PathVariable String tid) {
//		twitterDatabase a = tweetService.findbytweetid(tid);
//		return a.getTweet();
//	}
	
	@GetMapping("/tweet/{tid}")
	public twitterDatabase gettweet1(@PathVariable String tid) {
		return tweetService.findbytweetid(tid);
	}
	
	@DeleteMapping("/tweets/{uname}/delete/{tid}")
	public String deletetweet(@PathVariable String uname,@PathVariable String tid){
		String a=tweetService.deletetweet(uname,tid);
		return a;
	}
	
	@GetMapping("/tweets/{uname}")
	public List<twitterDatabase> showByUsername(@PathVariable String uname){
		List<twitterDatabase> unametweet = tweetService.showtweetsbyusername(uname);
//		System.out.println(unametweet);
		return unametweet;
	}
	
	
	
	@PutMapping("/tweets/{uname}/update/{tid}")
	public String updatetweet(@PathVariable String uname,@PathVariable String tid, @RequestBody twitterDatabase t){
		String a=tweetService.updatetweet(uname,tid,t);
		return a;
	}
	
	
	

}
