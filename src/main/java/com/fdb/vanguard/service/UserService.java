package com.fdb.vanguard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdb.vanguard.model.User;
import com.fdb.vanguard.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	//Create User
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//List All User
	public List<User> listUser(){
		return userRepository.findAll();
	}
	
	//Buscar pelo Id
		public Optional<User> findUserId (Long id){
			return userRepository.findById(id);
		}
		
		//Atualizar Person
		public User atualizarUser (Long id, User userAtualizada) {
			if(userRepository.existsById(id)) {
				userAtualizada.setId(id);
				return userRepository.save(userAtualizada);
			}
			return null;
		}
		
		//Excluir pessoa
		public boolean excluirUser(Long Id) {
			if(userRepository.existsById(Id)) {
				userRepository.deleteById(Id);
				return true ;
			}
			return false;
		}
}
