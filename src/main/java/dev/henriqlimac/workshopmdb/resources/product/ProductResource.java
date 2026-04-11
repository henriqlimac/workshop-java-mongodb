package dev.henriqlimac.workshopmdb.resources.product;

import dev.henriqlimac.workshopmdb.domain.product.Product;
import dev.henriqlimac.workshopmdb.dto.product.ProductDTO;
import dev.henriqlimac.workshopmdb.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = service.findAll();
        List<ProductDTO> dtos = list.stream().map(ProductDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(new ProductDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductDTO dto) {
        Product obj = service.fromDTO(dto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductDTO dto, @PathVariable String id) {
        Product obj = service.fromDTO(dto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

