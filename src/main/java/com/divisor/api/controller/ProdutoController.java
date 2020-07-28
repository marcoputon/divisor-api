package com.divisor.api.controller;

import com.divisor.api.entity.Produto;
import com.divisor.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/produtos")
    public List<Produto> listarPessoas () {
        return produtoService.listar();
    }


    @PostMapping("/produtos")
    public Produto salvar (@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

}
