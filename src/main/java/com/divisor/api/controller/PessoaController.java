package com.divisor.api.controller;

import com.divisor.api.dto.PessoaDto;
import com.divisor.api.dto.ProdutoDto;
import com.divisor.api.entity.Pessoa;
import com.divisor.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PessoaController {

    @Autowired
    PessoaService pessoaService;


    @GetMapping("/pessoas")
    public Set<PessoaDto> listarPessoas () {
        return PessoaDto.pessoasParaPessoaDtos(pessoaService.listar());
    }


    @PostMapping("/pessoas")
    public PessoaDto salvar (@RequestBody Pessoa pessoa) {
        return new PessoaDto(pessoaService.salvar(pessoa));
    }


    @GetMapping("/pessoas/{idPessoa}")
    public PessoaDto buscarPessoa (@PathVariable Long idPessoa) {
        return new PessoaDto(pessoaService.buscarPessoa(idPessoa));
    }


    @PostMapping("/pessoas/{idPessoa}/produtos")
    public PessoaDto relacionarProduto (@PathVariable Long idPessoa, @RequestParam Long idProduto) {
        return
            new PessoaDto(pessoaService.relacionarProduto(idPessoa, idProduto));
    }

    @GetMapping("/pessoas/{idPessoa}/produtos")
    public Set<ProdutoDto> buscarProdutosPorPessoa (@PathVariable Long idPessoa) {
        return
            ProdutoDto.produtosParaProdutoDtos(
                pessoaService.buscarProdutosPorPessoa(idPessoa)
            );
    }

}
