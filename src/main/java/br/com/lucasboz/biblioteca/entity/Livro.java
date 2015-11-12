package br.com.lucasboz.biblioteca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.directwebremoting.annotations.DataTransferObject;

@Entity
@DataTransferObject
public class Livro {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String autor;
	@ManyToOne(optional = false)
	private Categoria categoria;
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
