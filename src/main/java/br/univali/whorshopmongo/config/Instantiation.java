package br.univali.whorshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.univali.whorshopmongo.domain.Post;
import br.univali.whorshopmongo.domain.User;
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
		
		Post post1 = new Post(null, sdf.parse("31/10/2023"), "Partiu vuagem", "vou para são paulo",steff); 
		Post post2 = new Post(null, sdf.parse("07/12/2023"), "Partiu ferias", "vou para tirolesa",ted); 
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		userRepository.saveAll(Arrays.asList(steff,piard,ted));
	}

}
