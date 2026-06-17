package dev.gabrielroddjava.itauJavaTeste;

import dev.gabrielroddjava.itauJavaTeste.Estatistica.EstatisticaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EstatisticaProperties.class)
public class ItauJavaTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauJavaTesteApplication.class, args);
	}

}
