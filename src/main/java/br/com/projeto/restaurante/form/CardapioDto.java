package br.com.projeto.restaurante.form;

import br.com.projeto.restaurante.domain.Cardapio;
import br.com.projeto.restaurante.domain.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@Getter
@Setter
public class CardapioDto {

    private Long id;
    private String produto;
    private String valor;
    private Status status;
    private Date dataHoraInit;
    private Date lastUpdateDataHora;

    public Cardapio convertDtoToDomain(CardapioDto cardapioDto) {
        Cardapio cardapioDomain = new Cardapio();
        cardapioDomain.setId(cardapioDto.getId());
        cardapioDomain.setProduto(cardapioDto.getProduto());
        cardapioDomain.setValor(cardapioDto.getValor());
        return cardapioDomain;
    }

    public CardapioDto convertDomainToDto (Cardapio cardapioDomain) {
        CardapioDto cardapioDto = new CardapioDto();
        cardapioDto.setId(cardapioDomain.getId());
        cardapioDto.setProduto(cardapioDomain.getProduto());
        cardapioDto.setValor(cardapioDomain.getValor());
        cardapioDto.setStatus(cardapioDomain.getStatus());
        cardapioDto.setDataHoraInit(cardapioDomain.getDataHoraInit());
        cardapioDto.setLastUpdateDataHora(cardapioDomain.getLastUpdateDataHora());
        return cardapioDto;
    }

    public List<CardapioDto> convertListDomainToDto (List<Cardapio> listDomain){
        List<CardapioDto> listDto = new ArrayList<>();
        listDomain.forEach(cardapioDomain -> {
            CardapioDto cardapio = new CardapioDto();
            cardapio.setId(cardapioDomain.getId())	;
            cardapio.setProduto(cardapioDomain.getProduto());
            cardapio.setValor(cardapioDomain.getValor());
            cardapio.setStatus(cardapioDomain.getStatus());
            cardapio.setDataHoraInit(cardapioDomain.getDataHoraInit());
            cardapio.setLastUpdateDataHora(cardapioDomain.getLastUpdateDataHora());
            listDto.add(cardapio);
        });
        return listDto;
    }
}
