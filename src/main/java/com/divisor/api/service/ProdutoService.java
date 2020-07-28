package com.divisor.api.service;

import com.divisor.api.entity.Produto;
import com.divisor.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar () {
        return produtoRepository.findAll();
    }

    public Produto salvar (Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProduto (Long idProduto) {
        return produtoRepository.findById(idProduto)
                .orElseThrow( () -> new RuntimeException("Erro ao buscar produto de id " + idProduto));
    }

}
