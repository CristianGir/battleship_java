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

    public User (String email, String password, TypeUser typeUser) {
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }

    public UserDTO userToDTO() {
        UserDTO userDTO = new UserDTO(this.email, this.getTypeUser().getDescription());
        return userDTO;
    }
}
