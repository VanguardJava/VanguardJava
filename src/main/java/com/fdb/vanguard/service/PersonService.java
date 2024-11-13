package com.fdb.vanguard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdb.vanguard.model.Person;
import com.fdb.vanguard.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	//create person
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	
	//List All Person
	public List<Person> listPerson(){
		return personRepository.findAll();
	}
	
	//Buscar pelo Id
	public Optional<Person> findPersonId (Long id){
		return personRepository.findById(id);
	}
	
	//Atualizar Person
	public Person atualizarPerson (Long id, Person personAtualizada) {
		if(personRepository.existsById(id)) {
			personAtualizada.setId(id);
			return personRepository.save(personAtualizada);
		}
		return null;
	}
	
	//Excluir pessoa
	public boolean excluirPerson(Long Id) {
		if(personRepository.existsById(Id)) {
			personRepository.deleteById(Id);
			return true ;
		}
		return false;
	}
}
