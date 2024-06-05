package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.AtualizarLeilaoDTO;
import br.com.selecao.locadora.dto.CadastrarLeilaoDTO;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LeilaoBO {

    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Leilao> buscarTodos(){
        return leilaoRepository.buscarLeiloesComTotalLote();
    }


    public Optional<Leilao> encontrar(Long id) {
        return leilaoRepository.findById(id);
    }

    public Leilao salvar(CadastrarLeilaoDTO cadastrarLeilaoDTO) {
        Leilao leilao = cadastrarLeilaoDTO.toLeilao();
        leilao.setCreatedAt(LocalDateTime.now());
        leilao.setUpdatedAt(LocalDateTime.now());

        return leilaoRepository.save(leilao);
    }

    public void atualizar(Long id, AtualizarLeilaoDTO atualizarLeilaoDTO) {
        leilaoRepository.findById(id).map( leilao -> {
            leilao.setCodigo(atualizarLeilaoDTO.getCodigo());
            leilao.setDescricao(atualizarLeilaoDTO.getDescricao());
            leilao.setVendedor(atualizarLeilaoDTO.getVendedor());
            leilao.setInicioPrevisto(atualizarLeilaoDTO.getInicioPrevisto());
            leilao.setUpdatedAt(LocalDateTime.now());
            return leilaoRepository.save(leilao);
        });
    }

    public void deletar(Long id) {
        leilaoRepository.findById(id).map( p -> {
            leilaoRepository.delete(p);
            return Void.TYPE;
        });
    }
}
