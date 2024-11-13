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

import com.fdb.vanguard.model.Person;
import com.fdb.vanguard.service.PersonService;

@RestController
@RequestMapping ("/Person")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	//Create Person
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		Person newPerson = personService.createPerson(person);
		return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
	}
	
	//List All Person
	@GetMapping
	public ResponseEntity<List<Person>>listPerson(){
		List<Person> person = personService.listPerson();
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	// buscar pelo id
	public ResponseEntity<Person> findPersonId(@PathVariable Long id){
		Optional <Person> person = personService.findPersonId(id);
		if (person.isPresent()) {
			return ResponseEntity.ok(person.get());
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	// Atualizar pessoa
	 @PutMapping("/{id}")
	 public ResponseEntity<Person> atualizarPerson(@PathVariable Long id, @RequestBody 
	Person person) {
	 Person personAtualizada = personService.atualizarPerson(id, person);
	 return personAtualizada != null ? ResponseEntity.ok(personAtualizada) : 
	ResponseEntity.notFound().build();
	 }
	 
	// Excluir pessoa
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> excluirPerson(@PathVariable Long id) {
	 return personService.excluirPerson(id) ? ResponseEntity.noContent().build() : 
	ResponseEntity.notFound().build();
	 }

}
