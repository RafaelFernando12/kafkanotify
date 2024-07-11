package br.com.bergmann.kafka_api_boleto.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoletoRequestDTO {

    @NotNull(message = "cannot be null")
    @NotEmpty(message = "cannot be empty")
    private String barCode;
}
