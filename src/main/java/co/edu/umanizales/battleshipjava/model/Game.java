package co.edu.umanizales.battleshipjava.model;

import lombok.Data;

@Data
public class Game {
    private int id;
    private Board player1Board;
    private Board player2Board;
    private byte shipsNumber;
    private byte turn;
    private byte p1Hits;
    private byte p2Hits;

    public Game(User player1, User player2, ListDE shipsList) {
        createBoards(player1, player2, shipsList);
        this.shipsNumber = (byte)shipsList.getCount();
    }
    public String createBoards(int x, int y, User player) {
        return null;
    }
    private void createBoards(User player1, User player2, ListDE shipsList) {
        if(shipsList.getCount() <= 9) {
            this.player1Board = new Board((byte)10, (byte)10, player1, shipsList);
            this.player2Board = new Board((byte)10, (byte)10, player2, shipsList.cloneList());
        }
        else if(shipsList.getCount() >= 10 &&  shipsList.getCount() <= 20) {
            this.player1Board = new Board((byte)20, (byte)20, player1, shipsList);
            this.player2Board = new Board((byte)20, (byte)20, player2, shipsList.cloneList());
        }
        else {
            this.player1Board = new Board((byte)30, (byte)30, player1, shipsList);
            this.player2Board = new Board((byte)30, (byte)30, player2, shipsList.cloneList());
        }
    }
    public User validateWinner() {
        return null;
    }
    public String validateShoot(int x, int y, User player) {
        return null;
    }
}
