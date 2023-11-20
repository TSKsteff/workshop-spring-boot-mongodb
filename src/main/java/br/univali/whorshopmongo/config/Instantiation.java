package br.univali.whorshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.univali.whorshopmongo.domain.User;
import br.univali.whorshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User steff = new User(null,"Steff Kerry Toussaint","steffkerr@gmail.com");
		User piard = new User(null,"Piard Ritchy Toussaint","piardritch@gmail.com");
		User ted = new User(null,"Ted Akim Toussaint","tedaki@gmail.com");
		
		userRepository.saveAll(Arrays.asList(steff,piard,ted));
	}

}
