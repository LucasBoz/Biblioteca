package br.com.lucasboz.biblioteca.service;

import java.util.List;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasboz.biblioteca.entity.Categoria;
import br.com.lucasboz.biblioteca.repository.DAOCategoria;

@Service
@Transactional
@RemoteProxy(name="categoriaService")
public class ServiceCategoria {

	@Autowired
	DAOCategoria daoCategoria;

	public Categoria save(Categoria categoria) {
		return daoCategoria.save(categoria);
	}

	public void remove(Long id) {
		this.daoCategoria.delete(id);
	}

	public Categoria find(Long id) {
		return daoCategoria.findOne(id);
	}

	public List<Categoria> find() {
		return daoCategoria.findAll();
	}
	
	public List<Categoria> find(String nome) {
		return daoCategoria.findByNomeIgnoreCaseContaining(nome);
	}

}
