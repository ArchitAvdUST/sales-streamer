package com.example.sales_streamer.controller;

import com.example.sales_streamer.entity.Sales;
import com.example.sales_streamer.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/sales")
    public Sales addSales(@RequestBody Sales sales) {
        return salesService.addSales(sales);
    }

    @GetMapping("/sales/{id}")
    public Sales getSalesById(@PathVariable String id) {
        return salesService.getSalesById(id);
    }

    @GetMapping("/sales")
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/payment-method")
     public Map<String,List<Sales>> getSalesByPaymentMethod() {
        return salesService.groupSalesByPaymentMethod();
    }

    @GetMapping("/countByLocation")
    public Map<String, Long> countSalesByLocation() {
        return salesService.countSalesByLocation();
    }

    @GetMapping("/{date}")
    public Map<String,Long> groupSalesByDateInLocation(@PathVariable String date) {
        return salesService.groupSalesByDateInLocation(date);
    }
}
