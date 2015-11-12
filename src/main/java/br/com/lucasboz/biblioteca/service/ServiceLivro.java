package br.com.lucasboz.biblioteca.service;

import br.com.lucasboz.biblioteca.entity.Livro;
import br.com.lucasboz.biblioteca.repository.DAOLivro;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RemoteProxy(name="livroService")
public class ServiceLivro {

	@Autowired
	DAOLivro daoLivro;

	public Livro save(Livro livro) {
		return daoLivro.save(livro);
	}

	public void remove(Long id) {
		this.daoLivro.delete(id);
	}

	public Livro find(Long id) {
		return daoLivro.findOne(id);
	}

	public List<Livro> find() {
		return daoLivro.findAll();
	}
	
	public List<Livro> find(String nome) {
		return daoLivro.findByNomeIgnoreCaseContaining(nome);
	}

}