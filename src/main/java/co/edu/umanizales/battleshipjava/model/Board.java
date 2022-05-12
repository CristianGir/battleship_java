package co.edu.umanizales.battleshipjava.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    private int id;
    private byte cols;
    private byte rows;
    private User player;
    private ListDE shipsList;
    private boolean state;
    private List<Coordinate> receivedShoots;

    public Board(byte rows, byte cols, User player, ListDE shipsList) {
        this.cols = cols;
        this.rows = rows;
        this.player = player;
        this.shipsList = shipsList;
        this.receivedShoots = new ArrayList<>();
    }

    public String validateShoot(int x, int y) {
        return null;
    }
}
