package br.univali.whorshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.univali.whorshopmongo.domain.Post;


@Repository
public interface PostRepository  extends MongoRepository<Post, String>{

	@Query("{ '_id' : ?0 }")
	Post findOne( String id);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchByTitle(String text);
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")   
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
