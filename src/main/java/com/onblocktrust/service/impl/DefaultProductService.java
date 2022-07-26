package com.onblocktrust.service.impl;

import com.onblocktrust.models.Product;
import com.onblocktrust.repos.ProductRepository;
import com.onblocktrust.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DefaultProductService implements ProductService {

    @Inject
    ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.listAll();
    }
}
