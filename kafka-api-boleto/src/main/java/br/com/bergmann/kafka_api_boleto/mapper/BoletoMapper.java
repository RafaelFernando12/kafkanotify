package br.com.bergmann.kafka_api_boleto.mapper;

import br.com.bergmann.kafka_api_boleto.dto.BoletoDTO;
import br.com.bergmann.kafka_api_boleto.model.Boleto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
    BoletoMapper INSTANCE = Mappers.getMapper(BoletoMapper.class);

    Boleto toBoleto(BoletoDTO boletoDTO);
    BoletoDTO toBoletoDTO(Boleto boleto);
}
