package com.github.rycardofarias.vendas.service;

import com.github.rycardofarias.vendas.dto.SaleDTO;
import com.github.rycardofarias.vendas.entities.Sale;
import com.github.rycardofarias.vendas.entities.SaleSuccessDTO;
import com.github.rycardofarias.vendas.entities.SaleSumDTO;
import com.github.rycardofarias.vendas.repositories.SaleRepository;
import com.github.rycardofarias.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }
    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller(){
        return repository.amountGroupeBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return repository.successGroupeBySeller();
    }
}
