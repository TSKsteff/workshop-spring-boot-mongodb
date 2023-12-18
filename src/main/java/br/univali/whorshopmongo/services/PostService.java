package br.univali.whorshopmongo.services;

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
	
}
