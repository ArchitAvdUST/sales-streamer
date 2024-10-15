package com.example.sales_streamer.service;

import com.example.sales_streamer.entity.Sales;
import com.example.sales_streamer.repo.SalesRepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    private SalesRepo salesRepo;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public SalesService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public Map<String, List<Sales>> groupSalesByPaymentMethod() {
        return jpaStreamer.stream(Sales.class)
                .collect(Collectors.groupingBy(Sales::getPaymentMethod));
    }

    public Map<String, Long> countSalesByLocation() {
        return jpaStreamer.stream(Sales.class)
                .collect(Collectors.groupingBy(Sales::getLocation, Collectors.counting()));
    }

    public Map<String, Long> groupSalesByDateInLocation(String date) {
        return jpaStreamer.stream(Sales.class)
                .filter(sales -> Objects.equals(sales.getSalesDate(), date))
                .collect(Collectors.groupingBy(Sales::getLocation, Collectors.counting()));
    }

    public Sales addSales(Sales sales) {
        return salesRepo.save(sales);
    }

    public Sales getSalesById(String salesId) {
        return salesRepo.findById(salesId).orElse(null);
    }

    public List<Sales> getAllSales() {
        return salesRepo.findAll();
    }




}
