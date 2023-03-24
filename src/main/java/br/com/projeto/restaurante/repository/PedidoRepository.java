package br.com.projeto.restaurante.repository;

import br.com.projeto.restaurante.domain.Pedido;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
@EnableAutoConfiguration
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
