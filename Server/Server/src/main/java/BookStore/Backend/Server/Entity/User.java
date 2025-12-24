package BookStore.Backend.Server.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@Setter
public class User {

    @Id
    private String Id;
    private String Email;
    private String Phone;
    private String Address;
    private String Password;
}
