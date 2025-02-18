package br.com.ehmf.AppPessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ehmf.AppPessoas.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long >{

}
