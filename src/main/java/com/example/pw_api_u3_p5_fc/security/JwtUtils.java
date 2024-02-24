package com.example.pw_api_u3_p5_fc.security;

import io.jsonwebtoken.Jwts;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private static final Logger LOG=LoggerFactory.getLogger(JwtUtils.class);

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey("semillaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            .parseClaimsJws(authToken);
            return true;
        }catch(Exception e){
            LOG.error("ERRoRRRRRRRR", e);
        }
        return false;
    }

    public String getUserNameFromJetToken(String token){
        return Jwts.parser().setSigningKey("semillaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        .parseClaimsJws(token).getBody().getSubject();
    }
}
