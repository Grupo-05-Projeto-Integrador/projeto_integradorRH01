package com.cadastrorh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrorh.model.CadastroFuncionario;

public interface CadastroRepository extends JpaRepository<CadastroFuncionario, Long>{

}
