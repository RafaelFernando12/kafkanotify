package br.com.bergmann.kafka_api_boleto.model;

import br.com.bergmann.kafka_api_boleto.model.enums.Situation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ds_bar_code")
    private String barCode;
    @Column(name = "en_situation")
    private Situation situationBoleto;
    @Column(name = "dt_issue_date")
    private LocalDateTime issueDate;
    @Column(name = "dt_update_date")
    private LocalDateTime updateDate;
}
