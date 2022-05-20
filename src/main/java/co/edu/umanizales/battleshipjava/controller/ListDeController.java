package co.edu.umanizales.battleshipjava.controller;

import co.edu.umanizales.battleshipjava.Service.ListDeService;
import co.edu.umanizales.battleshipjava.model.GenericResponse;
import co.edu.umanizales.battleshipjava.model.Ship;
import co.edu.umanizales.battleshipjava.model.ShipDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/ships")
public class ListDeController {
    @Autowired
    private ListDeService listDeService;

    @GetMapping
    public ResponseEntity<GenericResponse> getShips() {
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200, listDeService.getAllLinked(), null),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createShip(@RequestBody Ship ship)
    {
        ShipDistribution shipDistribution = new ShipDistribution(ship);
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200, listDeService.add(shipDistribution),
                        null),
                HttpStatus.OK
        );
    }

    @PostMapping(path="/tostart")
    public ResponseEntity<GenericResponse> createShipToStart(@RequestBody Ship ship){
        ShipDistribution shipDistribution = new ShipDistribution(ship);
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200, listDeService.add(shipDistribution),
                        null),
                HttpStatus.OK
        );
    }
}
