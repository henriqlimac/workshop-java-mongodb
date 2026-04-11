package dev.henriqlimac.dupmapi.respositories.product;

import dev.henriqlimac.dupmapi.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

