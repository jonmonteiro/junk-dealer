package junkedealer.junkedealer.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import junkedealer.junkedealer.entities.Users;

@Service
@PropertySource("file:secret.txt")
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Users users) {    	
        try {
            var algorithm = Algorithm.HMAC256(secret);

            java.util.List<String> profiles = users.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
           
            return JWT.create()
                    .withIssuer("API JUNKDEALER")
                    .withSubject(users.getLogin())
                    .withClaim("user id" , users.getId())
                    .withClaim("profiles", profiles)
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error to generate jwt token", exception);
        }
    }

        public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);            
            
            return JWT.require(algoritmo)
                    .withIssuer("API JUNKDEALER")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();            
        } catch (JWTVerificationException exception) {
        	System.out.println("Erro ao processar o token no PUT: " + exception.getMessage());
            throw new RuntimeException("Token JWT inválido ou expirado!");
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Erro de autenticacao: "+ex.getMessage());
        }
    }

      private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));    	
    }
}
