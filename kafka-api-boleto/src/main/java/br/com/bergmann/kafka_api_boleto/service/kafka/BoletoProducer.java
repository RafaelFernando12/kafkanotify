package br.com.bergmann.kafka_api_boleto.service.kafka;

import br.com.bergmann.avro.Boleto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.bergmann.kafka_api_boleto.dto.BoletoDTO;

@Component
public class BoletoProducer {

    @Value("${spring.kafka.topico-boleto}")
    private String topic;

    private final KafkaTemplate<String, br.com.bergmann.avro.Boleto> kafkaTemplate;

    public BoletoProducer(KafkaTemplate<String, br.com.bergmann.avro.Boleto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(br.com.bergmann.avro.Boleto boleto) {
        kafkaTemplate.send(topic, boleto);
    }
}
