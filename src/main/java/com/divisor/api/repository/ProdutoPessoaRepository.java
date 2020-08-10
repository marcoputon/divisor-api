package com.divisor.api.repository;

import com.divisor.api.entity.ProdutoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPessoaRepository extends JpaRepository<ProdutoPessoa, Long> {

    void deleteByIdProduto(Long idProduto);

}
