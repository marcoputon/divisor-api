package com.divisor.api.service;

import com.divisor.api.entity.Pessoa;
import com.divisor.api.entity.Produto;
import com.divisor.api.exception.RecursoInexistenteException;
import com.divisor.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
                .orElseThrow( () -> new RecursoInexistenteException("Pessoa não encontrada: " + idPessoa) );
    }


    public Set<Produto> buscarProdutosPorPessoa (Long idPessoa) {
        Pessoa pessoa = this.buscarPessoa(idPessoa);
        return pessoa.getProdutos();
    }


    public Set<Produto> buscarProdutosDisponiveisPorPessoa (Long idPessoa) {
        this.buscarPessoa(idPessoa);
        return produtoService.buscarProdutosDisponiveisporPessoa(idPessoa);
    }


    // Não achei necessário criar um serviço para produto_pessoa. Criar se precisar de mais métodos.
    public Pessoa relacionarProduto (Long idPessoa, Long idProduto) {
        Pessoa pessoa = this.buscarPessoa(idPessoa);
        Produto produto = produtoService.buscarProduto(idProduto);
        pessoa.getProdutos().add(produto);

        return this.salvar(pessoa);
    }

}
