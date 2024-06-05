package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.CompradorBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comprador")
public class CompradorService {
    @Autowired
    private CompradorBO compradorBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        return new ResponseEntity<>(compradorBO.buscarTodos(), HttpStatus.OK);
    }
}