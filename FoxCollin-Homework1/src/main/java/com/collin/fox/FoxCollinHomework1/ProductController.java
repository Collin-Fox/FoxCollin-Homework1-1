package com.collin.fox.FoxCollinHomework1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductService productService;

    //DONE
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //DONE
    @GetMapping("/SKU/{SKU}")
    public ResponseEntity<Product> getProductBySKU(@PathVariable("SKU") String SKU){
        Product product = productService.getProductBySKU(Integer.parseInt(SKU));
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DONE
    @GetMapping("/{CATEGORY}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("CATEGORY") String CATEGORY){
        List<Product> products = productService.getProductsByCategory(CATEGORY);
        if(!products.isEmpty()){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DONE
    @GetMapping("/COUNT/{CATEGORY}")
    public ResponseEntity<Integer> getProductCount(@PathVariable("CATEGORY") String CATEGORY){
        int listSize = productService.getCategorySize(CATEGORY);
        if(listSize != 0){
            return new ResponseEntity<>(listSize, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DONE
   @GetMapping("/PRICE/LOWER/{lowerBound}/UPPER/{upperBound}")
    public ResponseEntity<List<Product>> getProductsBetweenPrice(@PathVariable("lowerBound") String lowerBound, @PathVariable("upperBound") String upperBound){
        return new ResponseEntity<List<Product>>(productService.getProductsWithinPriceRange(Double.valueOf(lowerBound), Double.valueOf(upperBound)), HttpStatus.OK);
   }

   //DONE
   @GetMapping("/SEARCH/{search}")
    public ResponseEntity<List<Product>> getProductsBySearch(@PathVariable("search")String search){
        return new ResponseEntity<List<Product>>(productService.getProductsBySearch("%"+search+"%"), HttpStatus.OK);
   }

   //DONE
   @PostMapping(value ="/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody final Product product){
        if(!productService.isProduct(product)){
            return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.OK);
        }else{
            return new ResponseEntity<Product>(product, HttpStatus.FOUND);
        }
   }

   //DONE
   @PutMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> editProduct(@RequestBody final Product product){
        if(productService.isProduct(product)){
            return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
   }

   //DONE
   @DeleteMapping("/product/{SKU}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("SKU") int SKU) throws SQLException {
        Product product = productService.getProductBySKU(SKU);
        if (product != null){
            return new ResponseEntity<>(productService.deleteProduct(product), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   }


    // Graduate Extra Credit Work
   @GetMapping("/summary")
    public List<SummaryInterface> getSummary(){
        return productService.getSummary();
   }









}
