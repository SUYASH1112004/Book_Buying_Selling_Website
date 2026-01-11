package BookStore.Backend.Server.Service;

import BookStore.Backend.Server.DTO.BookCardDto;
import BookStore.Backend.Server.DTO.BookSellingDto;
import BookStore.Backend.Server.DTO.LoginTransfer;
import BookStore.Backend.Server.DTO.Transfer;
import BookStore.Backend.Server.Entity.Book;
import BookStore.Backend.Server.Entity.Orders;
import BookStore.Backend.Server.Entity.User;
import BookStore.Backend.Server.Repository.OrderRepo;
import BookStore.Backend.Server.Repository.bookRepo;
import BookStore.Backend.Server.Repository.userRepo;
import BookStore.Backend.Server.SecurityConfigurations.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    private OrderRepo orderobj;

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

    public void BuyingNow(String BookId,String email)
    {
        User user = obj2.findByEmail(email).
                orElseThrow(()->new RuntimeException("User Not Found"));

        Book book = obj.findById(BookId)
                .orElseThrow(()->new RuntimeException("Book not found"));

        Orders order = new Orders();
        order.setOrderTime(new Date());
        order.setBookId(book.getId());
        order.setPrice(book.getPrice());
        order.setUserId(user.getId());
        order.setBookTitle(book.getTitle());
        order.setStatus("Placed");
        orderobj.save(order);

    }



    public void Selling(BookSellingDto dto,String email)
    {
        Book objbook = new Book();
        objbook.setDescription(dto.getDescription());
        objbook.setTitle(dto.getTitle());
        objbook.setUrl(dto.getUrl());
        objbook.setPrice(dto.getPrice());
        objbook.setSold(false);
        objbook.setSellerEmail(email);

        obj.save(objbook);

    }





}
