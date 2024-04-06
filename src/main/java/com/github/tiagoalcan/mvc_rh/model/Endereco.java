package com.github.tiagoalcan.mvc_rh.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity<Long> {

	@Column(nullable = false, length = 100)
	private String bairro;

	@Column(nullable = false, length = 9)
	private Long cep;

	@Column(nullable = false, length = 50)
	private String cidade;

	@Column(length = 15)
	private String complemento;

	@Column(length = 50)
	private String logradouro;

	@Column(length = 5)
	private Long numero;
	
	@Column(nullable = false, length = 2)
	private String uf;


	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	

}
