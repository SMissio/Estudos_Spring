package org.example.projeto1;

import org.example.projeto1.domain.entity.Cliente;
import org.example.projeto1.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {
    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {

            clientes.save(new Cliente("Sylvia"));
            clientes.save(new Cliente("Outro Cliente"));
            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                clientes.save(c);
            });


            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.findByNomeLike("Cli").forEach(System.out::println);
            System.out.println("deletando clientes");
            clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });
            todosClientes = clientes.findAll();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado.");
            } else {
                todosClientes.forEach(System.out::println);
            }
        };
    }
//


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}