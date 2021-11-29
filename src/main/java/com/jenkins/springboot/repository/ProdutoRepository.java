package com.jenkins.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jenkins.springboot.model.Produto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    
    List<Produto> findByCategoriaContains(String categoria);
}
