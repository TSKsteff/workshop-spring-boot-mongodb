package br.univali.whorshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univali.whorshopmongo.domain.User;
import br.univali.whorshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findALL(){
		return userRepository.findAll();
	}
}
