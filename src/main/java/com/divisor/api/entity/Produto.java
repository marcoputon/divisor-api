package com.divisor.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @JsonProperty("nome")
    private String nome;

    @Column(name = "valor")
    @JsonProperty("valor")
    private BigDecimal valor;

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    @ToString.Exclude
    private Set<Pessoa> pessoas = new HashSet<>();


    // Para o set usar o id como chave
    public boolean equals(Object obj) {
        if (!(obj instanceof Produto))
            return false;

        if (obj == this)
            return true;

        return this.id.equals(((Produto) obj).getId());
    }

}
