package com.vinicius.spring_crud_produtos.controller;


import com.vinicius.spring_crud_produtos.entity.ProdutoEntity;
import com.vinicius.spring_crud_produtos.repository.ProdutoRepository;
import com.vinicius.spring_crud_produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;
    private final ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ProdutoEntity produto ){
        produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listar(){
        return ResponseEntity.ok(produtoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar
            (@PathVariable Long id,
             @RequestBody ProdutoEntity produto)
    {   return ResponseEntity.ok(produtoService.editar(id, produto)); }
}
