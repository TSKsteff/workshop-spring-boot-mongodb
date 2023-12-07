package br.univali.whorshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univali.whorshopmongo.domain.User;
import br.univali.whorshopmongo.dto.UserDTO;
import br.univali.whorshopmongo.repository.UserRepository;
import br.univali.whorshopmongo.service.exe.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findALL(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user =  userRepository.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return user;
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = userRepository.findOne(user.getId());
		newUpdate(newUser, user);
		return userRepository.save(newUser);
	}

	private void newUpdate(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}
}
