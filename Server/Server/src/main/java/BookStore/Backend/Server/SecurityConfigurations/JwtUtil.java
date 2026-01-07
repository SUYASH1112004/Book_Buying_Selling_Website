package BookStore.Backend.Server.SecurityConfigurations;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Signature;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "bookstore_secret_key";

    public String generateToken(String email)
    {
        return Jwts.builder()               //Called when user logged in
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token)
    {
        try{
            extractEmail(token);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }


}
