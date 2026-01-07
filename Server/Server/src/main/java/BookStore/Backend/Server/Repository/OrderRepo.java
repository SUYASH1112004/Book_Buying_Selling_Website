package BookStore.Backend.Server.Repository;

import BookStore.Backend.Server.Entity.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository <Orders,String> {
}
