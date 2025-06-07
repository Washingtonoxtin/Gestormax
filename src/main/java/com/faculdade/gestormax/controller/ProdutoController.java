package com.faculdade.gestormax.controller;

import com.faculdade.gestormax.model.Produto;
import com.faculdade.gestormax.repository.ClienteRepository;
import com.faculdade.gestormax.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepositoryRepository;

    @GetMapping("/consultar")
    public List<Produto> getAll() {
        return produtoRepositoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id) {
        return produtoRepositoryRepository.findById(id).orElse(null);
    }

    @PostMapping("/cadastrar")
    public Produto create(@RequestBody Produto produto) {
        return produtoRepositoryRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId_produto(id);
        return produtoRepositoryRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepositoryRepository.deleteById(id);
    }
}
