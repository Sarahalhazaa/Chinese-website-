package com.example.chinese.Controller;

import com.example.chinese.Api.ApiResponse;
import com.example.chinese.Model.Product;
import com.example.chinese.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/Product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    @GetMapping("/get")
    public ResponseEntity getProduct(){
        logger.info("inside the get all Product");
        return ResponseEntity.status(200).body(productService.getProduct());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product ){
        logger.info("inside  add Product");
       productService.addProduct(product);
        return ResponseEntity.ok().body(new ApiResponse("Product added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateProduct(@PathVariable Integer id, @RequestBody @Valid Product product ){
        logger.info("inside Update Product");
        productService.updateProduct(id, product);
        return ResponseEntity.ok().body(new ApiResponse("Product Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        logger.info("inside delete Product");
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(new ApiResponse("Product Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------

    // ------------------------------    1    ----------------------------------
   @PutMapping("/discount/{productId}/{discount}")
    public ResponseEntity discount(@PathVariable Integer productId , @PathVariable Double discount){
       logger.info("inside discount");
       productService.discount(productId,discount);

           return ResponseEntity.ok().body(new ApiResponse("discount successfully"));

   }


    //------------------------------    2    ----------------------------------
   @GetMapping("/bestSeller/{num}")
    public ResponseEntity bestSeller(@PathVariable Integer num){
       logger.info("inside best Seller");
        return ResponseEntity.status(200).body( productService.bestSeller(num));
    }

    //------------------------------    3    ----------------------------------
    @GetMapping("/bestEvaluation/{num}")
    public ResponseEntity bestEvaluation(@PathVariable Integer num){
        logger.info("inside best Evaluation");
        return ResponseEntity.status(200).body( productService.bestEvaluation(num));
    }
    }

