package br.com.projeto.restaurante.domain;

import br.com.projeto.restaurante.domain.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static br.com.projeto.restaurante.domain.enums.Status.AGUARDANDOCONFIRMACAO;


@Entity
@Getter
@Setter
@Table(name = "tb_cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private String valor;
    private Status status = AGUARDANDOCONFIRMACAO;
    private Date dataHoraInit = new Date();
    private Date lastUpdateDataHora = new Date();

}
