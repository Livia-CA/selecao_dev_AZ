package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.AtualizarUnidadeDTO;
import br.com.selecao.locadora.dto.CadastrarUnidadeDTO;
import br.com.selecao.locadora.entity.Unidade;
import br.com.selecao.locadora.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadeBO {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> buscarTodos(){
        return unidadeRepository.findAll();
    }

    public Unidade salvar(CadastrarUnidadeDTO cadastrarUnidadeDTO) {
        Unidade unidade = cadastrarUnidadeDTO.toUnidade();
        unidade.setCreatedAt(LocalDateTime.now());
        unidade.setUpdatedAt(LocalDateTime.now());

        return unidadeRepository.save(unidade);
    }

    public void atualizar(Long id, AtualizarUnidadeDTO atualizarUnidadeDTO) {
        unidadeRepository.findById(id).map( unidade -> {
            unidade.setNome(atualizarUnidadeDTO.getNome());
            unidade.setUpdatedAt(LocalDateTime.now());
            return unidadeRepository.save(unidade);
        });
    }

    public void deletar(Long id) {
        unidadeRepository.findById(id).map( p -> {
            unidadeRepository.delete(p);
            return Void.TYPE;
        });
    }

    public Optional<Unidade> encontrar(Long id) {
        return unidadeRepository.findById(id);
    }
}
