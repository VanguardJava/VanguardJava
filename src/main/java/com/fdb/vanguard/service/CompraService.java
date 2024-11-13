package com.fdb.vanguard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdb.vanguard.model.Compra;
import com.fdb.vanguard.model.Person;
import com.fdb.vanguard.model.User;
import com.fdb.vanguard.model.Vehicle;
import com.fdb.vanguard.repository.CompraRepository;
import com.fdb.vanguard.repository.PersonRepository;
import com.fdb.vanguard.repository.UserRepository;
import com.fdb.vanguard.repository.VehicleRepository;


@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Compra realizarCompra(Long clientId, Long vendedorId, Long carroId) {
		
		Person person = personRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		User user = userRepository.findById(vendedorId).orElseThrow(()-> new RuntimeException("Vendedor não encontrado")); 
		Vehicle vehicle = vehicleRepository.findById(carroId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		
		Compra compra = new Compra();
		compra.setClientId(person.getId());
		compra.setVendedorId(user.getId());
		compra.setCarroId(vehicle.getId());
		compra.setValorTotal(vehicle.getValor());
		
		return compraRepository.save(compra);
	}
}
