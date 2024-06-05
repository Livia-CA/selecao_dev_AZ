package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.UnidadeBO;
import br.com.selecao.locadora.dto.AtualizarUnidadeDTO;
import br.com.selecao.locadora.dto.CadastrarUnidadeDTO;
import br.com.selecao.locadora.entity.Unidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "/unidade")
public class UnidadeService {
    @Autowired
    private UnidadeBO unidadeBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        return new ResponseEntity<>(unidadeBO.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Optional<Unidade> find(@PathVariable Long id) {
        return unidadeBO.encontrar(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public Unidade save(@RequestBody @Valid CadastrarUnidadeDTO cadastrarUnidadeDTO ){
        return unidadeBO.salvar(cadastrarUnidadeDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Long id , @RequestBody @Valid AtualizarUnidadeDTO atualizarUnidadeDTO){
        unidadeBO.atualizar(id, atualizarUnidadeDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        unidadeBO.deletar(id);
    }
}