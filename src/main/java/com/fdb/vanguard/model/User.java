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

@Table (name ="User")
@Entity
@Getter
@Setter
@ToString 
@AllArgsConstructor
@NoArgsConstructor 

public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
}
