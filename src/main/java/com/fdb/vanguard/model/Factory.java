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

@Table (name = "factory")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Factory {
	
	@Id
	@GeneratedValue
	
	private Long id;
	private String cnpj;
	private String razaoSocial;
	private String marca;
	private String contato;
	private Integer tel;
	private Integer cel;
	
}
