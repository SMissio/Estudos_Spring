package org.example.projeto1.Service;

import org.example.projeto1.MeuRepository.ClientesRepository;
import org.example.projeto1.Model.Cliente_teste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;
    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;

    }
    public void salvarCliente(Cliente_teste cliente) {
        validarCliente(cliente);
        this.repository.salvar(cliente);

    }
    public void validarCliente(Cliente_teste cliente){

    }
}
