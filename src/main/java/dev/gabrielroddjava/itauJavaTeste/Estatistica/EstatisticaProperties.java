package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segundos) {
}
