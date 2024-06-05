
package br.com.selecao.locadora.dto;

import br.com.selecao.locadora.entity.Lote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarLoteDTO {
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

    public Lote toLote(){
        Lote lote = new Lote();
        lote.setNumeroLote(this.numeroLote);
        lote.setDescricao(this.descricao);
        lote.setQuantidade(this.quantidade);
        lote.setValorInicial(this.valorInicial);
        lote.setUnidade(this.unidade);

        return lote;
    }
}