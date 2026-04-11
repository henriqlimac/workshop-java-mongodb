package dev.henriqlimac.dupmapi.services.product;

import dev.henriqlimac.dupmapi.domain.product.Product;
import dev.henriqlimac.dupmapi.dto.product.ProductDTO;
import dev.henriqlimac.dupmapi.respositories.product.ProductRepository;
import dev.henriqlimac.dupmapi.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product fromDTO(ProductDTO dto) {
        return new Product(dto.getId(), dto.getName(), dto.getAverageRange(), dto.getTolerance());
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public Product insert(Product product) {
        return repository.insert(product);
    }

    public Product update(Product product) {
        Product newObj = findById(product.getId());
        updateData(newObj, product);
        return repository.save(newObj);
    }

    private void updateData(Product newObj, Product product) {
        newObj.setName(product.getName());
        newObj.setAverageRange(product.getAverageRange());
        newObj.setTolerance(product.getTolerance());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
