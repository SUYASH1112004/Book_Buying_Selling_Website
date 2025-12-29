package BookStore.Backend.Server.Service;

import BookStore.Backend.Server.DTO.BookCardDto;
import BookStore.Backend.Server.DTO.LoginTransfer;
import BookStore.Backend.Server.DTO.Transfer;
import BookStore.Backend.Server.Entity.User;
import BookStore.Backend.Server.Repository.bookRepo;
import BookStore.Backend.Server.Repository.userRepo;
import BookStore.Backend.Server.SecurityConfigurations.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class BusinessLogic {


    @Autowired
    private PasswordEncoder passwordencoder;
    @Autowired
    private bookRepo obj;

    @Autowired
    private userRepo obj2;

    @Autowired
    private JwtUtil jwtutil;

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

    public boolean isSignup(Transfer data)
    {
        if(obj2.existsByEmail(data.getEmail()))
        {
            return false;
        }
        User newdata = new User();

        newdata.setEmail(data.getEmail());
        newdata.setAddress(data.getAddress());
        newdata.setPhone(data.getPhone());
        String encodedPassword = passwordencoder.encode(data.getPassword());
        newdata.setPassword(encodedPassword);
        obj2.save(newdata);
        return true;

    }

    public String Login(LoginTransfer DTO)
    {
        Optional<User>user = obj2.findByEmail(DTO.getEmail());

        if(user.isEmpty())
        {
            throw new RuntimeException("User Not Found ");
        }
        if(!passwordencoder.matches(DTO.getPassword(),user.get().getPassword()))
        {
            throw new RuntimeException("Wrong Password");
        }
        return jwtutil.generateToken(user.get().getId());
    }


}
