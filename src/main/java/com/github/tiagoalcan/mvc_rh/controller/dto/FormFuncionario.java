package com.github.tiagoalcan.mvc_rh.controller.dto;

import com.github.tiagoalcan.mvc_rh.model.Cargo;
import com.github.tiagoalcan.mvc_rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class FormFuncionario {
	private Long id;
	private String nome;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private BigDecimal salario;
	private Long idCargo;

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

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public FormFuncionario toForm(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.dataEntrada = funcionario.getDataEntrada();
		this.dataSaida = funcionario.getDataSaida();
		this.salario = funcionario.getSalario();
		this.idCargo = Optional.ofNullable(funcionario.getCargo())
				.map(c -> c.getId())
				.orElse(null);
		return this;
	}

	public Funcionario toModel(Cargo cargo) {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(this.getId());
		funcionario.setNome(this.getNome());
		funcionario.setDataEntrada(this.getDataEntrada());
		funcionario.setDataSaida(this.getDataSaida());
		funcionario.setCargo(cargo);
		funcionario.setSalario(this.getSalario());
		return funcionario;
	}

}
