package br.com.bergmann.kafka_api_boleto.repository;

import br.com.bergmann.kafka_api_boleto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto,Long> {
    Optional<Boleto> findByBarCode(String barCode);
}
