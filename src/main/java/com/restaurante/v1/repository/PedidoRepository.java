package com.restaurante.v1.repository;

import com.restaurante.v1.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, String> {
}
