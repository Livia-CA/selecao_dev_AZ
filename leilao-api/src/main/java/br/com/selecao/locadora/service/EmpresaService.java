package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.EmpresaBO;
import br.com.selecao.locadora.dto.AtualizarEmpresaDTO;
import br.com.selecao.locadora.dto.CadastrarEmpresaDTO;
import br.com.selecao.locadora.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaService {
    @Autowired
    private EmpresaBO empresaBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        return new ResponseEntity<>(empresaBO.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Optional<Empresa> find(@PathVariable Long id) {
        return empresaBO.encontrar(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public Empresa save(@RequestBody @Valid CadastrarEmpresaDTO cadastrarEmpresaDTO ){
        return empresaBO.salvar(cadastrarEmpresaDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Long id , @RequestBody @Valid AtualizarEmpresaDTO atualizarEmpresaDTO){
        empresaBO.atualizar(id, atualizarEmpresaDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        empresaBO.deletar(id);
    }
}