package co.edu.umanizales.battleshipjava.controller;

import co.edu.umanizales.battleshipjava.Service.UserService;
import co.edu.umanizales.battleshipjava.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<GenericResponse> getUsers() {
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200, userService.listUsers(), null),
                HttpStatus.OK
        );
    }
    @PostMapping
    public ResponseEntity<GenericResponse> createPlayer(@RequestBody @Valid PlayerDTO player) {
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200, userService.createPlayer(player.getPlayer(), player.getNumPlayer()),
                null),
                HttpStatus.OK
        );
    }
    @PostMapping("user")
    public ResponseEntity<GenericResponse> login(@RequestParam("email") String email, @RequestParam("password") String password,
                         @RequestParam("code") int code, @RequestParam("description") String description) {
        String token = getJWTToken(email);
        User user = new User(email, password, new TypeUser(code, description), token);
        return new ResponseEntity<GenericResponse>(new GenericResponse(200, user.userToDTO(), null),
                HttpStatus.OK
        );
    }
    private String getJWTToken(String user) {
        String key = "secretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder().setId("softtekJWT").setSubject(user)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 300000))
                .signWith(SignatureAlgorithm.HS512,
                        key.getBytes()).compact();
        return "Bearer " + token;
    }
}
