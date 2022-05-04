package co.edu.umanizales.battleshipjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {
    private int x;
    private int y;
    private String state;
}
