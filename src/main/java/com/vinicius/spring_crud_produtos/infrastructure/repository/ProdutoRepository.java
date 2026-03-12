package com.vinicius.spring_crud_produtos.infrastructure.repository;

import com.vinicius.spring_crud_produtos.controller.dtos.in.ProdutoDTORequest;
import com.vinicius.spring_crud_produtos.infrastructure.entity.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNomeProduto(String nomeProduto);

    Optional<Produto> findByNomeProduto(String nomeProduto);
    // add os metodo save/findById/deleteById e etc

    @Transactional
    Optional<Produto> deleteByNomeProduto(String nome);

}
