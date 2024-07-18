package br.com.bergmann.kafka_api_boleto.mapper;

import br.com.bergmann.kafka_api_boleto.dto.BoletoDTO;
import br.com.bergmann.kafka_api_boleto.model.Boleto;

public class BoletoMapper {

    public static BoletoDTO toDTO(Boleto boleto) {
        return BoletoDTO.builder()
                .barCode(boleto.getBarCode())
                .situationBoleto(boleto.getSituationBoleto())
                .issueDate(boleto.getIssueDate())
                .updateDate(boleto.getUpdateDate())
                .build();
    }

    public static Boleto toBoleto(BoletoDTO boletoDTO) {
        return  Boleto.builder()
                .barCode(boletoDTO.getBarCode())
                .situationBoleto(boletoDTO.getSituationBoleto())
                .issueDate(boletoDTO.getIssueDate())
                .updateDate(boletoDTO.getUpdateDate())
                .build();
    }

    public static br.com.bergmann.avro.Boleto toAvro(Boleto boleto) {
        return br.com.bergmann.avro.Boleto.newBuilder()
                .setBarCode(boleto.getBarCode())
                .setSituationBoleto(boleto.getSituationBoleto().ordinal())
                .build();
    }
}
