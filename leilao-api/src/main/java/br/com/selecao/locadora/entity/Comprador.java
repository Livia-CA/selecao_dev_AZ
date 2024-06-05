package br.com.selecao.locadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(CompradorId.class)
@Table(name = "comprador")
public class Comprador {
    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;
}

