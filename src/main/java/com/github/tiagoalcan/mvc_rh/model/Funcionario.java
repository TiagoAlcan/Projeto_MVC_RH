package com.github.tiagoalcan.mvc_rh.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Long>{
	
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "NUMERIC(15,2)")
	private BigDecimal salario;
	
	@ManyToOne
	@JoinColumn(name = "id_cargo_fk", nullable = false)
	private Cargo cargo;
	
	@OneToOne
	@JoinColumn(name = "id_endereco_fk", nullable = false)
	private Endereco endereco;

	public LocalDate getData_entrada() {
		return dataEntrada;
	}

	public void setData_entrada(LocalDate data_entrada) {
		this.dataEntrada = data_entrada;
	}

	public LocalDate getData_saida() {
		return dataSaida;
	}

	public void setData_saida(LocalDate data_saida) {
		this.dataSaida = data_saida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
