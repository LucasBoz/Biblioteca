package br.com.lucasboz.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.lucasboz.biblioteca.service.ServiceCategoria;
import br.com.lucasboz.biblioteca.service.ServiceLivro;

@Controller
public class Testes {

	@Autowired
	ServiceLivro serviceLivro;

	@Autowired
	ServiceCategoria serviceCategoria;
	
//	@Autowired
//	ServiceUsuario serviceUsuario;

//	@RequestMapping(value = "/testSaveCategorias", method = RequestMethod.GET)
//	public @ResponseBody List<Categoria> pupularCategoria() {
//		List<Categoria> list = new LinkedList<Categoria>();
//		for (int i = 0; i < 5; i++) {
//			Categoria categoria = new Categoria();
//			categoria.setNome("categoria " + i);
//			serviceCategoria.save(categoria);
//			list.add(categoria);
//
//		}
//		return list;
//	}
//	@RequestMapping(value = "/testSaveLivros", method = RequestMethod.GET)
//	public @ResponseBody List<Livro> pupularLivro() {
//		List<Livro> list = new LinkedList<Livro>();
//		for (int i = 0; i < 5; i++) {
//			Livro livro = new Livro();
//			livro.setAutor("Autor " + i);
//			livro.setNome("Nome " + i);
//			Categoria categoria = new Categoria();
//			categoria = serviceCategoria.find((long) 1);
//			livro.setCategoria(categoria);
//			serviceLivro.save(livro);
//			list.add(livro);
//		}
//		return list;
//	}
//	@RequestMapping(value = "/testSaveUsuario", method = RequestMethod.GET)
//	public @ResponseBody List<Usuario> pupularUsuario() {
//		List<Usuario> list = new LinkedList<Usuario>();
//		for (int i = 0; i < 5; i++) {
//			Usuario usuario= new Usuario();
//			usuario.setNome("Nome " + i);
//			usuario.setEmail("user" + i + "@domain");
//			usuario.setEndereco("Rua "+ i);
//			usuario.setPerfil(Perfil.USUARIO);
//			serviceUsuario.save(usuario);
//		}
//		return list;
//	}
////	

}
