package br.com.project.restaurant.controller;


import br.com.project.restaurant.form.CardapioDto;
import br.com.project.restaurant.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("cardapio")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<CardapioDto>> list() {
        return new ResponseEntity<>(cardapioService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<CardapioDto> create(@Valid @RequestBody CardapioDto cardapio) throws Exception{
        return new ResponseEntity<>(cardapioService.saveCardapio(cardapio), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CardapioDto> listOne(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(cardapioService.findByIdCardapio(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CardapioDto> updatePedido(@PathVariable Long id, @Valid @RequestBody CardapioDto cardapioDto) throws Exception {
        CardapioDto cardapios = cardapioService.updateCardapio(id, cardapioDto);
        if(cardapioDto != null) {
            return new ResponseEntity<>(cardapios, null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(cardapios, null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CardapioDto> deleteCardapio(@PathVariable Long id) throws Exception {
        CardapioDto cardapios = cardapioService.removeCardapio(id);
        return new ResponseEntity<>(cardapios, null, HttpStatus.OK);

    }
}
