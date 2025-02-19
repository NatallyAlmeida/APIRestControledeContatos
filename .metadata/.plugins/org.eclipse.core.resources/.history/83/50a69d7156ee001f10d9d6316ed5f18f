package br.com.ehmf.AppPessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppPessoas.model.Contato;

import br.com.ehmf.AppPessoas.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	//CRUD - Cread
	public Contato save(Contato contato) {
				return contatoRepository.save(contato);
			}
	
	//CRUD
	public Optional<Contato>findById(Long id){
		return contatoRepository.findById(id);
		
	}
	//CRUD
	public List<Contato> findAll(Long pessoaId){
		return contatoRepository.findAll();
		
	}
	//CRUD - Update
	public Contato update(Long id,Contato contato) {
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
