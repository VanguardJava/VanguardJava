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

@Table (name = "Person")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String cpf;
	private String adress;
	private Integer tel;
	private Integer cel;
	private Float renda;
	
	

}
