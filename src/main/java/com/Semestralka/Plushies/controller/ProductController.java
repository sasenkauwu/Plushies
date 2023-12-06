package com.Semestralka.Plushies.controller;

import com.Semestralka.Plushies.entity.Product;
import com.Semestralka.Plushies.request.ProductSaveRequest;
import com.Semestralka.Plushies.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable UUID id) {
        return productService.getProduct(id);
    }

    @PostMapping("/save")
    public UUID saveProduct(@RequestBody ProductSaveRequest request) {
        return productService.saveProduct(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @PutMapping("update/{id}")
    public void updateProduct(@PathVariable UUID id) {
        productService.updateProduct(id);
    }
}
