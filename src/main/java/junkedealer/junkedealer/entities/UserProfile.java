package junkedealer.junkedealer.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import junkedealer.junkedealer.DTO.sec.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "userprofile")
@Entity(name = "UserProfile")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UserProfile {

    @ManyToMany(mappedBy="userProfile",fetch = FetchType.EAGER)
	private List<Users> user;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Enumerated(EnumType.STRING)
	private UserType name;
	
	@Column
	private String description;
}
