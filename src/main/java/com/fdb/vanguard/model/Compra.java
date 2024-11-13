package com.fdb.vanguard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	private Long clientId;
	private Long vendedorId;
	private Long carroId;
	private Float valorTotal;

}
