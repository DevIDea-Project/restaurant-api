package br.com.projeto.restaurante.repository;

import br.com.projeto.restaurante.domain.Perfil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;


@Configuration
@EnableAutoConfiguration
public interface PerfilRepository extends JpaRepository<Perfil, Long> {}
