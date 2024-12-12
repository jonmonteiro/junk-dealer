package junkedealer.junkedealer.DTO.Login;

import junkedealer.junkedealer.entities.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
    @NotNull
    String name,
    @NotNull
    @Email
    String email, 
    @NotNull
    String password, 
    @NotNull
    UserRole role) {
}
