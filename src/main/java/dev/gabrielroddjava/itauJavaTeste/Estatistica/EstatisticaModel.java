package dev.gabrielroddjava.itauJavaTeste.Estatistica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter and setter
@AllArgsConstructor
@NoArgsConstructor
public class EstatisticaModel {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

}
