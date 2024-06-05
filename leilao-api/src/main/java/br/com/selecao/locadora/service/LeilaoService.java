package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.LeilaoBO;
import br.com.selecao.locadora.dto.AtualizarLeilaoDTO;
import br.com.selecao.locadora.dto.CadastrarLeilaoDTO;
import br.com.selecao.locadora.entity.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "/leilao")
public class LeilaoService {
    @Autowired
    private LeilaoBO leilaoBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        return new ResponseEntity<>(leilaoBO.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Optional<Leilao> find(@PathVariable Long id) {
        return leilaoBO.encontrar(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public Leilao save(@RequestBody @Valid CadastrarLeilaoDTO cadastrarLeilaoDTO ){
        return leilaoBO.salvar(cadastrarLeilaoDTO);
    }

   @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Long id , @RequestBody @Valid AtualizarLeilaoDTO atualizarLeilaoDTO){
        leilaoBO.atualizar(id, atualizarLeilaoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        leilaoBO.deletar(id);
    }
}