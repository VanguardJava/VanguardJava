package com.fdb.vanguard.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table (name = "Vehicle")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor 
public class Vehicle {

	@Id
	@GeneratedValue
	private Long id;
	private Long chassi;
	private Integer placa;
	private String marca;
	private String modelo;
	private Date anoFabricacao;
	private Date anoModelo;
	private String cor;
	private Float valor;
	
}
