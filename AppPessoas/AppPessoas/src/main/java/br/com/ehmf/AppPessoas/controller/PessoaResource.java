package br.com.ehmf.AppPessoas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppPessoas.model.Pessoa;
import br.com.ehmf.AppPessoas.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/Pessoa")//http://localhost:8080/api/pessoas
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "(cria uma nova Pessoa)" )
	@PostMapping("POST /api/pessoas")
	public ResponseEntity <Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newpessoas =pessoaService.save(pessoa);
		if(newpessoas == null) {
			return ResponseEntity.notFound().build();//de status code 404
			
		}else {
			return ResponseEntity.ok(newpessoas);//de status code 200 e retorna objeto
			
		}
}
	@Operation(summary = "(Retorna os dados de uma Pessoa por ID)" )
	@GetMapping("GET /api/pessoas/{id}")//Get http://localhost:8080
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if(pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();//400
		}else {
			return ResponseEntity.ok(pessoa);//200
		}
	}
	
	@Operation(summary = "(Lista todas as Pessoas)" )
	@GetMapping("GET /api/pessoas")//Get http://localhost:8080/api/pessoas
	public ResponseEntity<List<Pessoa>> findAll(){ 
		List<Pessoa> pessoa = pessoaService.findAll();
		if(pessoa == null)
			return ResponseEntity.badRequest().build();
		if(pessoa.size()== 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
			
	}
	
	@Operation(summary = "(atualiza uma Pessoa existente)" )
	@PutMapping("PUT /api/pessoas/{id}")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa updpessoas = pessoaService.update(pessoa);
		if(updpessoas == null) {
			return ResponseEntity.notFound().build();//d~e status code 404
			
		}else {
			return ResponseEntity.ok(updpessoas);//d~e status code 200 e retorna objeto
			
		}
	}
	
	@Operation(summary = "Deletar Pessoa por Id" )
	@DeleteMapping("DELETE /api/pessoas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		
	}
}
