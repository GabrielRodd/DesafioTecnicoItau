package dev.gabrielroddjava.itauJavaTeste.Transacao;

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
    public TransacaoModel criarTransacao(@RequestBody TransacaoModel novaTransacao) {
        return transacaoService.criarTransacao(novaTransacao);
    }

    //GET - Mostrar Transacoes
    @GetMapping("/mostrar")
    public List<TransacaoModel> mostrarTransacoes() {
        return transacaoService.mostrarTransacoes();
    }
}
