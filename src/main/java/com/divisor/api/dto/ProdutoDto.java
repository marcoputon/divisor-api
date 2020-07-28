package com.divisor.api.dto;

import com.divisor.api.entity.Pessoa;
import com.divisor.api.entity.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class ProdutoDto {
    private Produto produto;
    private Set<Pessoa> pessoas;

    public ProdutoDto (Produto produto) {
        this.produto = produto;
        this.pessoas = produto.getPessoas();
    }

    public static Set<ProdutoDto> produtosParaProdutoDtos (Collection<Produto> produtos) {
        Set<ProdutoDto> produtoDtos = new HashSet<>();
        for (Produto p : produtos) {
            produtoDtos.add(new ProdutoDto(p));
        }
        return produtoDtos;
    }
}
