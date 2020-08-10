package com.divisor.api.controller;

import com.divisor.api.dto.PessoaDto;
import com.divisor.api.dto.ProdutoDto;
import com.divisor.api.entity.Produto;
import com.divisor.api.service.PessoaService;
import com.divisor.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    PessoaService pessoaService;


    @GetMapping("/produtos")
    public Set<ProdutoDto> listarPessoas () {
        return ProdutoDto.produtosParaProdutoDtos(produtoService.listar());
    }


    @PostMapping("/produtos")
    public ProdutoDto salvar (@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }


    @GetMapping("/produtos/{idProduto}")
    public ProdutoDto buscarProduto (@PathVariable Long idProduto) {
        return new ProdutoDto(produtoService.buscarProduto(idProduto));
    }


    @PostMapping("/produtos/{idProduto}/pessoas")
    public ProdutoDto relacionarProduto (@PathVariable Long idProduto, @RequestParam Long idPessoa) {
        return
            new ProdutoDto(produtoService.relacionarProduto(idPessoa, idProduto));
    }


    @GetMapping("/produtos/{idProduto}/pessoas")
    public Set<PessoaDto> buscarProdutosPorPessoa (@PathVariable Long idProduto) {
        return
            PessoaDto.pessoasParaPessoaDtos(
                produtoService.buscarPessoasPorProduto(idProduto)
            );
    }


    @DeleteMapping("/produtos/{idProduto}")
    public ResponseEntity<Void> deletarProduto (@PathVariable Long idProduto) {
        produtoService.deletarProduto(idProduto);
        return ResponseEntity.ok().build();
    }

}
