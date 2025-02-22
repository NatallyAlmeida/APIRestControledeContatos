package br.com.ehmf.AppPessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppPessoas.model.Pessoa;
import br.com.ehmf.AppPessoas.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	//CRUD - CREAT
		 public Pessoa save(Pessoa pessoa) {
		        if (pessoa.getNome() == null) {
		            System.out.println("Nome da Pessoa vazio.");
		            return null;
		        }
		        if (pessoa.getCep() == null) {
		            System.out.println("Cep da pessoa vazio.");
		            return null;
		        }
		        if (pessoa.getCidade() == null) {
		            System.out.println("Cidade da pessoa vazia.");
		            return null;
		        }
		        if (pessoa.getEndereco() == null) {
		            System.out.println("Endereço da pessoa vazio.");
		            return null;
		        }
		        if (pessoa.getUf() == null) {
		            System.out.println("UF da pessoa vazia.");
		            return null;
		        }

		        try {
		            return pessoaRepository.save(pessoa);
		        } catch (Exception e) {
		            System.out.println("Erro ao salvar pessoa: " + e.getMessage());
		            return null;
		        }
		 }
		 
		//CRUD - Read (leitura individual ou lista)
			public Optional<Pessoa> findById(Long id){
			 return pessoaRepository.findById(id);
			}
			
			public List<Pessoa> findAll(){
				//select * Pessoa
				return pessoaRepository.findAll();
			}
			//CRUD - Update 
			public Pessoa update(Pessoa pessoa) {
				Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
				if(findPessoa.isPresent()) {
					//crio um novo objeto de pessoa e lanço os dados
					//do objeto veio da Internet (parametro)
					Pessoa updPessoa = findPessoa.get();//setId
					updPessoa.setNome(pessoa.getNome());//veio por parâmetro
					updPessoa.setCep(pessoa.getCep());
					updPessoa.setCidade(pessoa.getCidade());
					updPessoa.setEndereco(pessoa.getEndereco());
					updPessoa.setUf(pessoa.getUf());
					return pessoaRepository.save(updPessoa);
				}
				return pessoaRepository.save(pessoa);//Update
			}
			// CRUD - Delete
			public void delete(Long id) {
				pessoaRepository.deleteById(id);
			}

			
}
		 
		
	
	

