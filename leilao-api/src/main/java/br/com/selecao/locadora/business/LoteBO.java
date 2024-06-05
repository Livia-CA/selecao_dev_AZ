package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.AtualizarLoteDTO;
import br.com.selecao.locadora.dto.CadastrarLoteDTO;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.entity.Lote;
import br.com.selecao.locadora.exception.RegraNegocioException;
import br.com.selecao.locadora.repository.LeilaoRepository;
import br.com.selecao.locadora.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoteBO {

    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Lote> buscarTodos(){
        return loteRepository.findAll();
    }

    public Optional<Lote> encontrar(Long id) {
        return loteRepository.findById(id);
    }

    public Lote salvar(CadastrarLoteDTO cadastrarLoteDTO) {
        Long idLeilao = cadastrarLoteDTO.getLeilao();
        Leilao leilao = leilaoRepository.findById(idLeilao)
                .orElseThrow(() -> new RegraNegocioException("Código de leilao inválido."));

        Lote lote = cadastrarLoteDTO.toLote();
        lote.setLeilao(leilao);
        lote.setCreatedAt(LocalDateTime.now());
        lote.setUpdatedAt(LocalDateTime.now());

        return loteRepository.save(lote);
    }

    public void atualizar(Long id, AtualizarLoteDTO atualizarLoteDTO) {
        Long idLeilao = atualizarLoteDTO.getLeilao();
        Leilao leilao = leilaoRepository.findById(idLeilao)
                .orElseThrow(() -> new RegraNegocioException("Código de leilao inválido."));

        loteRepository.findById(id).map( lote -> {
            lote.setDescricao(atualizarLoteDTO.getDescricao());
            lote.setQuantidade(atualizarLoteDTO.getQuantidade());
            lote.setValorInicial(atualizarLoteDTO.getValorInicial());
            lote.setLeilao(leilao);
            lote.setUnidade(atualizarLoteDTO.getUnidade());
            lote.setUpdatedAt(LocalDateTime.now());
            return loteRepository.save(lote);
        });
    }

    public void deletar(Long id) {
        loteRepository.findById(id).map( p -> {
            loteRepository.delete(p);
            return Void.TYPE;
        });
    }
}
