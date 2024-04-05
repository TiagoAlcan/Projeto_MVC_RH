package com.github.tiagoalcan.mvc_rh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Departamento {
	@Id
	private Long id;	
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
