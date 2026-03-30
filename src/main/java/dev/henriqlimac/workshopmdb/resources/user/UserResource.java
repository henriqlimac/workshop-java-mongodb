package dev.henriqlimac.workshopmdb.resources.user;

import dev.henriqlimac.workshopmdb.domain.user.User;
import dev.henriqlimac.workshopmdb.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }
}
