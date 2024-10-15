package com.example.sales_streamer.repo;

import com.example.sales_streamer.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepo extends JpaRepository<Sales,String> {
}
