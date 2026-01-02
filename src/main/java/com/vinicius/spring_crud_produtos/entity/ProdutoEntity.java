package com.vinicius.spring_crud_produtos.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Produtos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nomeProduto;
    private Double valorProduto;
    private Integer quantidadeEmEstoque;
}