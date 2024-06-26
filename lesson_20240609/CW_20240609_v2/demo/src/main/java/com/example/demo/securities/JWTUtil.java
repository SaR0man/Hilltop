package com.example.demo.securities;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class JWTUtil {
    public JWTClaimsSet extractAllClaims(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet();
    }

    public String convertToString(JWTClaimsSet jwtClaimsSet) {
        return jwtClaimsSet.toString();
    }
}
