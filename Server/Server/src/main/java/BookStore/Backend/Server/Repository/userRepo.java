package BookStore.Backend.Server.Repository;

import BookStore.Backend.Server.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<User,String> {
}
