package org.example.projeto1;

import org.example.projeto1.domain.entity.Cliente;
import org.example.projeto1.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {
    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {

            clientes.salvar(new Cliente("Sylvia"));
            clientes.salvar(new Cliente("Outro Cliente"));
            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                clientes.atualizar(c);
            });


            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.buscarPorNome("Cli").forEach(System.out::println);
            //            System.out.println("deletando clientes");
           // clientes.obterTodos().forEach(c -> {
          //      clientes.deletar(c);
          //  });
            todosClientes = clientes.obterTodos();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado.");
            } else {
                todosClientes.forEach(System.out::println);
            }
        };
    }

//    @Value("${application.name}")
//    private String applicationName;

//    @Cachorro
//    private Animal animal;
//
//    @Bean(name = "executarAnimal")
//    public CommandLineRunner executar(){
//        return args -> {
//            this.animal.fazerBarulho();
//
//        };
//    }
//    @GetMapping("/hello")
//    public String helloWorld() {
//        return applicationName;
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}
