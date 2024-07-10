package br.com.bergmann.kafka_api_boleto.dto;

import br.com.bergmann.kafka_api_boleto.model.enums.Situation;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BoletoDTO {
    private String barCode;
    private Situation situationBoleto;
    private LocalDateTime issueDate;
    private LocalDateTime updateDate;
}
