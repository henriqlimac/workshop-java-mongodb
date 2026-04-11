package dev.henriqlimac.dupmapi.services.user;

import dev.henriqlimac.dupmapi.domain.user.User;
import dev.henriqlimac.dupmapi.dto.user.UserDTO;
import dev.henriqlimac.dupmapi.respositories.user.UserRepository;
import dev.henriqlimac.dupmapi.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User fromDTO(UserDTO dto) {
        User user = new User(dto.getDiscordId());
        user.setProducts(dto.getProducts());
        return user;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElse(null);

        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }

        return user;
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
