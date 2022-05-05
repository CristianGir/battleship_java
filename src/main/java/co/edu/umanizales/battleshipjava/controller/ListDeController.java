package co.edu.umanizales.battleshipjava.controller;

import co.edu.umanizales.battleshipjava.Service.ListDeService;
import co.edu.umanizales.battleshipjava.model.Ship;
import co.edu.umanizales.battleshipjava.model.ShipDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listde")
public class ListDeController {
    @Autowired
    private ListDeService listDeService;

    @GetMapping
    public List<ShipDistribution> getAllLinked()
    {
        return listDeService.getAllLinked();
    }

    @PostMapping
    public String createShip(@RequestBody Ship ship)
    {
        ShipDistribution shipDistribution = new ShipDistribution(ship);
        return listDeService.add(shipDistribution);
    }

    @PostMapping(path="/tostart")
    public String createShipToStart(@RequestBody Ship ship){
        ShipDistribution shipDistribution = new ShipDistribution(ship);
        return listDeService.addFirst(shipDistribution);
    }

    @PostMapping(path = "/load")
    public String loadPets(@RequestBody List<Ship> ships)
    {
        for (Ship ship : ships)
        {
            listDeService.add(new ShipDistribution(ship));
        }
        return "Mascotas cargadas exitosamente.";
    }
}
