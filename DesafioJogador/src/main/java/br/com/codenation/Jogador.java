package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
	Long id;
	Long idTime;
	String nome;
	LocalDate dataNascimento;
	Integer nivelHabilidade;
	BigDecimal salario;


	public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		this.id = id;
		this.idTime= idTime;
		this.nome = nome;
		this.dataNascimento = dataNascimento;		
		if (nivelHabilidade < 0 || nivelHabilidade > 100) {
			this.nivelHabilidade = 0;
		} else {
			this.nivelHabilidade = nivelHabilidade;
		}
		this.salario = salario; 
	}
	
	public Long getIdTime() {
		return this.idTime;
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public LocalDate getdataNascimento() {
		return this.dataNascimento;
	}

	public int getNivelHabilidade() {
		return this.nivelHabilidade;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}
	

}
