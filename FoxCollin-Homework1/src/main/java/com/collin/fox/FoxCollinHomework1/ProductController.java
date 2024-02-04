package com.collin.fox.FoxCollinHomework1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/***
 * TODO: Send error 404 for first two
 * TODO: Return integer value for category search
 * TODO:
 */
@RestController
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductService productService;


/*
    @GetMapping("/NEW/PRODUCT/{sku}/{name}/{desc}/{cat}/{price}")
    public String createProduct(
            @PathVariable("sku") String sku,
            @PathVariable("name") String name,
            @PathVariable("desc") String desc,
            @PathVariable("cat") String cat,
            @PathVariable("price") String price
    ){
        Product tempProduct = new Product(Integer.valueOf(sku), name, desc, cat, Double.valueOf(price));
        System.out.println(tempProduct.toString());
        return productService.createProduct(tempProduct);
    }

 */



    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/SKU/{SKU}")
    public ResponseEntity<Optional<Product>> getProductBySKU(@PathVariable("SKU") String SKU){
        /***
         * TODO's: Return error 404 if product not found
         */
        ResponseEntity getResponse;
        if(productService.getProductBySKU(Integer.parseInt(SKU)).get() != null){
            getResponse = new ResponseEntity<Optional<Product>>(productService.getProductBySKU(Integer.parseInt(SKU)), HttpStatus.OK);
        }else{
            getResponse = new ResponseEntity<>("HttpStatus.NOT_FOUND.getReasonPhrase()", HttpStatus.NOT_FOUND);
        }
        return getResponse;
    }

    @GetMapping("/CATEGORY/{CATEGORY}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("CATEGORY") String CATEGORY){
        /***
        * TODO's: Return error 404 if product not found
        */
        List<Product> products = productService.getProductsByCategory(CATEGORY);

        return new ResponseEntity<List<Product>>(productService.getProductsByCategory(CATEGORY), HttpStatus.OK);
    }

   @GetMapping("/PRICE/{lowerBound}/{upperBound}")
    public ResponseEntity<List<Product>> getProductsBetweenPrice(@PathVariable("lowerBound") String lowerBound, @PathVariable("upperBound") String upperBound){
        return new ResponseEntity<List<Product>>(productService.getProductsWithinPriceRange(Double.valueOf(lowerBound), Double.valueOf(upperBound)), HttpStatus.OK);
   }

   @GetMapping("/SEARCH/{search}")
    public ResponseEntity<List<Product>> getProductsBySearch(@PathVariable("search")String search){
        String searchQuery = "%"+search+"%";
        return new ResponseEntity<List<Product>>(productService.getProductsBySearch("%"+search+"%"), HttpStatus.OK);
   }

   @PostMapping("/POST")
    public String insertProduct(@RequestBody Product product){
        String postRequest = productService.createProduct(product);
        return postRequest;
   }








}
