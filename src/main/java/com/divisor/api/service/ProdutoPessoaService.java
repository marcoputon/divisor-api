package com.divisor.api.service;

import com.divisor.api.repository.ProdutoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoPessoaService {

    @Autowired
    ProdutoPessoaRepository produtoPessoaRepository;

    public void deletarPorProduto (Long idProduto) {

    }

}
