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
    public void criarTransacao(TransacaoDTO novaTransacao) {
        if (novaTransacao.getValor() == null || novaTransacao.getDataHora() == null) {
            throw new IllegalArgumentException("Erro: Valores nao podem ser nulos");
        }
        if (novaTransacao.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: Valor nao pode ser menor do que zero");
        }
        if (novaTransacao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Data nao pode estar no futuro");
        } else {
            listaTransacoes.add(novaTransacao);
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
