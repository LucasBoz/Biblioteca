package br.com.lucasboz.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lucasboz.biblioteca.entity.Categoria;
import br.com.lucasboz.biblioteca.service.ServiceCategoria;
import br.com.lucasboz.biblioteca.service.ServiceLivro;

@Controller
public class NavigationController {
    
	@Autowired
    ServiceLivro serviceLivro;
	@Autowired
	ServiceCategoria serviceCategoria;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Categoria> index() {
//    	List<Categoria> list = new LinkedList<Categoria>();
//    	for (int i = 0; i < 5; i++) {
//    		Categoria categoria = new Categoria();
//    		categoria.setNome("categoria "+ i);
//    		serviceCategoria.save(categoria);
//    		list.add(categoria);
//    		Livro livro = new Livro();
//    		livro.setAutor("Autor "+ i);
//    		livro.setNome("Nome "+i);
//    		Categoria categoria = new Categoria();
//    		categoria = serviceCategoria.find((long)1);
//    		livro.setCategoria(categoria);
//    		serviceLivro.save(livro);
//    	}
        return null;
    }

}

