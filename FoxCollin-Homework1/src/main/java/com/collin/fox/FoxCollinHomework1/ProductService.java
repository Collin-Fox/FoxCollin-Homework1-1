package com.collin.fox.FoxCollinHomework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductBySKU(int SKU){
        return productRepository.findById(SKU);
    }


    public List<Product> getProductsByCategory(String CATEGORY){
        return productRepository.findProductByCATEGORY(CATEGORY);
    }

    public List<Product> getProductsWithinPriceRange(double lowerBound, double upperBound){
        return productRepository.findByPRICEBetween(lowerBound, upperBound);
    }

    public List<Product> getProductsBySearch(String search){
        return productRepository.findByNAMELikeOrDESCRIPTIONLike(search, search);
    }

    public String createProduct(Product product){
        productRepository.save(product);
        return "product";
    }






}
