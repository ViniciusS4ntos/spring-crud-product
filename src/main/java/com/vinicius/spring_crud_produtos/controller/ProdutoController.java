package com.vinicius.spring_crud_produtos.controller;


import com.vinicius.spring_crud_produtos.controller.dtos.in.ProdutoDTORequest;
import com.vinicius.spring_crud_produtos.controller.dtos.out.ProdutoDTOResponse;
import com.vinicius.spring_crud_produtos.infrastructure.repository.ProdutoRepository;
import com.vinicius.spring_crud_produtos.business.ProdutoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTOResponse> salvarProduto(@RequestBody ProdutoDTORequest dto){
        return ResponseEntity.ok(produtoService.adicionarProduto(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTOResponse>> listarProdutos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<ProdutoDTOResponse> buscarProdutoNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoService.buscarProdutoPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPorNome(@RequestParam("produto") String nome){
        produtoService.deletarPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProdutoDTOResponse> atualizarPorId(@RequestParam("id") Long id,
                                                             @RequestBody ProdutoDTORequest  dto){
        return ResponseEntity.ok(produtoService.atualizarProdutoPorId(id, dto));
    }

}
