package com.fdb.vanguard.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table (name ="Compras")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Compra {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Person client;
	@ManyToOne
	private User vendedor;
	@ManyToMany
	private List<Vehicle> veiculo;

}
