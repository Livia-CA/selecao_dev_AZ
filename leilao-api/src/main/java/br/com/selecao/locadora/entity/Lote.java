package br.com.selecao.locadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "seq_lote", sequenceName = "seq_lote", allocationSize = 1)
@Table(name = "lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_lote")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_lote")
    private Integer numeroLote;

    @NotEmpty
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "valor_inicial")
    private BigDecimal valorInicial;

    @NotEmpty
    @Column(name = "unidade")
    private String unidade;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
