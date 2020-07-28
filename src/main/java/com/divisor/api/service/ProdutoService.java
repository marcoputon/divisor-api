package com.divisor.api.service;

import com.divisor.api.dto.ProdutoDto;
import com.divisor.api.entity.Pessoa;
import com.divisor.api.entity.Produto;
import com.divisor.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
                .orElseThrow( () -> new RuntimeException("Erro ao buscar produto de id " + idProduto));
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
