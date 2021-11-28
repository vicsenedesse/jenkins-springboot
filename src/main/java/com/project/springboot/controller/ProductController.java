
package com.crud.produtos.controller;
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


import com.project.springboot.controller.dto.ProductRq;
import com.project.springboot.controller.dto.ProductRs;
import com.project.springboot.model.Product;
import com.project.springboot.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/produto") 
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductRepository produtoRepository;

    public ProdutoController(ProductRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/") 
    public List<ProductRs> findAll() {
        var produtos = produtoRepository.findAll();
        return produtos
                .stream()
                .map(ProductRs::converter)
                .collect(Collectors.toList());
    }




    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}") 
    public ProductRs findByProdutoId(@PathVariable("id") Long id) {
        var produto = produtoRepository.getOne(id);
        return ProductRs.converter(produto);
    }




    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/produto")  
    public ResponseEntity<String> savePerson(@RequestBody ProductRq product) {
        var t = new Produto();

        t.setDescricao(product.getDescricao());
        t.setData(product.getData());
        t.setPreco(product.getPreco());
        t.setCategoria(product.getCategoria());
        

        produtoRepository.save(t);
        return ResponseEntity.ok("Sucesso!");
//        return Exception();
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}") 
    public void updatePerson(@PathVariable("id") Long id, @RequestBody ProductRq product) throws Exception {
        var t = produtoRepository.findById(id);

        if (t.isPresent()) {
            var produtoSave = t.get();
            produtoSave.setDescricao(product.getDescricao());
            produtoSave.setData(product.getData());
            produtoSave.setPreco(product.getPreco());
            produtoSave.setCategoria(product.getCategoria());

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



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter") 
    public List<ProductRs> findPersonByCategoria(@RequestParam("categoria") String categoria) {
        return this.produtoRepository.findByCategoriaContains(categoria)
                .stream()
                .map(ProdutoRs::converter)
                .collect(Collectors.toList());
    }

}