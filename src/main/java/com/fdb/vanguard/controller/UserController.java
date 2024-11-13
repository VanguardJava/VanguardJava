package com.fdb.vanguard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fdb.vanguard.model.User;
import com.fdb.vanguard.service.UserService;

@RestController
@RequestMapping ("/User")
public class UserController {
	@Autowired
	private UserService userService;

	//Create Person
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User newUser = userService.createUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	//List All Person
	@GetMapping
	public ResponseEntity<List<User>>listUser(){
		List<User> user = userService.listUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	// buscar pelo id
		public ResponseEntity<User> findUserId(@PathVariable Long id){
			Optional <User> user = userService.findUserId(id);
			if (user.isPresent()) {
				return ResponseEntity.ok(user.get());
			} else {
				return ResponseEntity.notFound().build();
			}	
		}
		
		// Atualizar pessoa
		 @PutMapping("/{id}")
		 public ResponseEntity<User> atualizarUser(@PathVariable Long id, @RequestBody 
		User user) {
		 User userAtualizada = userService.atualizarUser(id, user);
		 return userAtualizada != null ? ResponseEntity.ok(userAtualizada) : 
		ResponseEntity.notFound().build();
		 }
		 
		// Excluir pessoa
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> excluirUser(@PathVariable Long id) {
		 return userService.excluirUser(id) ? ResponseEntity.noContent().build() : 
		ResponseEntity.notFound().build();
		 }


}
