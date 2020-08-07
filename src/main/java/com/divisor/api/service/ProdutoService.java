package com.divisor.api.service;

import com.divisor.api.dto.ProdutoDto;
import com.divisor.api.entity.Pessoa;
import com.divisor.api.entity.Produto;
import com.divisor.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PessoaService pessoaService;


    public List<Produto> listar () {
        return produtoRepository.findAll();
    }


    public ProdutoDto salvar (Produto produto) {
        return new ProdutoDto(produtoRepository.save(produto));
    }


    public Produto buscarProduto (Long idProduto) {
        return produtoRepository.findById(idProduto)
                .orElseThrow( () -> new RuntimeException("Produto não encontrado: " + idProduto));
    }


    public Set<Produto> buscarProdutosDisponiveisporPessoa (Long idPessoa) {
        List<Produto> todos = produtoRepository.findAll();
        Set<Produto> porPessoa = pessoaService.buscarProdutosPorPessoa(idPessoa);
        Set<Produto> retorno = new HashSet<>();

        for (Produto p : todos) {
            if (!porPessoa.contains(p)) {
                retorno.add(p);
            }
        }

        return retorno;
    }


    public Set<Pessoa> buscarPessoasPorProduto (Long idProduto) {
        Produto produto = this.buscarProduto(idProduto);
        return produto.getPessoas();
    }


    public Produto relacionarProduto (Long idPessoa, Long idProduto) {
        pessoaService.relacionarProduto(idPessoa, idProduto);
        return this.buscarProduto(idProduto);
    }

}
