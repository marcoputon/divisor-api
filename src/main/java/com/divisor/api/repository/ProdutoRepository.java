package com.divisor.api.repository;

import com.divisor.api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
