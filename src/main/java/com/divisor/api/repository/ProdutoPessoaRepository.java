package com.divisor.api.repository;

import com.divisor.api.entity.ProdutoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPessoaRepository extends JpaRepository<ProdutoPessoa, Long> {

    @Modifying
    @Query("delete from ProdutoPessoa pp where pp.produtoPessoaKey.idProduto = :idProduto")
    void deletarPorProduto(@Param("idProduto") Long idProduto);


    @Modifying
    @Query("delete from ProdutoPessoa pp where pp.produtoPessoaKey.idPessoa = :idPessoa")
    void deletarPorPessoa(@Param("idPessoa") Long idPessoa);

}
