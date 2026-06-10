package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import dev.gabrielroddjava.itauJavaTeste.Transacao.TransacaoModel;
import dev.gabrielroddjava.itauJavaTeste.Transacao.TransacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatiscaService {

    //Injetando o TransacaoService
    private TransacaoService transacaoService;

    public EstatiscaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public EstatisticaModel calcularEstatistica() {
        long count = 0;
        double sum = 0.0;
        double avg = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        List<TransacaoModel> listaTransacao = transacaoService.mostrarTransacoes();
        for (TransacaoModel transacao : listaTransacao) {
            double valor = transacao.getValor().doubleValue();
            count += 1;
            sum += valor;
            if (valor < min) {
                min = valor;
            }
            if (valor > max) {
                max = valor;
            }
        }
        avg = sum / count;
        EstatisticaModel estatisticas = new EstatisticaModel(count, sum, avg, min, max);
        return estatisticas;
    }
}
