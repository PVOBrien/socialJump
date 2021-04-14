package com.pvobrien.socialJump.service;

import com.pvobrien.socialJump.SocialJumpApplication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(SocialJumpApplication.class);

    static final long EXPIRATIONTIME = 864_00_00; // 1 day in milliseconds, okay.
    static final String SIGNINGKEY = "SecretKey"; // ???
    static final String PREFIX = "Bearer"; // this is NOT potato.

    // to add token to Auth header...
    static public void addToken(HttpServletResponse res, String username) {
        logger.info("within AuthServ");
        String JwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS256, SIGNINGKEY)
                .compact(); // todo: what?
        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    // get token from auth header... (why do this, we just created it?)
    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            }
        }
        return null;
    }
}
