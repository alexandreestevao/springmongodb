package com.alexandreestevao.springmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandreestevao.springmongodb.domain.User;
import com.alexandreestevao.springmongodb.dto.UserDTO;
import com.alexandreestevao.springmongodb.repositories.UserRepository;
import com.alexandreestevao.springmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User updateById(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		User user = newObj.get();
		
		updateData(user, obj);
		return repo.save(user);
	}
	
	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
