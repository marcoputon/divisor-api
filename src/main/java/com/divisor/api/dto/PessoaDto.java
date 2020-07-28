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
public class PessoaDto {
    private Pessoa pessoa;
    private Set<Produto> produtos;

    public PessoaDto (Pessoa pessoa) {
        this.pessoa = pessoa;
        this.produtos = pessoa.getProdutos();
    }

    public static Set<PessoaDto> pessoasParaPessoaDtos (Collection<Pessoa> pessoas) {
        Set<PessoaDto> pessoaDtos = new HashSet<>();
        for (Pessoa p : pessoas) {
            pessoaDtos.add(new PessoaDto(p));
        }
        return pessoaDtos;
    }
}
