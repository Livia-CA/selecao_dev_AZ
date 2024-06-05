
package br.com.selecao.locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarUnidadeDTO {
    @NotEmpty(message = "{campo.nome-unidade.obrigatorio}")
    private String nome;
}