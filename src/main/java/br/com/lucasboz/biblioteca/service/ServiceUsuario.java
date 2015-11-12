package br.com.lucasboz.biblioteca.service;

import java.util.List;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasboz.biblioteca.entity.Perfil;
import br.com.lucasboz.biblioteca.entity.Usuario;
import br.com.lucasboz.biblioteca.repository.DAOUsuario;

@Service
@Transactional
@RemoteProxy(name = "usuarioService")
public class ServiceUsuario {

	@Autowired
	DAOUsuario daoUsuario;
	
	public Usuario getCurrent() throws UsernameNotFoundException {
	  Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  return this.daoUsuario.findOne(usuario.getId());
    }
	
	public Usuario save(Usuario usuario) throws Exception{
		if (this.getCurrent().getPerfil() == Perfil.ADMINISTRADOR ) {
			
			String senhaUsuarioAux = usuario.getPassword();
			System.out.println("sENHA : " + senhaUsuarioAux);
			if (senhaUsuarioAux.equals("")){
				System.out.println("TA VAZIA");
			}
			if (usuario.getId() == null) {
				usuario.setPassword(new ShaPasswordEncoder().encodePassword(usuario.getPassword(), null ));			
				
				if ((usuario.getPerfil() != null)){				
					Usuario user =  this.daoUsuario.save(usuario); 	
//					try {
//						SimpleEmail email = new SimpleEmail();  
//				        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
//				        email.addTo( usuario.getEmail() , usuario.getNome() ); //destinatário  
//				        email.setFrom( this.getCurrent().getUsername()  , this.getCurrent().getNome() ); // remetente  
//				        email.setSubject("Criação de conta para acesso a Biblioteca Online"); // assunto do e-mail  
//				        email.setMsg("Nome do usuario: " + usuario.getNome() + 
//				        		     "\nSenha: " + senhaUsuarioAux +
//				        		     "\nLogin do sistema : " +  usuario.getEmail()); //conteudo do e-mail  
//				        email.setAuthentication( "lucas.boz@eits.com.br", Senha.senha);
//				        email.setSmtpPort(465);  
//				        email.setSSL(true);  
//				        email.setTLS(true);  
//				        email.send(); 
//					} catch (Exception e) {
//						throw e; 
//					}
					return user;
				}
			    
			} else {
				if(usuario.getPassword().equals("")){
					System.out.println(usuario.getPassword());
					usuario.setPassword(this.daoUsuario.findOne(usuario.getId()).getPassword());
				} else {
					usuario.setPassword(new ShaPasswordEncoder().encodePassword( usuario.getPassword(), null ));
				}
				return this.daoUsuario.save(usuario); 
			}
		} else {
			throw new Exception("Salvar e alterar usuários apenas é permitido para Administradores");
		}	

		return null;
	}

	
	public void remove(Long id) {
		if (this.getCurrent().getPerfil() == Perfil.ADMINISTRADOR ) {
			daoUsuario.delete(id);
		}	
	}

	public List<Usuario> find() {
		return daoUsuario.findAll();
	}

	public Usuario find(Long id) {
		return daoUsuario.findOne(id);
	}
}