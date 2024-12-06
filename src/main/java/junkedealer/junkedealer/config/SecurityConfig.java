// package junkedealer.junkedealer.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.http.HttpMethod;
// import junkedealer.junkedealer.filter.SecurityFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     SecurityFilter securityFilter;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  
//     return http
//     	    .csrf(csrf -> csrf.disable())
//     	    .sessionManagement(session -> session
//     	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//     	    )
//     	    .authorizeHttpRequests(auth -> auth
//     	        .requestMatchers(HttpMethod.POST, "/login").permitAll()
//     	        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
//     	        .requestMatchers("/managers/**").hasAnyAuthority("MANAGER")    	        
//     	        .requestMatchers("/users/**").hasAnyAuthority("OPERATOR")
//     	        .anyRequest().authenticated()
//     	    )
//     	    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//     	    .build();
//     }

//     @Bean
//     public AuthenticationManager authManager(AuthenticationConfiguration configuration) throws Exception {
//         return configuration.getAuthenticationManager();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
