package br.com.selecao.locadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "seq_leilao", sequenceName = "seq_leilao", allocationSize = 1)
@Table(name = "leilao")
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_leilao")
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private Integer codigo;

    @NotEmpty
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "vendedor")
    private Integer vendedor;

    @NotNull
    @Column(name = "inicio_previsto")
    private LocalDateTime inicioPrevisto;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Transient
    private BigDecimal totalValoresLote;

    @Transient
    private String razaoSocialComprador;

}
