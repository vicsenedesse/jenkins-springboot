//package com.jenkins.springboot;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.junit.jupiter.api.BeforeEach;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import io.restassured.http.ContentType;
//import io.restassured.module.mockmvc.RestAssuredMockMvc;
//import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
//import com.jenkins.springboot.repository.ProdutoRepository;
//import com.jenkins.springboot.model.Produto;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.mockito.InjectMocks;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// 
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status.isOk;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.junit.Before;
//
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import com.jenkins.springboot.controller.ProdutoController;
//import com.jenkins.springboot.repository.ProdutoRepository;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import com.jenkins.springboot.controller.dto.ProdutoRs;
//import org.junit.Assert;
//
//// import static MockMvcRequestBuilders.*;
//// import static MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class ProdutoControllerTests {
//
//	// @Test
//	// void contextLoads() {
//	// }
//
//  //@BeforeEach
//  //  public void setUp() throws Exception {
//  //      MockitoAnnotations.initMocks(this);
//  //      mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
//  //  }
//
//
//  //@Autowired
//  //private MockMvc mockMvc;
//
//  //@Autowired
//  //private ProdutoRepository produtoRepository;
////
//  //
//  //private ProdutoController produto;
////
//  //
//  //private ProdutoController produtoController;
////
//  //@Test
//  //public void TestCreate(){
//  //  Produto p = new Produto();
//  //  p.setId(1L);
//  //  p.setDescricao("Violão");
//  //  p.setData("21/12/2001");
//  //  p.setPreco("2110");
//  //  p.setCategoria("Musica");
////
//  //  produtoRepository.save(p);
//  //  Assert.assertNotNull(produtoRepository.findById(1L));
//  //}
//    
//  //@InjectMocks
//  //private ProdutoController produtoController;
//  //ProdutoController = new ProdutoController();
//
//  //@MockBean
//  //private ProdutoRepository produtoRepository;
//  //ProdutoRepository = new ProdutoRepository();
//
//
//  //@BeforeEach
//  //  public void setUp() throws Exception {
//  //      MockitoAnnotations.initMocks(this);
//  //      mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
//  //  }
//
//  //@Test
//  //public void testGetAll() throws Exception{
//  //  mockMvc.perform(get("http://localhost:8080/api/produto/")
//  //    .accept(MediaType.APPLICATION_JSON))
//  //    .andExpect(status().isOk());
//  //  //   .andExpect(content().json("[]"));
//  //}
////
//  //@Test
//  //public void testGetAllFail() throws Exception{
//  //  mockMvc.perform(get("/api/produto/")
//  //    .accept(MediaType.APPLICATION_JSON))
//  //    .andExpect(status().isOk())
//  //    .andExpect(content().string("Hello!!"));
//  //}
//
////   @Test
////    public void testHome() throws Exception {
////        mockMvc.perform(get("/api/produto/"))
////            .andExpect(status().isOk())
////            .andExpect(forwardedUrl("err0o"));
////    }
//
////     @Test
////     public void testPersistenceStatus() throws Exception {
//
////         mockMvc.perform(get("/roundtrip"))
////             .andExpect(status().isOk())
////             .andExpect(forwardedUrl("WEB-INF/pages/roundtrip.jsp"))
////             .andExpect(model().attributeExists("RoundTrip"));
////     }
//
//}
//
////ARQUIVO TESTE PARA SALVAR ÚLTIMA VERSÂO
