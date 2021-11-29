package com.jenkins.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;


public class ProdutoControllerTeste {
    
    @Autowired
    private ProdutoController produtoController;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.produtoController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarProduto(){
      .given()
        .accept(ContentType.JSON)
      .when()
        .get("/api/produtos/{codigo}", 1L)
      .then()
        .statusCode(HttpStatus.OK.value());
    }
}
