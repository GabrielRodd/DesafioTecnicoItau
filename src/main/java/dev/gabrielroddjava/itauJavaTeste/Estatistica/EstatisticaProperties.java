package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "estatistica")
@Validated
public record EstatisticaProperties(@Positive Integer segundos) {
}
