package com.cadastrorh.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import com.cadastrorh.model.CadastroFuncionario;

public interface CadastroRepository extends JpaRepository<CadastroFuncionario, Long>{
	
	public List<CadastroFuncionario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	public List<CadastroFuncionario> findAllByEmailContainingIgnoreCase(@Param("email") String email);
	
	public List<CadastroFuncionario> findAllByTelefoneContainingIgnoreCase(@Param("telefone") String telefone);
	
	//public List<CadastroFuncionario> findAllByDt_contratacaoContainingIgnoreCase(@Param("dt_contratacao") String dt_contratacao);

}
