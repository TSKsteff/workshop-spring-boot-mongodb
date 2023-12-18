package br.univali.whorshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.univali.whorshopmongo.domain.Post;
import br.univali.whorshopmongo.domain.User;
import br.univali.whorshopmongo.dto.AuthorDTO;
import br.univali.whorshopmongo.dto.CommentDTO;
import br.univali.whorshopmongo.repository.PostRepository;
import br.univali.whorshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User steff = new User(null,"Steff Kerry Toussaint","steffkerr@gmail.com");
		User piard = new User(null,"Piard Ritchy Toussaint","piardritch@gmail.com");
		User ted = new User(null,"Ted Akim Toussaint","tedaki@gmail.com");
		
		userRepository.saveAll(Arrays.asList(steff,piard,ted));
		
		Post post1 = new Post(null, sdf.parse("31/10/2023"), "Partiu vuagem", "vou para são paulo", new AuthorDTO(steff)); 
		Post post2 = new Post(null, sdf.parse("07/12/2023"), "Partiu ferias", "vou para tirolesa", new AuthorDTO(ted)); 
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(ted));
		CommentDTO c2 = new CommentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(steff));
		CommentDTO c3 = new CommentDTO("Tenha um otimo dia", sdf.parse("24/03/2018"), new AuthorDTO(steff));
		
		post1.getComments().addAll(Arrays.asList(c2,c3));
		post2.getComments().addAll(Arrays.asList(c1));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		steff.getPosts().add(post1);
		ted.getPosts().add(post2);
		userRepository.saveAll(Arrays.asList(steff,ted));
		
	}

}
