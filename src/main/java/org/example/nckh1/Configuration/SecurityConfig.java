package org.example.nckh1.Configuration;
import org.example.nckh1.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.authorization.AuthenticatedAuthorizationManager.rememberMe;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private CustomUserDetailService userService;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login", "/signup", "/home","/js/**","/css/**","/images/**").permitAll()  // Cho phép truy cập trang login và register
                        .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/groups/create").hasRole("ADMIN")
                        .anyRequest().authenticated()  // Tất cả các yêu cầu khác đều cần xác thực
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)  // Sau khi đăng nhập thành công, điều hướng tới trang home
                        .failureHandler((request, response, exception) -> {
                            response.sendRedirect("/login?error=" + exception.getMessage());
                        })
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());


        return http.build();
    }
}
