package br.com.project.restaurant.form;

import br.com.project.restaurant.domain.Perfil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;


@Component
@Getter
@Setter
public class PerfilForm {

    private Long id;
    @NotBlank
    private String nome;

    public Perfil convertTypeToDomain(PerfilForm perfilType) {
        Perfil perfilDto = new Perfil();
        perfilDto.setId(perfilType.getId());
        perfilDto.setNome(perfilType.getNome());
        return perfilDto;
    }

    public PerfilForm convertDomainToType(Perfil perfilDomain) {
        PerfilForm perfilType = new PerfilForm();
        perfilType.setId(perfilDomain.getId());
        perfilType.setNome(perfilDomain.getNome());
        return perfilType;
    }
}
