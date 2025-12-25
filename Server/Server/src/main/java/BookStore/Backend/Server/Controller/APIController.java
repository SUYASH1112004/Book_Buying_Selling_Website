package BookStore.Backend.Server.Controller;

import BookStore.Backend.Server.DTO.BookCardDto;
import BookStore.Backend.Server.DTO.LoginTransfer;
import BookStore.Backend.Server.DTO.Transfer;
import BookStore.Backend.Server.SecurityConfigurations.JwtUtil;
import BookStore.Backend.Server.Service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.datatransfer.Transferable;
import java.net.PasswordAuthentication;
import java.util.List;


@RequestMapping
public class APIController {

    @Autowired
    private JwtUtil jwtutil;

    @Autowired
    private PasswordEncoder passwordencoder;

    @Autowired
    private BusinessLogic service;

    @PostMapping("/signup")
    public ResponseEntity<?> BuyingDirect(@RequestBody LoginTransfer DTO)
    {
        String encodedPassword = passwordencoder.encode(DTO.getPassword());
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<BookCardDto>> getCards()
    {
        return new ResponseEntity<>(service.getAllBooks(),HttpStatus.OK);
    }

}
