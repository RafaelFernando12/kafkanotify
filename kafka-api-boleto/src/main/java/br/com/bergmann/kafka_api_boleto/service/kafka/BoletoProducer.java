package br.com.bergmann.kafka_api_boleto.service.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.bergmann.kafka_api_boleto.dto.BoletoDTO;

@Component
public class BoletoProducer {
    // @Value("${spring.kafka.topic-boleto}")
    // public String topic;

    private final KafkaTemplate<String, BoletoDTO> kafkaTemplate;
    
    public BoletoProducer(KafkaTemplate<String, BoletoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BoletoDTO boletoDTO) {
        kafkaTemplate.send("solicitacao-boleto", boletoDTO);
    }
}
