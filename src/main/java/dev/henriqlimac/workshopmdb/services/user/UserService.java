package dev.henriqlimac.workshopmdb.services.user;

import dev.henriqlimac.workshopmdb.domain.user.User;
import dev.henriqlimac.workshopmdb.dto.user.UserDTO;
import dev.henriqlimac.workshopmdb.respositories.user.UserRepository;
import dev.henriqlimac.workshopmdb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User fromDTO(UserDTO dto) {
        return new User(dto.getName(), dto.getEmail());
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
}
