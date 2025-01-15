package com.cadastrorh.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cadastrorh.model.CadastroFuncionario;
import com.cadastrorh.repository.CadastroRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CadastroController {

	@Autowired
	private CadastroRepository cadastroRepository;

	@GetMapping // Lista todos os atributos
	public ResponseEntity<List<CadastroFuncionario>> getAll() {
		return ResponseEntity.ok(cadastroRepository.findAll());

	}

	@GetMapping("/{id}") // Consultar por ID
	public ResponseEntity<CadastroFuncionario> getById(@PathVariable Long id) {
		return cadastroRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/nome/{nome}") // Consultar por Nome
	public ResponseEntity<List<CadastroFuncionario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(cadastroRepository.findAllByNomeContainingIgnoreCase(nome));
			
	}
	
	@GetMapping("/email/{email}") // Consultar por E-mail
	public ResponseEntity<List<CadastroFuncionario>> getByEmail(@PathVariable String email) {
		return ResponseEntity.ok(cadastroRepository.findAllByEmailContainingIgnoreCase(email));
	}
	
	@GetMapping("/telefone/{telefone}") // Consultar por Telefone
	public ResponseEntity<List<CadastroFuncionario>> getByTelefone(@PathVariable String telefone) {
		return ResponseEntity.ok(cadastroRepository.findAllByTelefoneContainingIgnoreCase(telefone));
	}
	
	//@GetMapping("/dt_contratacao/{dt_contratacao}") // Consultar por Dt_Contratação
	//public ResponseEntity<List<CadastroFuncionario>> getByDt_contratacao(@PathVariable LocalDateTime dt_contratacao) {
		//return ResponseEntity.ok(cadastroRepository.findAllByDt_contratacaoContainingIgnoreCase(dt_contratacao));
	//}


	@PostMapping // Criar um cadastro
	public ResponseEntity<CadastroFuncionario> post(@Valid @RequestBody CadastroFuncionario CadastroFuncionario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroRepository.save(CadastroFuncionario));
	}

	@PutMapping // Criar método Atualizar
	public ResponseEntity<CadastroFuncionario> put(@Valid @RequestBody CadastroFuncionario cadastroFuncionario) {
		return cadastroRepository.findById(cadastroFuncionario.getId()).map(
				resposta -> ResponseEntity.status(HttpStatus.OK).body(cadastroRepository.save(cadastroFuncionario)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)   // Criar o método Deletar
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<CadastroFuncionario> CadastroFuncionario = cadastroRepository.findById(id);

		if (CadastroFuncionario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		cadastroRepository.deleteById(id);
	}

}
