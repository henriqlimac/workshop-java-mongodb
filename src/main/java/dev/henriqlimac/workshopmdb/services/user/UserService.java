package dev.henriqlimac.workshopmdb.services.user;

import dev.henriqlimac.workshopmdb.domain.user.User;
import dev.henriqlimac.workshopmdb.respositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
