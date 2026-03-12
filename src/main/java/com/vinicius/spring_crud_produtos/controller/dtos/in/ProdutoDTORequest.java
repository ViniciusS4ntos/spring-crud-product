package com.vinicius.spring_crud_produtos.controller.dtos.in;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProdutoDTORequest {

    private Long idProduto;
    private String nomeProduto;
    private BigDecimal valorProduto;
    private String gramaProduto;
    private Integer quantidadeEmEstoque;

}
