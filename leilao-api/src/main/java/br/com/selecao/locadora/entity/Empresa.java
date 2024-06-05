package br.com.selecao.locadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", allocationSize = 1)
@Table(name = "empresa",
        uniqueConstraints = {
                @UniqueConstraint(name = "empresa_cnpj_uk", columnNames = "cnpj"),
                @UniqueConstraint(name = "empresa_usuario_uk", columnNames = "usuario")
        })
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_empresa")
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotEmpty
    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "telefone")
    private String telefone;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @Column(name = "site")
    private String site;

    @NotEmpty
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "senha")
    private String senha;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
