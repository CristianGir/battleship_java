package co.edu.umanizales.battleshipjava.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    private TypeUser typeUser;
    private String token;

    public User (String email, String password, TypeUser typeUser, String token) {
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
        this.token = token;
    }

    public UserDTO userToDTO() {
        UserDTO userDTO = new UserDTO(this.email, this.getTypeUser().getDescription(), this.token);
        return userDTO;
    }
}
