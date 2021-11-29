package com.jenkins.springboot.controller.dto;

import com.jenkins.springboot.model.Produto;
import java.util.List;

public class ProdutoRs {
    private Long id;
    private String descricao;
    private String data;
    private String preco;
    private String categoria;


   public static ProdutoRs converter(Produto t) {

       var produto = new ProdutoRs();

       produto.setId(t.getId());
       produto.setDescricao(t.getDescricao());
       produto.setData(t.getData());
       produto.setPreco(t.getPreco());
       produto.setCategoria(t.getCategoria());
    
       return produto;
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
