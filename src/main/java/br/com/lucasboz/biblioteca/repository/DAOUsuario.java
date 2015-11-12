package br.com.lucasboz.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasboz.biblioteca.entity.Usuario;

@Transactional
public interface DAOUsuario extends JpaRepository<Usuario, Long> {

	@Transactional(readOnly = true)
	public Usuario findByEmailIgnoreCase(String email);

}