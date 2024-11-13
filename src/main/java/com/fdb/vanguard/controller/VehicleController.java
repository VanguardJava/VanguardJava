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


import com.fdb.vanguard.model.Vehicle;
import com.fdb.vanguard.service.VehicleService;

@RestController
@RequestMapping ("/Vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	//Create Vehicle
	@PostMapping
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
		Vehicle newVehicle = vehicleService.createVehicle(vehicle);
		return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
	}
	
	//List All Vehicle
	@GetMapping
	public ResponseEntity<List<Vehicle>>listVehicle(){
		List<Vehicle> vehicle = vehicleService.listVehicle();
		return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}
	
	// buscar pelo id
		public ResponseEntity<Vehicle> findVehicleId(@PathVariable Long id){
			Optional <Vehicle> vehicle = vehicleService.findVehicleId(id);
			if (vehicle.isPresent()) {
				return ResponseEntity.ok(vehicle.get());
			} else {
				return ResponseEntity.notFound().build();
			}	
		}
		
		// Atualizar pessoa
		 @PutMapping("/{id}")
		 public ResponseEntity<Vehicle> atualizarVehicle(@PathVariable Long id, @RequestBody 
		Vehicle vehicle) {
		 Vehicle vehicleAtualizada = vehicleService.atualizarVehicle(id, vehicle);
		 return vehicleAtualizada != null ? ResponseEntity.ok(vehicleAtualizada) : 
		ResponseEntity.notFound().build();
		 }
		 
		// Excluir pessoa
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> excluirVehicle(@PathVariable Long id) {
		 return vehicleService.excluirVehicle(id) ? ResponseEntity.noContent().build() : 
		ResponseEntity.notFound().build();
		 }

}
