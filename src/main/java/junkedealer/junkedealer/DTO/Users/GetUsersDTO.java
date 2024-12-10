package junkedealer.junkedealer.DTO.Users;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import junkedealer.junkedealer.entities.Users;

public record GetUsersDTO(
    String name,
    Long id,
    String login,
    String email,
    Set<String> profile
) {

    public GetUsersDTO(Users data) {
        this(data.getName(), data.getId(), data.getLogin(), data.getEmail(), data.getUserProfile().stream()
        .map(profile -> profile.getName().name())
        .collect(Collectors.toSet()));
    }     
}
