
package br.com.selecao.locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarLeilaoDTO {
    private Integer codigo;

    @NotEmpty(message = "{campo.descricao-leilao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.vendedor-leilao.obrigatorio}")
    private Integer vendedor;

    @NotNull(message = "{campo.inicio-previsto-leilao.obrigatorio}")
    private LocalDateTime inicioPrevisto;
}