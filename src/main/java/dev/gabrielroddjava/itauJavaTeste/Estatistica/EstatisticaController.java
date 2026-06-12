package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class EstatisticaController {

    private EstatiscaService estatiscaService;

    public EstatisticaController(EstatiscaService estatiscaService) {
        this.estatiscaService = estatiscaService;
    }

    //GET - Mostrar Estatisticas
    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDTO> mostrarEstatisticas() {
        EstatisticaDTO estatisticaCalculada = estatiscaService.calcularEstatistica();
        return ResponseEntity.status(HttpStatus.OK)
                .body(estatisticaCalculada);
    }


}
