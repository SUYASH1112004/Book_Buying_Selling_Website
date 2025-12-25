package BookStore.Backend.Server.Service;

import BookStore.Backend.Server.DTO.BookCardDto;
import BookStore.Backend.Server.Repository.bookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BusinessLogic {

    @Autowired
    private bookRepo obj;

    public List<BookCardDto> getAllBooks()
    {
        return obj.findAll()
                .stream()
                .map(
                        book -> {
                            BookCardDto dto = new BookCardDto();
//                            dto.setId(book.getId());
                            dto.setDescription(book.getDescription());
                            dto.setUrl(book.getUrl());
                            dto.setPrice(book.getPrice());
                            dto.setTitle(book.getTitle());
                            return dto;
                        })
                .toList();
    }


}
