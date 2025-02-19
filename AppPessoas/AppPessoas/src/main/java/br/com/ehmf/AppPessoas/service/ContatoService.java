package br.com.ehmf.AppPessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppPessoas.model.Contato;
import br.com.ehmf.AppPessoas.model.Pessoa;
import br.com.ehmf.AppPessoas.repository.ContatoRepository;
import br.com.ehmf.AppPessoas.repository.PessoaRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	 
	private PessoaRepository pessoaRepository;
	
	//CRUD - Creat
	public Contato save(Contato contato) {
	    // Verificar se a Pessoa existe antes de salvar o Contato
	    if (contato.getPessoa() != null && contato.getPessoa().getId() != null) {
	        // Buscar a Pessoa no BD
	        Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());

	        if (findPessoa.isEmpty()) {
	            System.out.println("Pessoa não encontrada");
	            return null;
	        } else {
	            contato.setPessoa(findPessoa.get());
	        }
	    } else {
	        System.out.println("Pessoa nula");
	        return null;
	    }

	    // Salvar o Contato corretamente no repositório correto
	    return contatoRepository.save(contato);
	}

	
	//CRUD - Read (leitura individual ou lista)
	public Optional<Contato>findById(Long id){
		return contatoRepository.findById(id);
		
	}
	
	public List<Contato> findAll(){
		return contatoRepository.findAll();
		
	}
	//CRUD - Update
	public Contato update(Contato contato) {
		Optional<Contato>findContato = contatoRepository
				.findById(contato.getId());
		//se existir, atualizar:
		if(findContato.isPresent()) {
			//se existir, atualizar
			Contato updContato = findContato.get();
			updContato.setContato(contato.getContato());
			//gravar no banco
			return contatoRepository.save(updContato);
			
		}
		
		return contatoRepository.save(contato);
		
	}
	//CRUD - Delete
	public void delete(Long id) {
		contatoRepository.deleteById(id);
		
	}
}
