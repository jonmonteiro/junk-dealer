package junkedealer.junkedealer.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {
    // @ManyToMany(fetch = FetchType.EAGER)
	// @JoinTable(name = "users_userprofile", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "userprofle_id"))
	// private Set<UserProfile> userProfile = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String cellphone;
    private String email;
    private Boolean active;
    private String password;

    // @Override
	// public Collection<? extends GrantedAuthority> getAuthorities() {
	// 	return this.getUserProfile().stream()
	// 			.map(userprofile -> new SimpleGrantedAuthority(userprofile.getName().toString()))
	// 			.collect(Collectors.toSet());
	// }

    // @Override
    // public String getPassword() {
    //     return password;
    // }

    // @Override
    // public String getUsername() {
    //    return login;
    // }
}
