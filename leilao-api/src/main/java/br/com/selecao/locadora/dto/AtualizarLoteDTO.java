
package br.com.selecao.locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarLoteDTO {
    private Integer numeroLote;

    @NotEmpty(message = "{campo.descricao-lote.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.quantidade-lote.obrigatorio}")
    private BigDecimal quantidade;

    private BigDecimal valorInicial;

    @NotEmpty(message = "{campo.unidade-lote.obrigatorio}")
    private String unidade;

    @NotNull(message = "{campo.leilao-lote.obrigatorio}")
    private Long leilao;
}