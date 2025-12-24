package BookStore.Backend.Server.SecurityConfigurations;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Signature;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "bookstore_secret_key";

    public String generateToken(String userId)
    {
        return Jwts.builder()               //Called when user logged in
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    public String extractUserId(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token)
    {
        try{
            extractUserId(token);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
