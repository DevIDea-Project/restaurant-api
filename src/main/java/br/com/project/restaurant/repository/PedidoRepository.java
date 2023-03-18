package br.com.project.restaurant.repository;

import br.com.project.restaurant.domain.Pedido;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
@EnableAutoConfiguration
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
