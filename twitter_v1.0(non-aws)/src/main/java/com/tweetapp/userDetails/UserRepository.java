package com.tweetapp.userDetails;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.Query;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{
	
	@Query("{'uname' : ?0}")
	Users findByuname(String uname);
	
	@Query("{'email' : ?0}")
	Users findByemail(String email);
	
	@Query(value="{'uname' : ?0}", delete=true)
	Users DeleteByuname(String uname);
	
	@Query("{'uname':{'$regex':'?0','$options':'i'}}")  
    List<Users> searchByRegex(String str);

}
