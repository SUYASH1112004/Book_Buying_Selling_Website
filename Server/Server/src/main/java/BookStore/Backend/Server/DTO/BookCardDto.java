package BookStore.Backend.Server.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCardDto {
    private String id;
    private String title;
    private String Description;
    private String url;
    private double price;
}
