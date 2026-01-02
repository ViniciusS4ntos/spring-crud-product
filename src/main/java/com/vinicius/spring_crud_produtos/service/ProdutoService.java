package com.vinicius.spring_crud_produtos.service;

import com.vinicius.spring_crud_produtos.entity.ProdutoEntity;
import com.vinicius.spring_crud_produtos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    //POST
    public void  salvar(ProdutoEntity produto){
        produtoRepository.save(produto);
    }

    //GET
    public List<ProdutoEntity> listar(){
        return produtoRepository.findAll();
    }

    //DELETE
    public void deletar(Long Id){
        produtoRepository.deleteById(Id);
    }

    //PUT
    public ProdutoEntity editar(Long id, ProdutoEntity produtoAtualizado){

        ProdutoEntity prod = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not found")
        );
        if (produtoAtualizado.getNomeProduto() != null) {
            prod.setNomeProduto(produtoAtualizado.getNomeProduto());
        }

        if (produtoAtualizado.getValorProduto() != null) {
            prod.setValorProduto(produtoAtualizado.getValorProduto());
        }

        if (produtoAtualizado.getQuantidadeEmEstoque() != null) {
            prod.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
        }

        return produtoRepository.save(prod); // UPDATE

    }
}
