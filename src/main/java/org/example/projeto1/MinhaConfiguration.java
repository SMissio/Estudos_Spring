package org.example.projeto1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


public class MinhaConfiguration {
    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");

        };
    }

}
