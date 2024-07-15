package br.com.bergmann.kafka_api_boleto.service;

import br.com.bergmann.kafka_api_boleto.controller.exception.ApplicationException;
import br.com.bergmann.kafka_api_boleto.dto.BoletoDTO;
import br.com.bergmann.kafka_api_boleto.mapper.BoletoMapper;
import br.com.bergmann.kafka_api_boleto.model.Boleto;
import br.com.bergmann.kafka_api_boleto.model.enums.Situation;
import br.com.bergmann.kafka_api_boleto.repository.BoletoRepository;
import br.com.bergmann.kafka_api_boleto.service.kafka.BoletoProducer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;
    private final BoletoProducer boletoProducer;

    public BoletoService(BoletoRepository boletoRepository, BoletoProducer boletoProducer) {
        this.boletoRepository = boletoRepository;
        this.boletoProducer = boletoProducer;
    }

    public BoletoDTO save(@Valid String barCode){
        var bol = boletoRepository.findByBarCode(barCode);
        if(bol.isPresent()){
            throw new ApplicationException("There is already a payment request for this payment slip");
        }

        var boleto = Boleto.builder()
                .barCode(barCode)
                .situationBoleto(Situation.INITIALIZED)
                .issueDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        boletoRepository.save(boleto);
        boletoProducer.sendMessage(BoletoMapper.toAvro(boleto));
        return BoletoMapper.toDTO(boleto);
    }
}
