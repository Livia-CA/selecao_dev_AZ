
package br.com.selecao.locadora.dto;

import br.com.selecao.locadora.entity.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarEmpresaDTO {
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

    @Email(message = "{campo.email-empresa.valido}")
    @NotEmpty(message = "{campo.email-empresa.obrigatorio}")
    private String email;

    private String site;

    @NotEmpty(message = "{campo.usuario-empresa.obrigatorio}")
    private String usuario;

    private String senha;

    public Empresa toEmpresa(){
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(this.razaoSocial);
        empresa.setCnpj(this.cnpj);
        empresa.setLogradouro(this.logradouro);
        empresa.setMunicipio(this.municipio);
        empresa.setNumero(this.numero);
        empresa.setComplemento(this.complemento);
        empresa.setBairro(this.bairro);
        empresa.setCep(this.cep);
        empresa.setTelefone(this.telefone);
        empresa.setEmail(this.email);
        empresa.setSite(this.site);
        empresa.setUsuario(this.usuario);
        empresa.setSenha(this.senha);

        return empresa;
    }
}