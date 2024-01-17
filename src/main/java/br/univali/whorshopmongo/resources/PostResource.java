package br.univali.whorshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.univali.whorshopmongo.domain.Post;
import br.univali.whorshopmongo.resources.util.URL;
import br.univali.whorshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	
	@RequestMapping(value = "{id}",  method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value = "titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam (value="text", defaultValue = "") String text){
		text = URL.decodePram(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam (value="text", defaultValue = "") String text,
			@RequestParam (value="minDate", defaultValue = "") String minDate,
			@RequestParam (value="maxDate", defaultValue = "") String maxDate){
		
		text = URL.decodePram(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.fulSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "searchByTitle", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> searchByTitle(@RequestParam String text){
		List<Post> list = postService.searchByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
