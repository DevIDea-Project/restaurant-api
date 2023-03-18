package br.com.project.restaurant.domain;

import br.com.project.restaurant.domain.enums.Status;
import br.com.project.restaurant.domain.enums.Tipos;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static br.com.project.restaurant.domain.enums.Status.AGUARDANDOCONFIRMACAO;


@Entity
@Getter
@Setter
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mesa;
    private String observacao;
    private Status status = AGUARDANDOCONFIRMACAO;
    private Tipos tipos;
    private Integer pedido;
    private Date dataHoraPedido = new Date();
    private Date lastUpdateDataHora = new Date();

}
