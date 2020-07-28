package com.divisor.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @JsonProperty("nome")
    private String nome;


    @ManyToMany
    @JoinTable(
        name = "produto_pessoa",
        joinColumns = { @JoinColumn(name = "id_pessoa") },
        inverseJoinColumns = { @JoinColumn(name = "id_produto") }
    )
    @JsonIgnore
    @ToString.Exclude
    private Set<Produto> produtos = new HashSet<>();


    // Para o set usar o id como chave
    public boolean equals(Object obj) {
        if (!(obj instanceof Pessoa))
            return false;

        if (obj == this)
            return true;

        return this.id.equals(((Pessoa) obj).getId());
    }
}
