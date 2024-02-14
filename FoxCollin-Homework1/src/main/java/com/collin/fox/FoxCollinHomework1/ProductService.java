package com.collin.fox.FoxCollinHomework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Autogen of the repository
    @Autowired
    private ProductRepository productRepository;

    // Gets List object of all products from the repository
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Gets a single product by its sku from repository
    public Product getProductBySKU(int SKU){
        return productRepository.findProductBySKU(SKU);
    }

    // Gets a list of products by a category from repository
    public List<Product> getProductsByCategory(String CATEGORY){
        return productRepository.findProductByCATEGORY(CATEGORY);
    }

    // returns an integer of the size of a category ref getProductsByCategory
    public int getCategorySize(String CATEGORY){
        List<Product> myList = getProductsByCategory(CATEGORY);
        if(myList.isEmpty())
            return 0;
        return myList.size();
    }

    // Gets a list of products between price from repository
    public List<Product> getProductsWithinPriceRange(double lowerBound, double upperBound){
        return productRepository.findByPRICEBetween(lowerBound, upperBound);
    }

    // Gets a list of products by a search within the name or description from repository
    public List<Product> getProductsBySearch(String search){
        return productRepository.findByNAMELikeOrDESCRIPTIONLike(search, search);
    }

    // Returns true if the product exists by its sku
    public boolean isProduct(Product product){
        return productRepository.existsById(product.getSKU());
    }

    // saves a new product or an edit to a product to repository
    public Product createProduct(Product product){
        return  productRepository.save(product);
    }

    // Returns a list of categories from
    public List<SummaryInterface> getSummary(){
        return productRepository.findProductSummary();
    }

    // Removes a product from the repository
    public Product deleteProduct(Product product){
      productRepository.deleteById(product.getSKU());
      return product;
    }







}
