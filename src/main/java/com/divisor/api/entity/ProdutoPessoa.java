package com.divisor.api.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "produto_pessoa")
@IdClass(ProdutoPessoaKey.class)
public class ProdutoPessoa {

    @Id
    @Column(name = "id_produto")
    private Long idProduto;

    @Id
    @Column(name = "id_pessoa")
    private Long idPessoa;

}
