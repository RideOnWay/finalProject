package com.sugggarCoffe.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.Usuario;
import com.sugggarCoffe.sub.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioService {

	@Autowired
	private final UsuarioRepository usuarioRepositorio;
	
	@Autowired
	  private HttpSession httpSession;
	

	    public Usuario getUsuario(Long id) throws NotFoundException {
	        return usuarioRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Usuario createUsuario(Usuario usuario) {
	        return usuarioRepositorio.save(usuario);
	    }
	    
	    public void deleteUsuario(Usuario usuario) {
	    	usuarioRepositorio.delete(usuario);
	    }
	    
	    
	    public List<Usuario> listarUsuario(){
	    	return (List<Usuario>)usuarioRepositorio.findAll();
	    }

		public UsuarioService(UsuarioRepository usuarioRepositorio) {
			this.usuarioRepositorio = usuarioRepositorio;
		}

		public UsuarioRepository getUsuarioRepositorio() {
			return usuarioRepositorio;
		}

		public Usuario findByUsernameAndPassword(String usuarioUsuario, String contrasenaUsuario) {
			List<Usuario> verUser=(List<Usuario>)usuarioRepositorio.findAll();
			for(Usuario temp:verUser) {
				if(temp.getCorreoUsuario().contentEquals(usuarioUsuario) && temp.getContrasenaUsuario().contentEquals(contrasenaUsuario)) {
					return temp;
				}
			}
			return null;	
		}
		
		public String getCurrentUsername() {
		    return (String) httpSession.getAttribute("usuarioNombre");
		  }
		
		public Long getCurrentIdUsuario() {
		    return (Long) httpSession.getAttribute("idUsuario");
		  }
		
		


	    
}
