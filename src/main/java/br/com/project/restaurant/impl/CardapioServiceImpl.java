package br.com.project.restaurant.impl;

import br.com.project.restaurant.domain.Cardapio;
import br.com.project.restaurant.form.CardapioDto;
import br.com.project.restaurant.repository.CardapioRepository;
import br.com.project.restaurant.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardapioServiceImpl implements CardapioService {


    @Autowired
    private CardapioRepository cardapioRepository;

    @Autowired
    private CardapioDto cardapioDto;

    @Override
    public CardapioDto saveCardapio(CardapioDto cardapioDto) throws Exception {
        Cardapio cardapioSave = cardapioRepository.save(cardapioDto.convertDtoToDomain(cardapioDto));
        return cardapioDto.convertDomainToDto(cardapioSave);
    }

    @Override
    public List<CardapioDto> findAll() {
        List<Cardapio> listCardapio = cardapioRepository.findAll();
        return cardapioDto.convertListDomainToDto(listCardapio);
    }

    @Override
    public CardapioDto findByIdCardapio(Long id) {
        Optional<Cardapio> listOneCardapio = cardapioRepository.findById(id);
        if (listOneCardapio.isPresent()) {
            return cardapioDto.convertDomainToDto(listOneCardapio.get());
        } else {
            return null;
        }
    }

    @Override
    public CardapioDto updateCardapio(Long id, CardapioDto cardapioDto) {
        Optional<Cardapio> updateCardapio = cardapioRepository.findById(id);
        if (updateCardapio.isPresent()) {
            Cardapio cardapioUpdates = updateCardapio.get();
            cardapioUpdates.setStatus(cardapioDto.getStatus());
            Date updatesDate = new Date();
            cardapioUpdates.setLastUpdateDataHora(updatesDate);

            return cardapioDto.convertDomainToDto(cardapioRepository.saveAndFlush(cardapioUpdates));
        } else {
            return null;
        }
    }

    @Override
    public CardapioDto removeCardapio(Long id) {
        Optional<Cardapio> m1 = cardapioRepository.findById(id);
        if (m1.isPresent()) {
            Cardapio m2 = m1.get();
            cardapioRepository.delete(m2);
            return cardapioDto.convertDomainToDto(m2);
        } else {
            return null;
        }
    }
}
