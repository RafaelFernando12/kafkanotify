package br.com.bergmann.kafka_api_boleto.controller;

import br.com.bergmann.kafka_api_boleto.dto.BoletoDTO;
import br.com.bergmann.kafka_api_boleto.dto.BoletoRequestDTO;
import br.com.bergmann.kafka_api_boleto.service.BoletoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/boleto")
public class BoletoController {

    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @PostMapping
    public ResponseEntity<BoletoDTO> save(@RequestBody BoletoRequestDTO boletoDTO){
        var boleto = boletoService.save(boletoDTO.getBarCode());
        return new ResponseEntity<>(boleto, HttpStatus.CREATED);
    }
}
