package com.divisor.api.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Data
@Entity
@Table(name = "produto_pessoa")
public class ProdutoPessoa {

    @EmbeddedId
    private ProdutoPessoaKey produtoPessoaKey;

    @Embeddable
    public static class ProdutoPessoaKey implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "id_produto")
        private Long idProduto;

        @Column(name = "id_pessoa")
        private Long idPessoa;
    }

}
