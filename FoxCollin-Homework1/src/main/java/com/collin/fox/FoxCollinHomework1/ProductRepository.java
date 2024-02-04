package com.collin.fox.FoxCollinHomework1;
import com.collin.fox.FoxCollinHomework1.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findProductByCATEGORY(String CATEGORY);
    List<Product> findByPRICEBetween(double lowerBound, double upperBound);

    List<Product> findByNAMELikeOrDESCRIPTIONLike(String nameSearch, String descriptionSearch);
}
