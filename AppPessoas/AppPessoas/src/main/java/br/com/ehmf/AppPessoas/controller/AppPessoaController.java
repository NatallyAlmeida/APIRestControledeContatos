package br.com.ehmf.AppPessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppPessoas.model.Pessoa;
import br.com.ehmf.AppPessoas.repository.PessoaRepository;


@RestController
@RequestMapping("/api")//http://localhost:8080/api
public class AppPessoaController {

	@Autowired //injecao de dependencia
	private PessoaRepository pessoaRepository;
	
	@GetMapping("lista")
	public List<Pessoa> listar(){
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		return listPessoa;
	}
	
	@GetMapping
	public String getApi() {
		return "API Java funcionando!";
	}
	
	

	
	}
	

