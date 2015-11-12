package br.com.lucasboz.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lucasboz.biblioteca.entity.Categoria;
import br.com.lucasboz.biblioteca.entity.Livro;
import br.com.lucasboz.biblioteca.entity.Usuario;
import br.com.lucasboz.biblioteca.service.ServiceCategoria;
import br.com.lucasboz.biblioteca.service.ServiceLivro;
import br.com.lucasboz.biblioteca.service.ServiceUsuario;

@Controller
public class RestController {

	@Autowired
	ServiceLivro serviceLivro;

	@Autowired
	ServiceCategoria serviceCategoria;
	
	@Autowired
	ServiceUsuario serviceUsuario;
	//CATEGORIAS
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public @ResponseBody List<Categoria> getCategorias() {	
		return this.serviceCategoria.find();
	}
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
	public @ResponseBody Categoria getCategorias(@PathVariable int id) {	
		return this.serviceCategoria.find((long)id);
	}
	@RequestMapping(value = "/categoria", method = RequestMethod.POST)
	public @ResponseBody Categoria saveCategoria(@RequestBody Categoria categoria) {	
		return this.serviceCategoria.save(categoria);
	}
	//USUARIOS	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getUsuarios() {	
		return this.serviceUsuario.find();
	}
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public @ResponseBody Usuario getUsuario(@PathVariable int id) {	
		return this.serviceUsuario.find((long)id);
	}
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public @ResponseBody Usuario saveUsuario(@RequestBody Usuario usuario) throws Exception{			
		return this.serviceUsuario.save(usuario);
	}
	//LIVROS	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public @ResponseBody List<Livro> getLivros() {	
		return this.serviceLivro.find();
	}
	@RequestMapping(value = "/livro/{id}", method = RequestMethod.GET)
	public @ResponseBody Livro getLivro(@PathVariable int id) {	
		return this.serviceLivro.find((long)id);
	}
	@RequestMapping(value = "/livro", method = RequestMethod.POST)
	public @ResponseBody Livro saveLivro(@RequestBody Livro livro) {	
		return this.serviceLivro.save(livro);
	}
}
