package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import dev.gabrielroddjava.itauJavaTeste.Transacao.TransacaoDTO;
import dev.gabrielroddjava.itauJavaTeste.Transacao.TransacaoModel;
import dev.gabrielroddjava.itauJavaTeste.Transacao.TransacaoService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatiscaService {

    //Injetando o TransacaoService
    private TransacaoService transacaoService;

    public EstatiscaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public EstatisticaDTO calcularEstatistica(OffsetDateTime horaAtual) {
        List<TransacaoDTO> listaTransacao = transacaoService.mostrarTransacoes();
        final var summary = listaTransacao.stream()
                .filter(t -> t.getDataHora().isAfter(horaAtual))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        if (summary.getCount() == 0) {
            return new EstatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax());
    }
}
