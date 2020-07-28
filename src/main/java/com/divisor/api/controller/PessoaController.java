package com.divisor.api.controller;

import com.divisor.api.entity.Pessoa;
import com.divisor.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {

    @Autowired
    PessoaService pessoaService;


    @GetMapping("/pessoas")
    public List<Pessoa> listarPessoas () {
        return pessoaService.listar();
    }


    @PostMapping("/pessoas")
    public Pessoa salvar (@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }


    @PostMapping("/pessoas/{idPessoa}/relacionar-produto")
    public Pessoa relacionarProduto (@PathVariable Long idPessoa, @RequestParam Long idProduto) {
        return pessoaService.relacionarProduto(idPessoa, idProduto);
    }

}
