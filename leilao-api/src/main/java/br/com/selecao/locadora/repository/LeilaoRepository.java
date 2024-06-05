package br.com.selecao.locadora.repository;

import br.com.selecao.locadora.entity.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
    @Query("select new br.com.selecao.locadora.entity.Leilao(leilao.id, leilao.codigo, leilao.descricao, leilao.vendedor, leilao.inicioPrevisto, leilao.createdAt, leilao.updatedAt, COALESCE(SUM(lote.quantidade * lote.valorInicial), 0), empresa.razaoSocial) " +
            "from Lote lote " +
            "right join lote.leilao leilao " +
            "left join Comprador comprador on comprador.leilao.id = leilao.id " +
            "left join comprador.empresa empresa " +
            "group by leilao.id, leilao.codigo, leilao.descricao, leilao.vendedor, leilao.inicioPrevisto, leilao.createdAt, leilao.updatedAt, empresa.razaoSocial")
    List<Leilao> buscarLeiloesComTotalLote();
}

