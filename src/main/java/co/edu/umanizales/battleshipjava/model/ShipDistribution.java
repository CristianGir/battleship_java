package co.edu.umanizales.battleshipjava.model;

import lombok.Data;

@Data
public class ShipDistribution {
    private Ship ship;
    private String state;
    private Coordinate[] coordinates;
    private byte orientation;

    public ShipDistribution (Ship ship) {
        this.ship = ship;
        this.coordinates = new Coordinate[ship.getNumPlaces()];
        this.state = "FREE";
    }
}
