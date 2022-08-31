package com.tweetapp.likes;


import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LikesRepository extends MongoRepository<Likes, String> {
	
	@Query(value ="{tid: ?0}", count=true)           
	Integer getLikesCount(String tid);

	@Query(value ="{lname: ?0, tid: ?1}", delete=true)           
	Likes deleteByuname(String lname, String tid);
	
	@Query(value ="{lname: ?0, tid: ?1}}")
    List<Likes> preventduplication(String lname, String tid);
}
