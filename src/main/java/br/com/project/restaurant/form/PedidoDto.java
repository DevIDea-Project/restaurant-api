package br.com.project.restaurant.form;

import br.com.project.restaurant.domain.Pedido;
import br.com.project.restaurant.domain.enums.Status;
import br.com.project.restaurant.domain.enums.Tipos;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
public class PedidoDto {

    private Long id;
    private Integer mesa;
    private String observacao;
    private Status status;
    private Tipos tipos;
    private Integer pedido;
    private Date dataHoraPedido;
    private Date lastUpdateDataHora;

    public Pedido convertDtoToDomain(PedidoDto pedidoDto) {

        Pedido pedidoDomain = new Pedido();
        pedidoDomain.setId(pedidoDto.getId());
        pedidoDomain.setMesa(pedidoDto.getMesa());
        pedidoDomain.setObservacao(pedidoDto.getObservacao());
        pedidoDomain.setTipos(pedidoDto.getTipos());
        pedidoDomain.setPedido(pedidoDto.getPedido());
        pedidoDomain.setMesa(pedidoDto.getMesa());

        return pedidoDomain;
    }

    public PedidoDto convertDomainToDto (Pedido pedidoDomain) {
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(pedidoDomain.getId());
        pedidoDto.setMesa(pedidoDomain.getMesa());
        pedidoDto.setObservacao(pedidoDomain.getObservacao());
        pedidoDto.setStatus(pedidoDomain.getStatus());
        pedidoDto.setTipos(pedidoDomain.getTipos());
        pedidoDto.setPedido(pedidoDomain.getPedido());
        pedidoDto.setLastUpdateDataHora(pedidoDomain.getLastUpdateDataHora());
        pedidoDto.setDataHoraPedido(pedidoDomain.getDataHoraPedido());
        return pedidoDto;
    }

    public List<PedidoDto> convertListDomainToDto (List<Pedido> listDomain){

        List<PedidoDto> listDto = new ArrayList<>();
        listDomain.forEach(pedidoDomain -> {
            PedidoDto pedidoDto = new PedidoDto();
            pedidoDto.setId(pedidoDomain.getId());
            pedidoDto.setMesa(pedidoDomain.getMesa());
            pedidoDto.setObservacao(pedidoDomain.getObservacao());
            pedidoDto.setStatus(pedidoDomain.getStatus());
            pedidoDto.setTipos(pedidoDomain.getTipos());
            pedidoDto.setPedido(pedidoDomain.getPedido());
            pedidoDto.setDataHoraPedido(pedidoDomain.getDataHoraPedido());
            pedidoDto.setLastUpdateDataHora(pedidoDomain.getLastUpdateDataHora());
            listDto.add(pedidoDto);
        });
        return listDto;
    }


}
