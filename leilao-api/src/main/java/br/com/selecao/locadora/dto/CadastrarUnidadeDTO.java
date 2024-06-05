
package br.com.selecao.locadora.dto;

import br.com.selecao.locadora.entity.Unidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarUnidadeDTO {
    @NotEmpty(message = "{campo.nome-unidade.obrigatorio}")
    private String nome;

    public Unidade toUnidade(){
        Unidade unidade = new Unidade();
        unidade.setNome(this.nome);

        return unidade;
    }
}