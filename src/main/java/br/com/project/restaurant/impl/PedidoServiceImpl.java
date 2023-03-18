package br.com.project.restaurant.impl;

import br.com.project.restaurant.domain.Pedido;
import br.com.project.restaurant.form.PedidoDto;
import br.com.project.restaurant.repository.PedidoRepository;
import br.com.project.restaurant.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDto pedidoDto;

    @Override
    public PedidoDto savePedido(PedidoDto pedidoDto) throws Exception {
        Pedido pedidoSave = pedidoRepository.save(pedidoDto.convertDtoToDomain(pedidoDto));
        return pedidoDto.convertDomainToDto(pedidoSave);
    }

    @Override
    public List<PedidoDto> findAll() {
        List<Pedido> listPedido = pedidoRepository.findAll();
        return pedidoDto.convertListDomainToDto(listPedido);
    }

    @Override
    public PedidoDto findByIdPedido(Long id) {
        Optional<Pedido> listOnePedido = pedidoRepository.findById(id);
        if (listOnePedido.isPresent()) {
            return pedidoDto.convertDomainToDto(listOnePedido.get());
        } else {
            return null;
        }
    }

    @Override
    public PedidoDto updatePedido(Long id, PedidoDto pedidoDto) {
        Optional<Pedido> updatePedido = pedidoRepository.findById(id);
        if (updatePedido.isPresent()) {
            Pedido pedidoUpdates = updatePedido.get();
            pedidoUpdates.setStatus(pedidoDto.getStatus());
            Date updatesDate = new Date();
            pedidoUpdates.setLastUpdateDataHora(updatesDate);

            return pedidoDto.convertDomainToDto(pedidoRepository.saveAndFlush(pedidoUpdates));
        } else {
            return null;
        }
    }

    @Override
    public PedidoDto removePedido(Long id) {
        Optional<Pedido> m1 = pedidoRepository.findById(id);
        if (m1.isPresent()) {
            Pedido m2 = m1.get();
            pedidoRepository.delete(m2);
            return pedidoDto.convertDomainToDto(m2);
        } else {
            return null;
        }
    }

}
