package br.com.selecao.locadora.business;

import br.com.selecao.locadora.entity.Comprador;
import br.com.selecao.locadora.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorBO {

    @Autowired
    private CompradorRepository compradorRepository;

    public List<Comprador> buscarTodos(){
        return compradorRepository.findAll();
    }
}
