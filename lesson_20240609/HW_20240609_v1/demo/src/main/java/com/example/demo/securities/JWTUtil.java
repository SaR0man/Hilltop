package com.example.demo.securities;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Component
public class JWTUtil {
    public JWTClaimsSet extractAllClaims(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet();
    }

    public String convertToString(JWTClaimsSet jwtClaimsSet) {
        return jwtClaimsSet.toString();
    }

    public boolean validateSpecificObjectInToken(JWTClaimsSet jwtClaimsSet, int idControl, String nameControl,
                                                 String descriptionControl, String domainControl, String labelControl) throws ParseException {
        Map<String, Object> main = (Map<String, Object>) jwtClaimsSet.getClaim("main");
        if (main == null) {
            return false;
        }

        List<Map<String, Object>> applications = (List<Map<String, Object>>) main.get("applications");
        if (applications == null) {
            return false;
        }

        for (Map<String, Object> application : applications) {
            int id = ((Number) application.get("Id")).intValue();
            String name = (String) application.get("Name");
            String description = (String) application.get("Description");
            String domain = (String) application.get("Domain");
            String label = (String) application.get("Label");

            if (id == idControl && name.equals(nameControl) && description.equals(descriptionControl)
                    && domain.equals(domainControl) && label.equals(labelControl)) {
                return true;
            }
        }

        return false;
    }
}
