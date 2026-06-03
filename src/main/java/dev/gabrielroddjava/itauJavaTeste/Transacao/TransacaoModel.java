package dev.gabrielroddjava.itauJavaTeste.Transacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data // getter and setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoModel {

    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
