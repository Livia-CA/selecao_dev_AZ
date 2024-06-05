package br.com.selecao.locadora.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompradorId implements Serializable {
    private Integer empresa;
    private Integer leilao;
}
