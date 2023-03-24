package br.com.projeto.restaurante.domain;

import br.com.projeto.restaurante.domain.enums.Status;
import br.com.projeto.restaurante.domain.enums.Tipos;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


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
    private Status status = Status.AGUARDANDOCONFIRMACAO;
    private Tipos tipos;
    private Integer pedido;
    private Date dataHoraPedido = new Date();
    private Date lastUpdateDataHora = new Date();

}
