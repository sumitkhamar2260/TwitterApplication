package com.tweetapp.comments;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReplyRepository extends MongoRepository<Reply, String> {
	
	@Query("{tid : ?0}")
	List<Reply> getAllBytweetId(String tid, Sort sort);
	
	@Query(value="{uname: ?0, tid: ?1}}")
    Reply checktweetavail(String uname, String tid);

	
}
