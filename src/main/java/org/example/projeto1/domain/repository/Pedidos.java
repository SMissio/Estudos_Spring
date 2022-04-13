package org.example.projeto1.domain.repository;

import org.example.projeto1.domain.entity.Cliente;
import org.example.projeto1.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}

