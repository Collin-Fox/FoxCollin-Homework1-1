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

    public Product getProductBySKU(int SKU){
        return productRepository.findProductBySKU(SKU);
    }


    public List<Product> getProductsByCategory(String CATEGORY){
        return productRepository.findProductByCATEGORY(CATEGORY);
    }

    public int getCategorySize(String CATEGORY){
        List<Product> myList = getProductsByCategory(CATEGORY);
        if(myList.isEmpty())
            return 0;
        return myList.size();
    }


    public List<Product> getProductsWithinPriceRange(double lowerBound, double upperBound){
        return productRepository.findByPRICEBetween(lowerBound, upperBound);
    }

    public List<Product> getProductsBySearch(String search){
        return productRepository.findByNAMELikeOrDESCRIPTIONLike(search, search);
    }

    public boolean isProduct(Product product){
        return productRepository.existsById(product.getSKU());
    }

    public Product createProduct(Product product){
        return  productRepository.save(product);
    }

    public Product deleteProduct(Product product){
      productRepository.deleteById(product.getSKU());
      return product;
    }







}
