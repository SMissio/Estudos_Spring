package org.example.projeto1;

import org.example.projeto1.domain.entity.Cliente;
import org.example.projeto1.domain.entity.Pedido;
import org.example.projeto1.domain.repository.Clientes;
import org.example.projeto1.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {
    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos) {
        return args -> {

            /*clientes.save(new Cliente("Sylvia"));
            clientes.save(new Cliente("Outro Cliente"));*/
            Cliente sylvia = new Cliente("Sylvia");
            clientes.save(sylvia);

            Pedido p = new Pedido();
            p.setCliente(sylvia);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(200));

            pedidos.save(p);

            /*Cliente cliente = clientes.findClienteFetchPedidos(sylvia.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());*/

            pedidos.findByCliente(sylvia).forEach(System.out::println);

        };
    }
//


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}