package co.edu.umanizales.battleshipjava.Service;

import co.edu.umanizales.battleshipjava.model.TypeUser;
import co.edu.umanizales.battleshipjava.model.User;
import co.edu.umanizales.battleshipjava.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private User administrator;
    private User player1;
    private User player2;

    public UserService() {
        administrator = new User("cgiraldo93759@umanizales.edu.co", "123456",
                new TypeUser(1, "Administrador"));
    }

    public List<UserDTO> listUsers() {
        List<UserDTO> list = new ArrayList<>();
        list.add(administrator.userToDTO());
        if(player1 != null) {
            list.add(player1.userToDTO());
        }
        if(player2 != null) {
            list.add(player2.userToDTO());
        }
    }

    public String createPlayer(User player, byte numPlayer) {
        if(numPlayer == 1 && player1 != null) {
            return "El jugador 1 ya se encuentra creado.";
        }
        if(numPlayer == 2 && player1 != null) {
            return "El jugador 2 ya se encuentra creado.";
        }
        if(numPlayer == 1) {
            player1 = player;
        }
        else {
            player2 = player;
        }
        return "El jugador se creó con éxito.";
    }
}
