package com.github.rycardofarias.vendas.repositories;

import com.github.rycardofarias.vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
