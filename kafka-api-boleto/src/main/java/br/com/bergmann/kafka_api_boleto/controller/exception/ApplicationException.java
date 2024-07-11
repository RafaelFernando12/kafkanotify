package br.com.bergmann.kafka_api_boleto.controller.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }
}
