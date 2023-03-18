package br.com.project.restaurant.controller;

import br.com.project.restaurant.form.PedidoDto;
import br.com.project.restaurant.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<PedidoDto>> list() {
        return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<PedidoDto> create(@Valid @RequestBody PedidoDto pedido) throws Exception{
        return new ResponseEntity<>(pedidoService.savePedido(pedido), null, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PedidoDto> listOne(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(pedidoService.findByIdPedido(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PedidoDto> updatePedido(@PathVariable Long id, @Valid @RequestBody PedidoDto pedido) throws Exception {
        PedidoDto pedidos = pedidoService.updatePedido(id, pedido);
        if(pedido != null) {
            return new ResponseEntity<>(pedidos, null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(pedidos, null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PedidoDto> deletePedido(@PathVariable Long id) throws Exception {
        PedidoDto pedidos = pedidoService.removePedido(id);
        return new ResponseEntity<>(pedidos, null, HttpStatus.OK);

    }


}
