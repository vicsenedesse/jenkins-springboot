package com.jenkins.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.jenkins.springboot.repository.ProdutoRepository;
import com.jenkins.springboot.model.Produto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;

import org.junit.Before;

import com.jenkins.springboot.controller.ProdutoController;
import com.jenkins.springboot.repository.ProdutoRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.jenkins.springboot.controller.dto.ProdutoRs;
import org.junit.Assert;


@SpringBootTest
@AutoConfigureMockMvc
class SpringbootApplicationTests {

  @Autowired
  private ProdutoRepository produtoRepository;

  
  private ProdutoController produto;

  
  private ProdutoController produtoController;

  @Test
  public void TestCreateExpectNotNull(){
    Produto p = new Produto();
    p.setId(1L);
    p.setDescricao("Violão");
    p.setData("21/12/2001");
    p.setPreco("2110");
    p.setCategoria("Musica");

    produtoRepository.save(p);
    Assert.assertNotNull(produtoRepository.findById(1L));
  }

  //@Test
  //public void TestCreateExpectNull(){
  //  Produto p = new Produto();
  //  p.setId(1L);
  //  p.setDescricao("Violão");
  //  p.setData("21/12/2001");
  //  p.setPreco("2110");
  //  p.setCategoria("Musica");
//
  //  produtoRepository.save(p);
  //  Assert.assertNull(produtoRepository.findById(1L));
  //}

}
