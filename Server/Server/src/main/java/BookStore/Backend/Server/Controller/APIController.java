package BookStore.Backend.Server.Controller;

import BookStore.Backend.Server.DTO.BookCardDto;
import BookStore.Backend.Server.DTO.LoginTransfer;
import BookStore.Backend.Server.DTO.Transfer;
import BookStore.Backend.Server.SecurityConfigurations.JwtUtil;
import BookStore.Backend.Server.Service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.awt.datatransfer.Transferable;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class APIController {





    @Autowired
    private BusinessLogic service;

    @PostMapping("/signup")
    public ResponseEntity<?> Signup (@RequestBody Transfer DTO) {
        boolean Sol = service.isSignup(DTO);
        if (Sol) {
            return new ResponseEntity<>("Done", HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("Login Unsuccessfull", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/cards")
    public ResponseEntity<List<BookCardDto>> getCards()
    {
        return new ResponseEntity<>(service.getAllBooks(),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginTransfer Dto)
    {
        try{
                String token = service.Login(Dto);

                return ResponseEntity.ok()
                        .body(Map.of("token",token));
        }
        catch (Exception e)
        {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid Email or Password");
        }
    }

    @GetMapping("/buying")
    public ResponseEntity<List<BookCardDto>> BuyingDataReq()
    {
        return new ResponseEntity<>(service.getAllBooks(),HttpStatus.OK);
    }

    @PostMapping("/buynow")
    public ResponseEntity<?> buyingnow(@RequestBody String bookId)
    {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        service.BuyingNow(bookId,email);

        return ResponseEntity.ok("Order Placed Successfully");
    }


}
