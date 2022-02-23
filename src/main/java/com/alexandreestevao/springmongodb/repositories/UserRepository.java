package com.alexandreestevao.springmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alexandreestevao.springmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	//User save(Optional<User> newObj);
	
	
	
}
