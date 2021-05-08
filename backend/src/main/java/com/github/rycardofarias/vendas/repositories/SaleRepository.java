package com.github.rycardofarias.vendas.repositories;

import com.github.rycardofarias.vendas.entities.Sale;
import com.github.rycardofarias.vendas.entities.SaleSuccessDTO;
import com.github.rycardofarias.vendas.entities.SaleSumDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query("SELECT new com.github.rycardofarias.vendas.entities.SaleSumDTO(obj.seller, SUM(obj.amount)) "
            + "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupeBySeller();

    @Query("SELECT new com.github.rycardofarias.vendas.entities.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupeBySeller();
}
