package br.com.project.restaurant.repository;

import br.com.project.restaurant.domain.Usuario;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableAutoConfiguration
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findAllByOrderByNomeAsc();



}
