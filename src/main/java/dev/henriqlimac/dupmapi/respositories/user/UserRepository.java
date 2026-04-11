package dev.henriqlimac.dupmapi.respositories.user;

import dev.henriqlimac.dupmapi.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
