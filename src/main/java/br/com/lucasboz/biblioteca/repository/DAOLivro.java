package br.com.lucasboz.biblioteca.repository;

import br.com.lucasboz.biblioteca.entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DAOLivro extends JpaRepository<Livro, Long> {
    @Transactional(readOnly = true)
    public List<Livro> findByNomeIgnoreCaseContaining(String nome);
	
}