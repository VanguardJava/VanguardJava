package com.fdb.vanguard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdb.vanguard.model.Compra;
import com.fdb.vanguard.service.CompraService;

@RestController
@RequestMapping ("/Compras")
public class CompraController {
	
	@Autowired
	private CompraService compraservice;
	
	@PostMapping
	public Compra realizarCompra(@RequestBody Long clientId, @RequestBody Long vendedorId, @RequestBody Long carroId) {
		return compraservice.realizarCompra(clientId, vendedorId, carroId);
	}
}
