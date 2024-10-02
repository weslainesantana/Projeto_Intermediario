package com.weslaine.projeto_intermediario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weslaine.projeto_intermediario.models.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
