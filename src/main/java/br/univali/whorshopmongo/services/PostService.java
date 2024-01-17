package br.univali.whorshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univali.whorshopmongo.domain.Post;
import br.univali.whorshopmongo.repository.PostRepository;
import br.univali.whorshopmongo.service.exe.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;


	public Post findById(String id) {
		Post post =  postRepository.findOne(id);
		if(post == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return post;
	}
	 
	public List<Post> findByTitle(String text){
		return postRepository.searchByTitle(text);
	}
	
	public List<Post> fulSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
	public List<Post> searchByTitle(String text){
		return postRepository.searchByTitle(text);
	}
}
