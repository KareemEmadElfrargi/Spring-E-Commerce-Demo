package com.kareem.Spring_E_Commerce_Demo.controller;

import com.kareem.Spring_E_Commerce_Demo.model.Product;
import com.kareem.Spring_E_Commerce_Demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product.getId() > 0) {
            return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart("product") Product product, @RequestPart("ImageFile") MultipartFile imageFile) {
        Product saveProduct = null;
        try {
            saveProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<?> getImageByProductId(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);

        if (product.getId() > 0) {
            return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestPart("product") Product product, @RequestPart("ImageFile") MultipartFile imageFile) {
        Product updatedProduct = null;
        try {
            updatedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>("Updated Successfully.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        Product product = productService.getProductById(id);

        if (product !=null){
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> products = productService.searchProducts(keyword);
        System.out.println("Searching with "+keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);

    }


}
