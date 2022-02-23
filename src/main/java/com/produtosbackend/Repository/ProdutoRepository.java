package com.produtosbackend.Repository;

import com.produtosbackend.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long id);
}
