package junkedealer.junkedealer.DTO.Users;

import java.util.Set;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record PostUsersDTO(
    @NotNull
    String name,
    @NotNull
    String login,
    @Email
    String email,
    @NotNull
    String password,
    @NotNull
    Set<Long> idsProfile
) {

}
