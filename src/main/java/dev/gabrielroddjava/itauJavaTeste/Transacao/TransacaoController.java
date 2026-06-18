package dev.gabrielroddjava.itauJavaTeste.Transacao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    //POST - Criar Transacao
    @PostMapping("/criar")
    public ResponseEntity<Object> criarTransacao(@RequestBody TransacaoDTO novaTransacao) {
        try {
            log.info("Transacao realizada com sucesso");
            transacaoService.criarTransacao(novaTransacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            log.error("Erro em uma ou mais validacoes, tente novamente");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    //GET - Mostrar Transacoes
    @GetMapping("/mostrar")
    public ResponseEntity<List<TransacaoDTO>> mostrarTransacoes() {
        List<TransacaoDTO> listaTransacoes = transacaoService.mostrarTransacoes();
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaTransacoes);
    }

    //DELETE - Deletar Transacoes
    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
