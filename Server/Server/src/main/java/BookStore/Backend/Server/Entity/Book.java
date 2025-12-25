package BookStore.Backend.Server.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "book")
@Getter
@Setter
public class Book {

    @Id
    private String id;
    private String title;
    private String description;
    private String url;
    private double price;

}
