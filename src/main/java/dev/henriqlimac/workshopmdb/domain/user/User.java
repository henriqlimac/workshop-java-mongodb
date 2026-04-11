package dev.henriqlimac.workshopmdb.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import dev.henriqlimac.workshopmdb.domain.product.Product;

@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String discordId;

    private List<Product> products = new ArrayList<>();

    public User() {
    }

    public User(String discordId) {
        this.discordId = discordId;
    }

    public String getId() {
        return id;
    }

    public String getDiscordId() {
        return discordId;
    }

    public void setDiscordId(String discordId) {
        this.discordId = discordId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
