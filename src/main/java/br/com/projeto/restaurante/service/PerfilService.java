package br.com.projeto.restaurante.service;

import br.com.projeto.restaurante.form.PerfilForm;
import org.springframework.stereotype.Service;

@Service
public interface PerfilService {

    public PerfilForm savePerfil(PerfilForm perfilForm);

}
