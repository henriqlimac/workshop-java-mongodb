package dev.henriqlimac.dupmapi.config;

import dev.henriqlimac.dupmapi.domain.product.Product;
import dev.henriqlimac.dupmapi.domain.user.User;
import dev.henriqlimac.dupmapi.respositories.product.ProductRepository;
import dev.henriqlimac.dupmapi.respositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        productRepository.deleteAll();

        Product p1 = new Product(null, "Laptop", 1000.0, 5.0);
        Product p2 = new Product(null, "Mouse", 50.0, 10.0);
        Product p3 = new Product(null, "Keyboard", 80.0, 15.0);
        Product p4 = new Product(null, "Monitor", 300.0, 2.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        User maria = new User("111111111111111111");
        maria.getProducts().addAll(Arrays.asList(p1, p2));

        User alex = new User("222222222222222222");
        alex.getProducts().addAll(Arrays.asList(p3));

        User bob = new User("333333333333333333");
        bob.getProducts().addAll(Arrays.asList(p4));

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
