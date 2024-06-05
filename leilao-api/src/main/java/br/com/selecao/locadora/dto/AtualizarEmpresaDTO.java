package br.com.selecao.locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarEmpresaDTO {
    @NotEmpty(message = "{campo.razao-social-empresa.obrigatorio}")
    private String razaoSocial;

    @NotEmpty(message = "{campo.cnpj-empresa.obrigatorio}")
    private String cnpj;

    private String logradouro;

    private String municipio;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private String telefone;

    @NotEmpty(message = "{campo.email-empresa.obrigatorio}")
    private String email;

    private String site;

    @NotEmpty(message = "{campo.usuario-empresa.obrigatorio}")
    private String usuario;

    private String senha;
}