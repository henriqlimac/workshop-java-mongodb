package dev.henriqlimac.workshopmdb.respositories.user;

import dev.henriqlimac.workshopmdb.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
