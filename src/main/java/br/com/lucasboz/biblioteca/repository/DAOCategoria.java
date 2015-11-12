package br.com.lucasboz.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasboz.biblioteca.entity.Categoria;
@Transactional
public interface DAOCategoria extends JpaRepository<Categoria, Long> {

	@Transactional(readOnly = true)
	public List<Categoria> findByNomeIgnoreCaseContaining(String nome);
	
}
