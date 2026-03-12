package com.vinicius.spring_crud_produtos.business;

import com.vinicius.spring_crud_produtos.controller.dtos.in.ProdutoDTORequest;
import com.vinicius.spring_crud_produtos.controller.dtos.out.ProdutoDTOResponse;
import com.vinicius.spring_crud_produtos.controller.mapper.ProdutoConverter;
import com.vinicius.spring_crud_produtos.infrastructure.entity.Produto;
import com.vinicius.spring_crud_produtos.infrastructure.exception.NomeExistenteException;
import com.vinicius.spring_crud_produtos.infrastructure.exception.ResourceNotFoundException;
import com.vinicius.spring_crud_produtos.infrastructure.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoConverter produtoConverter;


    // salvar
    public ProdutoDTOResponse adicionarProduto(ProdutoDTORequest dto) {

        verificarNomeExiste(dto.getNomeProduto());

        Produto entity = produtoConverter.paraEntity(dto);

        return produtoConverter.paraDTO(produtoRepository.save(entity));
    }

    // Listagem De Produtos
    public List<ProdutoDTOResponse> listarProdutos(){

        List<Produto> lista = produtoRepository.findAll();

        return produtoConverter.converterListDTO(lista);
    }

    // Buscar Por Nome
    public ProdutoDTOResponse buscarProdutoPorNome(String nome){

        Produto entity = produtoRepository.findByNomeProduto(nome).orElseThrow(
                () -> new ResourceNotFoundException("Nome de produto nao encontrado! : ")
        );

        return produtoConverter.paraDTO(entity);
    }

    // Delete Por Nome
    public void deletarPorNome(String nome){
        produtoRepository.deleteByNomeProduto(nome).orElseThrow(
                () -> new ResourceNotFoundException("Nome invalido ou inexistente! : ")
        );
    }

    // Atualizar Por Id
    public ProdutoDTOResponse atualizarProdutoPorId(Long id,ProdutoDTORequest dto){

        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id nao encontrado! : ")
        );

        produto.setNomeProduto(dto.getNomeProduto() != null ? dto.getNomeProduto() : produto.getNomeProduto());
        produto.setValorProduto(dto.getValorProduto() != null ? dto.getValorProduto() : produto.getValorProduto());
        produto.setQuantidadeEmEstoque(dto.getQuantidadeEmEstoque() != null  ? dto.getQuantidadeEmEstoque() : produto.getQuantidadeEmEstoque());

        return produtoConverter.paraDTO(produtoRepository.save(produto));
    }


    public void verificarNomeExiste(String nome){
        if (produtoRepository.existsByNomeProduto(nome)){
            throw new NomeExistenteException("Nome existente");
        }
    }

}
