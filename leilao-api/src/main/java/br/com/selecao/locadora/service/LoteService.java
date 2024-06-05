package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.LoteBO;
import br.com.selecao.locadora.dto.AtualizarLoteDTO;
import br.com.selecao.locadora.dto.CadastrarLoteDTO;
import br.com.selecao.locadora.entity.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "/lote")
public class LoteService {
    @Autowired
    private LoteBO loteBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        return new ResponseEntity<>(loteBO.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Optional<Lote> find(@PathVariable Long id) {
        return loteBO.encontrar(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public Lote save(@RequestBody @Valid CadastrarLoteDTO cadastrarLoteDTO ){
        return loteBO.salvar(cadastrarLoteDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Long id , @RequestBody @Valid AtualizarLoteDTO atualizarLoteDTO){
        loteBO.atualizar(id, atualizarLoteDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        loteBO.deletar(id);
    }
}