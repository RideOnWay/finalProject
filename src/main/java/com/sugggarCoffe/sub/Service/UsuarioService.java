package com.sugggarCoffe.sub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.Repository.UsuarioRepository;
import com.sugggarCoffe.sub.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private final UsuarioRepository usuarioRepositorio;


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
	    
}
