package edu.ifsp.loja.modelo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Cliente {
	@Positive(message = "{cliente.id.positive}")
	private int id;
	
	@Size(min = 2, max = 30, message = "{cliente.nome.size}")
	private String nome;
	
	@Email(message = "{cliente.email}")
	private String email;
	
	private boolean ativo;
	
	public Cliente() {
		
	}

	public Cliente(int id, String nome, boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
