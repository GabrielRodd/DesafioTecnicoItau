package dev.gabrielroddjava.itauJavaTeste.Transacao;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private List<TransacaoDTO> listaTransacoes = new ArrayList<>();

    //POST - Criar Transacao
    public TransacaoDTO criarTransacao(TransacaoDTO novaTransacao) {
        if (novaTransacao.getValor() == null || novaTransacao.getDataHora() == null) {
            return null;
        }
        if (novaTransacao.getValor().compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }
        if (novaTransacao.getDataHora().isAfter(OffsetDateTime.now())) {
            return null;
        } else {
            listaTransacoes.add(novaTransacao);
            return novaTransacao;
        }
    }

    //GET - Mostrar Transacoes
    public List<TransacaoDTO> mostrarTransacoes() {
        return listaTransacoes;
    }

    //DELETAR - Deletar todas Transacoes
    public void deletarTransacoes() {
        listaTransacoes.clear();
    }
}
