package com.divisor.api.service;

import com.divisor.api.entity.Pessoa;
import com.divisor.api.entity.Produto;
import com.divisor.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ProdutoService produtoService;


    public List<Pessoa> listar () {
        return pessoaRepository.findAll();
    }


    public Pessoa salvar (Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    public Pessoa buscarPessoa (Long idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow( () -> new RuntimeException("Erro ao buscar pessoa de id " + idPessoa) );
    }


    public Pessoa relacionarProduto (Long idPessoa, Long idProduto) {
        Pessoa pessoa = this.buscarPessoa(idPessoa);
        Produto produto = produtoService.buscarProduto(idProduto);
        pessoa.getProdutos().add(produto);

        return pessoaRepository.save(pessoa);
    }

}
