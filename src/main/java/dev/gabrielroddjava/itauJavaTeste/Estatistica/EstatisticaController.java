package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatiscaService estatiscaService;
    private final EstatisticaProperties estatisticaProperties;

    public EstatisticaController(EstatiscaService estatiscaService, EstatisticaProperties estatisticaProperties) {
        this.estatiscaService = estatiscaService;
        this.estatisticaProperties = estatisticaProperties;
    }

    //GET - Mostrar Estatisticas
    @GetMapping
    public ResponseEntity<EstatisticaDTO> mostrarEstatisticas() {

        //Log de requisicao criado via lombok
        log.info("Calculando estatisticas de transacoes feitas nos ultimos " + estatisticaProperties.segundos() + " segundos");

        //Calcular as estatisticas das transacoes dentro do range de 60 segundos
        final var horaAtual = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
        EstatisticaDTO estatisticaCalculada = estatiscaService.calcularEstatistica(horaAtual);
        return ResponseEntity.status(HttpStatus.OK)
                .body(estatisticaCalculada);
    }


}
