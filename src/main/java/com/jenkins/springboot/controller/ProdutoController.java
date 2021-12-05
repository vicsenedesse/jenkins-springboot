package com.jenkins.springboot.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jenkins.springboot.controller.dto.ProdutoRq;
import com.jenkins.springboot.controller.dto.ProdutoRs;
import com.jenkins.springboot.model.Produto;
import com.jenkins.springboot.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/produto")public class ProdutoController {

    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/") 
    public List<ProdutoRs> findAll() {
        var produtos = produtoRepository.findAll();
        return produtos
                .stream()
                .map(ProdutoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}") 
    public ProdutoRs findByProdutoId(@PathVariable("id") Long id) {
        var produto = produtoRepository.getOne(id);
        return ProdutoRs.converter(produto);
    }

    @PostMapping("/produto")  
    public ResponseEntity<String> savePerson(@RequestBody ProdutoRq produto) {
        var t = new Produto();

        t.setDescricao(produto.getDescricao());
        t.setData(produto.getData());
        t.setPreco(produto.getPreco());
        t.setCategoria(produto.getCategoria());
        

        produtoRepository.save(t);
        return ResponseEntity.ok("Sucesso!");
//        return Exception();
    }

    @PutMapping("/{id}") 
    public void updatePerson(@PathVariable("id") Long id, @RequestBody ProdutoRq produto) throws Exception {
        var t = produtoRepository.findById(id);

        if (t.isPresent()) {
            var produtoSave = t.get();
            produtoSave.setDescricao(produto.getDescricao());
            produtoSave.setData(produto.getData());
            produtoSave.setPreco(produto.getPreco());
            produtoSave.setCategoria(produto.getCategoria());

            produtoRepository.save(produtoSave);
        } else {
            throw new Exception("Produto Não encontrado");
        }
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return produtoRepository.findById(id)
               .map(record -> {
                   produtoRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter") 
    public List<ProdutoRs> findPersonByCategoria(@RequestParam("categoria") String categoria) {
        return this.produtoRepository.findByCategoriaContains(categoria)
                .stream()
                .map(ProdutoRs::converter)
                .collect(Collectors.toList());
    }

}