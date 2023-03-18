package br.com.project.restaurant.service;

import br.com.project.restaurant.form.PerfilForm;
import org.springframework.stereotype.Service;

@Service
public interface PerfilService {

    public PerfilForm savePerfil(PerfilForm perfilForm);

}
