package com.cadastrorh.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity                                
@Table(name = "tb_cadastro")    // Criando a tabela Cadastro
public class CadastroFuncionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Nome é obrigatório!")
	private String nome;
	
	@NotBlank(message = "O atributo Nome é obrigatório!")
	private String email;
	
	@NotBlank(message = "O atributo Nome é obrigatório!")
	private String telefone;
	
	@NotBlank(message = "O atributo Nome é obrigatório!")
	private String dt_contratacao;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDt_contratacao() {
		return dt_contratacao;
	}

	public void setDt_contratacao(String dt_contratacao) {
		this.dt_contratacao = dt_contratacao;
	}

}
