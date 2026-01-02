package com.vinicius.spring_crud_produtos.repository;

import com.vinicius.spring_crud_produtos.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    // add os metodo save/findById/deleteById e etc
}
