package br.com.ehmf.AppPessoas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincrement
		private Long id;
		
		@Column(nullable = false)
	    private Integer tipoContato;//0 - Telefone, 1 Celular
	    
	    @Column(nullable = false)
	    private String contato;
	    
	    @ManyToOne
	    @JoinColumn(name = "pessoa_id", nullable = false)
	    private Pessoa pessoa;
		
	public Contato() {}

	public Contato(Long id, Integer tipoContato, String contato, Pessoa pessoa) {
		super();
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	
	}

	}
