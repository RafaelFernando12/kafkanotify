package br.com.bergmann.kafka_api_boleto.model.enums;

public enum Situation {
    INITIALIZED,
    VALIDATED,
    ERROR_VALIDATE,
    PAID_INVOICE,
    ERROR_PAYMENT,
}
