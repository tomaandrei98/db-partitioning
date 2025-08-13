package com.example.partitioning.controller;

import com.example.partitioning.entity.Sale;
import com.example.partitioning.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @GetMapping
    public List<Sale> list() {
        return saleService.findAll();
    }
}
