package br.com.bergmann.kafka_api_boleto.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoletoRequestDTO {
    private String barCode;
}
