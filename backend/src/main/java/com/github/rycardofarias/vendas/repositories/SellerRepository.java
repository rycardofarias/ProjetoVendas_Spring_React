package com.github.rycardofarias.vendas.repositories;

import com.github.rycardofarias.vendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
