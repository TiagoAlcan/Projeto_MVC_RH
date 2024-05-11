package com.github.tiagoalcan.mvc_rh.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Long> {

	@Column(name = "nome_funcionario", nullable = false, length = 60)
	private String nome;

	@Column(nullable = true, columnDefinition = "DATE")
	private LocalDateTime dataEntrada;

	@Column(columnDefinition = "DATE")
	private LocalDate dataSaida;

	@Column(nullable = true, columnDefinition = "NUMERIC(15,2)")
	private BigDecimal salario;

	@ManyToOne
	@JoinColumn(name = "cargo_id_fk", nullable = true)
	private Cargo cargo;
	
	@OneToOne
	@JoinColumn(name = "endereco_id_fk", nullable = true)
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
