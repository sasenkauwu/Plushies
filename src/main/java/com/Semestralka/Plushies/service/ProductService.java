package com.Semestralka.Plushies.service;

import com.Semestralka.Plushies.entity.Product;
import com.Semestralka.Plushies.repository.ProductRepository;
import com.Semestralka.Plushies.request.ProductSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Product getProduct(UUID id) {
        return productRepository.findById(id).get();
    }

    public UUID saveProduct(ProductSaveRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());

        var savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public void deleteProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product does not exist!");
        } else {
            productRepository.deleteById(id);
        }
    }

    public void updateProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product does not exist!");
        } else {
            //idk
        }
    }
}
