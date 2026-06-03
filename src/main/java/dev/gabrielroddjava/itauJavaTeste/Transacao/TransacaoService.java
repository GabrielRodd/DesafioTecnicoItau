package dev.gabrielroddjava.itauJavaTeste.Transacao;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private List<TransacaoModel> listaTransacoes = new ArrayList<>();

    //POST - Criar Transacao
    public TransacaoModel criarTransacao(TransacaoModel novaTransacao) {
        listaTransacoes.add(novaTransacao);
        return novaTransacao;
    }

    //GET - Mostrar Transacoes
    public List<TransacaoModel> mostrarTransacoes() {
        return listaTransacoes;
    }


}
