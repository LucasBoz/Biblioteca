package br.com.lucasboz.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasboz.biblioteca.entity.Usuario;
import br.com.lucasboz.biblioteca.repository.DAOUsuario;

@Component
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	DAOUsuario daoUsuario;

	@Override
	@Transactional(/* readOnly = true */)
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		Usuario usuario = this.daoUsuario.findByEmailIgnoreCase(email);

		if (usuario == null) {
			System.out.println(email + " nao encontrado");
			throw new UsernameNotFoundException("Usario nao encontrado");
		}
		System.out.println(email + " encontrado");

		return usuario;
	}

}
