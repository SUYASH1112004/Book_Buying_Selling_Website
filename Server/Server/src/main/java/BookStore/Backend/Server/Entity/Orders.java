package BookStore.Backend.Server.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "orders")
@Getter
@Setter

public class Orders {

    @Id
    private String Id;

    private String userId;
    private String bookId;
    private String bookTitle;
    private double price;
    private String status;
    private Date orderTime;
}
