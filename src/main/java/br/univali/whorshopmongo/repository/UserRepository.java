package br.univali.whorshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.univali.whorshopmongo.domain.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{

}
