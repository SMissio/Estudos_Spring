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
            List<Cliente> result = clientes.encontrarPorNome("Sylvia");
            result.forEach(System.out::println);

        };
    }
//


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}