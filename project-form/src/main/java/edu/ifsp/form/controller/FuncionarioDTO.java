package edu.ifsp.form.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioDTO {
	
	@NotBlank(message="Este campo não pode estar em branco.")
	private String nome;
	
	@Email(message="O e-mail deve ser válido.")
	private String email;
	
	@Min(0)
	@Max(130)
	private Integer idade;
	
	private String fone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String telefone) {
		this.fone = telefone;
	}
}
