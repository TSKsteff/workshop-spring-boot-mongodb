package br.univali.whorshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.univali.whorshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{

	@Query("{ '_id' : ?0 }")
	Post findOne( String id);
	
}
