package br.com.bergmann.kafka_api_boleto.controller.exception;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ErrorResponse {
    private String error;
    private int codError;
    private LocalDateTime timestamp;
    private String path;
}
