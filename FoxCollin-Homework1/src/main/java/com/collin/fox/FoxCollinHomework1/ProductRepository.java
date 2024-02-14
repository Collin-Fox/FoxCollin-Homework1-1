package com.collin.fox.FoxCollinHomework1;
import com.collin.fox.FoxCollinHomework1.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    // Query to find product by its sku
    Product findProductBySKU(int SKU);

    //Query to return product list by products category
    List<Product> findProductByCATEGORY(String CATEGORY);

    //Query for find product between an upperbound and lowerbound price
    List<Product> findByPRICEBetween(double lowerBound, double upperBound);

    //Query for find by search in name or description
    List<Product> findByNAMELikeOrDESCRIPTIONLike(String nameSearch, String descriptionSearch);

    //Query for Product summary
    @Query(value = "SELECT " +
            " products.CATEGORY AS category " +
            ", SUM(products.PRICE) AS priceSum " +
            ", COUNT(products.SKU) AS productCount " +
            ", AVG(products.PRICE) AS priceAvg " +
            "FROM products " +
            "GROUP BY CATEGORY",
            nativeQuery = true
    )
    List<SummaryInterface> findProductSummary();
}
