package com.project.springboot.controller.dto;

import com.project.springboot.model.Product;
import java.util.List;

public class ProductRs {

    private Long id;
    private String descricao;
    private String data;
    private String preco;
    private String categoria;


   public static ProductoRs converter(Product t) {

       var product = new ProductRs();

       product.setId(t.getId());
       product.setDescricao(t.getDescricao());
       product.setData(t.getData());
       product.setPreco(t.getPreco());
       product.setCategoria(t.getCategoria());
    
       return product;
   }


   public Long getId() { return id; }
   
   public void setId(Long id) { this.id = id; }


   public String getDescricao() { return descricao; }
   
   public void setDescricao(String descricao) { this.descricao = descricao; }


   public String getData() { return data; }
   
   public void setData(String data) { this.data = data; }


   public String getPreco() { return preco; }
   
   public void setPreco(String preco) { this.preco = preco; }


   public String getCategoria() { return categoria; }
   
   public void setCategoria(String categoria) { this.categoria = categoria; }

}