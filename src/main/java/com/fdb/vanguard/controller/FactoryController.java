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

import com.fdb.vanguard.model.Factory;
import com.fdb.vanguard.model.Person;
import com.fdb.vanguard.service.FactoryService;

@RestController
@RequestMapping ("/Factory")

public class FactoryController {

	@Autowired
	private FactoryService factoryService;

	//Create Vehicle
	@PostMapping
	public ResponseEntity<Factory> createFactory(@RequestBody Factory factory){
		Factory newFactory = factoryService.createFactory(factory);
		return new ResponseEntity<>(newFactory, HttpStatus.CREATED);
	}
	
	//List All Vehicle
	@GetMapping
	public ResponseEntity<List<Factory>>listFactory(){
		List<Factory> factory = factoryService.listFactory();
		return new ResponseEntity<>(factory, HttpStatus.OK);
	}
	
	// buscar pelo id
		public ResponseEntity<Factory> findFactoryId(@PathVariable Long id){
			Optional <Factory> factory = factoryService.findFactoryId(id);
			if (factory.isPresent()) {
				return ResponseEntity.ok(factory.get());
			} else {
				return ResponseEntity.notFound().build();
			}	
		}
		
		// Atualizar pessoa
		 @PutMapping("/{id}")
		 public ResponseEntity<Factory> atualizarFactory(@PathVariable Long id, @RequestBody 
		Factory factory) {
		 Factory factoryAtualizada = factoryService.atualizarFactory(id, factory);
		 return factoryAtualizada != null ? ResponseEntity.ok(factoryAtualizada) : 
		ResponseEntity.notFound().build();
		 }
		 
		// Excluir pessoa
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> excluirFactory(@PathVariable Long id) {
		 return factoryService.excluirFactor(id) ? ResponseEntity.noContent().build() : 
		ResponseEntity.notFound().build();
		 }

}
