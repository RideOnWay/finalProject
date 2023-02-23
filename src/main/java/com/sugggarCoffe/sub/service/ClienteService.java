package com.sugggarCoffe.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.Cliente;
import com.sugggarCoffe.sub.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private final ClienteRepository clienteRepositorio;

	    public ClienteService(ClienteRepository clienteRepositorio) {
	        this.clienteRepositorio = clienteRepositorio;
	    }

	    public Cliente getCliente(Long id) throws NotFoundException {
	        return clienteRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Cliente createCliente(Cliente cliente) {
	        return clienteRepositorio.save(cliente);
	    }
	    
	    public void deleteCliente(Cliente cliente) {
	         clienteRepositorio.delete(cliente);
	    }
	    
	    
	    public List<Cliente> listarCliente(){
	    	return (List<Cliente>)clienteRepositorio.findAll();
	    }
	    

		 public ClienteRepository getClienteRepositorio() {
			return clienteRepositorio;
		}
}
