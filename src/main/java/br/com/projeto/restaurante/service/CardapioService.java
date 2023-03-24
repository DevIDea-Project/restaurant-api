package br.com.projeto.restaurante.service;

import br.com.projeto.restaurante.form.CardapioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardapioService {

    public CardapioDto saveCardapio(CardapioDto cardapioDto) throws Exception;

    public List<CardapioDto> findAll();

    public CardapioDto findByIdCardapio(Long id);

    public CardapioDto updateCardapio(Long id, CardapioDto cardapioDto) throws Exception;



    public CardapioDto removeCardapio(Long id);
}
