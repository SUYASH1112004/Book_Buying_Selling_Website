package BookStore.Backend.Server.Repository;

import BookStore.Backend.Server.Entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookRepo extends MongoRepository<Book,String> {
}
