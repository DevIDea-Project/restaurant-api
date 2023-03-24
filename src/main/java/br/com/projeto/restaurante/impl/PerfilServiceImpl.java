package br.com.projeto.restaurante.impl;

import br.com.projeto.restaurante.domain.Perfil;
import br.com.projeto.restaurante.form.PerfilForm;
import br.com.projeto.restaurante.repository.PerfilRepository;
import br.com.projeto.restaurante.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilForm perfilForm;

    @Override
    public PerfilForm savePerfil(PerfilForm perfilForm) {
        Perfil perfilSave = perfilRepository.save(perfilForm.convertTypeToDomain(perfilForm));
        return perfilForm.convertDomainToType(perfilSave);

    }
}
