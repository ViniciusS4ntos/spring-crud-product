package com.vinicius.spring_crud_produtos.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "Produtos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nomeProduto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#0.00")
    private BigDecimal valorProduto;

    private Integer quantidadeEmEstoque;
}