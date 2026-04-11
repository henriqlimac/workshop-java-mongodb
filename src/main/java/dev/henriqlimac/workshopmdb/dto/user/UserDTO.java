package dev.henriqlimac.workshopmdb.dto.user;

import dev.henriqlimac.workshopmdb.domain.product.Product;
import dev.henriqlimac.workshopmdb.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String id;
    private String discordId;
    private List<Product> products = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.discordId = user.getDiscordId();
        this.products = user.getProducts();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
