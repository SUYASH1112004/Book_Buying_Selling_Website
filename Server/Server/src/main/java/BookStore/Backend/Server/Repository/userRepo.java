package BookStore.Backend.Server.Repository;

import BookStore.Backend.Server.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface userRepo extends MongoRepository<User,String> {
    boolean existsByEmail(String email);

    Optional<User>findByEmail(String Email);

}
