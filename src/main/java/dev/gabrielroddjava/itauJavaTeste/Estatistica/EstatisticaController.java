package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

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
        final var horaAtual = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
        EstatisticaDTO estatisticaCalculada = estatiscaService.calcularEstatistica(horaAtual);
        return ResponseEntity.status(HttpStatus.OK)
                .body(estatisticaCalculada);
    }


}
