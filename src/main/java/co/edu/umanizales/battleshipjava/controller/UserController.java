package co.edu.umanizales.battleshipjava.controller;

import co.edu.umanizales.battleshipjava.Service.UserService;
import co.edu.umanizales.battleshipjava.model.GenericResponse;
import co.edu.umanizales.battleshipjava.model.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
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
}
