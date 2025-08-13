package com.example.partitioning.service;

import com.example.partitioning.entity.Sale;

import java.util.List;

public interface SaleService {
    Sale save(Sale sale);

    List<Sale> findAll();
}
