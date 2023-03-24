package br.com.projeto.restaurante.service;

import br.com.projeto.restaurante.form.UsuarioForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

	
	public UsuarioForm saveUsuario(UsuarioForm u1) throws Exception;
	
	public List<UsuarioForm> findAllByOrderByNomeBrand();

	public UsuarioForm findByIdUsuario(Long id);
	
	public UsuarioForm removeUser(Long id);
}
