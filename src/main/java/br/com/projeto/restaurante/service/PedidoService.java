package br.com.projeto.restaurante.service;

import br.com.projeto.restaurante.form.PedidoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoService {

    public PedidoDto savePedido(PedidoDto pedidoDto) throws Exception;

    public List<PedidoDto> findAll();

    public PedidoDto findByIdPedido(Long id);

    public PedidoDto updatePedido(Long id, PedidoDto pedidoDto) throws Exception;

    public PedidoDto removePedido(Long id);
}
