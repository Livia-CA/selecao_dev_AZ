package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.AtualizarEmpresaDTO;
import br.com.selecao.locadora.dto.CadastrarEmpresaDTO;
import br.com.selecao.locadora.entity.Empresa;
import br.com.selecao.locadora.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaBO {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> buscarTodos(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> encontrar(Long id) {
        return empresaRepository.findById(id);
    }

    public Empresa salvar(CadastrarEmpresaDTO cadastrarEmpresaDTO) {
        Empresa empresa = cadastrarEmpresaDTO.toEmpresa();
        empresa.setCreatedAt(LocalDateTime.now());
        empresa.setUpdatedAt(LocalDateTime.now());

        return empresaRepository.save(empresa);
    }

    public void atualizar(Long id, AtualizarEmpresaDTO atualizarEmpresaDTO) {
        empresaRepository.findById(id).map( empresa -> {
            empresa.setRazaoSocial(atualizarEmpresaDTO.getRazaoSocial());
            empresa.setCnpj(atualizarEmpresaDTO.getCnpj());
            empresa.setLogradouro(atualizarEmpresaDTO.getLogradouro());
            empresa.setMunicipio(atualizarEmpresaDTO.getMunicipio());
            empresa.setNumero(atualizarEmpresaDTO.getNumero());
            empresa.setComplemento(atualizarEmpresaDTO.getComplemento());
            empresa.setBairro(atualizarEmpresaDTO.getBairro());
            empresa.setCep(atualizarEmpresaDTO.getCep());
            empresa.setTelefone(atualizarEmpresaDTO.getTelefone());
            empresa.setEmail(atualizarEmpresaDTO.getEmail());
            empresa.setSite(atualizarEmpresaDTO.getSite());
            empresa.setUsuario(atualizarEmpresaDTO.getUsuario());
            empresa.setSenha(atualizarEmpresaDTO.getSenha());
            empresa.setUpdatedAt(LocalDateTime.now());
            return empresaRepository.save(empresa);
        });
    }

    public void deletar(Long id) {
        empresaRepository.findById(id).map( p -> {
            empresaRepository.delete(p);
            return Void.TYPE;
        });
    }
}
