package com.vinicius.spring_crud_produtos.controller.dtos.out;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProdutoDTOResponse {

    private Long idProduto;
    private String nomeProduto;
    private BigDecimal valorProduto;
    private Integer quantidadeEmEstoque;

}
