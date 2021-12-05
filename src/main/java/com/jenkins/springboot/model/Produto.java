package com.jenkins.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "produto")

public class Produto{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "id")
   private Long id;

   @Column(name = "descricao")
   private String descricao = "";

   @Column(name = "data")
   private String data = "";

   @Column(name = "preco")
   private String preco = "";

   @Column(name = "categoria")
   private String categoria = "";

     
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

