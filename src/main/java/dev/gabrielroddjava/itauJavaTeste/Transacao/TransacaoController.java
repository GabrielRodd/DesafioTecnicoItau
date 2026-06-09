package dev.gabrielroddjava.itauJavaTeste.Transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    //POST - Criar Transacao
    @PostMapping("/criar")
    public ResponseEntity<Object> criarTransacao(@RequestBody TransacaoModel novaTransacao) {
        TransacaoModel transacao = transacaoService.criarTransacao(novaTransacao);
        if (transacao != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(transacao);
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("data errada ou valor negativo");
        }
    }

    //GET - Mostrar Transacoes
    @GetMapping("/mostrar")
    public ResponseEntity<List<TransacaoModel>> mostrarTransacoes() {
        List<TransacaoModel> listaTransacoes = transacaoService.mostrarTransacoes();
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaTransacoes);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
