package com.tweetapp.twitter;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends MongoRepository<twitterDatabase, String>{
	 @Query("{uname : ?0}")            
     List<twitterDatabase> getTweetsByUname(String uname, Sort sort);
     
     @Query("{uname : { $regex : ?0 }}")
     List<String> getUsername(String uname1);

     @Query(value="{uname: ?0, tid: ?1}}", delete=true)
     twitterDatabase deletetweet1(String uname, String tid);
     
     @Query(value="{uname: ?0, tid: ?1}}")
     twitterDatabase updatetweet1(String uname, String tid);
     
     @Query("{ tid : ?0}}")
     twitterDatabase findbytid(String tid);

}
