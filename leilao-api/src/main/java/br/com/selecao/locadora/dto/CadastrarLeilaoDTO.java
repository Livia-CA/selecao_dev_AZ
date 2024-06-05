
package br.com.selecao.locadora.dto;

import br.com.selecao.locadora.entity.Leilao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarLeilaoDTO {
    private Integer codigo;

    @NotEmpty(message = "{campo.descricao-leilao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.vendedor-leilao.obrigatorio}")
    private Integer vendedor;

    @NotNull(message = "{campo.inicio-previsto-unidade.obrigatorio}")
    private LocalDateTime inicioPrevisto;

    public Leilao toLeilao(){
        Leilao leilao = new Leilao();
        leilao.setCodigo(this.codigo);
        leilao.setDescricao(this.descricao);
        leilao.setVendedor(this.vendedor);
        leilao.setInicioPrevisto(this.inicioPrevisto);

        return leilao;
    }
}