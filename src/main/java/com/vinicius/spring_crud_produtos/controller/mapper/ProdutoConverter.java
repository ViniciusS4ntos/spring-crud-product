package com.vinicius.spring_crud_produtos.controller.mapper;

import com.vinicius.spring_crud_produtos.controller.dtos.in.ProdutoDTORequest;
import com.vinicius.spring_crud_produtos.controller.dtos.out.ProdutoDTOResponse;
import com.vinicius.spring_crud_produtos.infrastructure.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoConverter {

    // DTORequest -> Entity
    public Produto paraEntity(ProdutoDTORequest dto){
        return Produto.builder()
                .idProduto(dto.getIdProduto())
                .nomeProduto(dto.getNomeProduto() != null ? dto.getNomeProduto() : null)
                .valorProduto(dto.getValorProduto() != null ? dto.getValorProduto() : null)
                .quantidadeEmEstoque(dto.getQuantidadeEmEstoque() != null ? dto.getQuantidadeEmEstoque() : null)
                .build();
    }

    // Entity -> DTOResponse
    public ProdutoDTOResponse paraDTO(Produto entity){
        return ProdutoDTOResponse.builder()
                .idProduto(entity.getIdProduto())
                .nomeProduto(entity.getNomeProduto() != null ? entity.getNomeProduto() : null)
                .valorProduto(entity.getValorProduto() != null ? entity.getValorProduto() : null)
                .quantidadeEmEstoque(entity.getQuantidadeEmEstoque() !=  null ? entity.getQuantidadeEmEstoque() : null)
                .build();


    }

    // ListaEntity -> ListaDTO
    public List<ProdutoDTOResponse> converterListDTO(List<Produto> entitys){

        List<ProdutoDTOResponse> lista = new ArrayList<>();

        for (int i = 0; i < entitys.size(); i++){
             lista.add(paraDTO(entitys.get(i)));

        }

        return lista;
    }






}
