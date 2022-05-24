package com.bnta.ecommerce.services;

import com.bnta.ecommerce.models.Product;
import com.bnta.ecommerce.models.Stock;
import com.bnta.ecommerce.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    public static Object findAll;
    @Autowired
    private StockRepository stockRepository;

    public StockService() {
    }

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

   public List<Stock> getAll() {
       return  stockRepository.findAll();
   }

   public Optional<Stock> findById(Long id){
        return stockRepository.findById(id);
   }

   public Stock addToStock(Long id, Product product){
       Stock stock = new Stock(0, product);
       stock.setId(id);
       return stockRepository.save(stock);
   }
}
