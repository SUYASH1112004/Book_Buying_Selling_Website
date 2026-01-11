package BookStore.Backend.Server.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSellingDto {
    private String title;
    private String Description;
    private String url;
    private double price;
}
