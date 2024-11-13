package com.fdb.vanguard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fdb.vanguard.model.Vehicle;
import com.fdb.vanguard.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	//create person
		public Vehicle createVehicle(Vehicle vehicle) {
			return vehicleRepository.save(vehicle);
		}

		
		//List All Person
		public List<Vehicle> listVehicle(){
			return vehicleRepository.findAll();
		}
		
		//Buscar pelo Id
		public Optional<Vehicle> findVehicleId (Long id){
			return vehicleRepository.findById(id);
		}
		
		//Atualizar Person
		public Vehicle atualizarVehicle (Long id, Vehicle vehicleAtualizada) {
			if(vehicleRepository.existsById(id)) {
				vehicleAtualizada.setId(id);
				return vehicleRepository.save(vehicleAtualizada);
			}
			return null;
		}
		
		//Excluir pessoa
		public boolean excluirVehicle(Long Id) {
			if(vehicleRepository.existsById(Id)) {
				vehicleRepository.deleteById(Id);
				return true ;
			}
			return false;
		}
}
