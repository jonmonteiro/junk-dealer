package junkedealer.junkedealer.DTO.Users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import junkedealer.junkedealer.entities.Users;

public record PostUsersDTO(
    @NotNull
    String name,
    @NotNull
    @Email
    String email,
    @NotNull
    String password
) {

     public PostUsersDTO(Users data) {
        this(data.getName(), data.getEmail(), data.getPassword());
    }
}
