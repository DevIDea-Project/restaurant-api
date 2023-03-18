package br.com.project.restaurant.impl;

import br.com.project.restaurant.domain.Perfil;
import br.com.project.restaurant.form.PerfilForm;
import br.com.project.restaurant.repository.PerfilRepository;
import br.com.project.restaurant.service.PerfilService;
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
