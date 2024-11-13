package com.fdb.vanguard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdb.vanguard.model.Factory;
import com.fdb.vanguard.repository.FactoryRepository;


@Service
public class FactoryService {

	@Autowired
	private FactoryRepository factoryRepository;

	//create person
		public Factory createFactory(Factory factory) {
			return factoryRepository.save(factory);
		}

		
		//List All Person
		public List<Factory> listFactory(){
			return factoryRepository.findAll();
		}
		
		//Buscar pelo Id
		public Optional<Factory> findFactoryId (Long id){
			return factoryRepository.findById(id);
		}
		
		//Atualizar Person
		public Factory atualizarFactory (Long id, Factory factoryAtualizada) {
			if(factoryRepository.existsById(id)) {
				factoryAtualizada.setId(id);
				return factoryRepository.save(factoryAtualizada);
			}
			return null;
		}
		
		//Excluir pessoa
		public boolean excluirFactor(Long Id) {
			if(factoryRepository.existsById(Id)) {
				factoryRepository.deleteById(Id);
				return true ;
			}
			return false;
		}
}
