package com.koleso.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

//     Конфигурация разрешений для URL через authorizeHttpRequests
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // Доступ только для ADMIN
//                        .requestMatchers("/manager/**").hasRole("MANAGER") // Доступ только для MANAGER
//                        .requestMatchers("/user/**").hasRole("USER") // Доступ только для USER
//                        .requestMatchers("/", "/login").permitAll() // Доступ для всех
//                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
//                )
//                .formLogin(form -> form
//                        .loginPage("/login") // Страница входа
//                        .permitAll() // Разрешить доступ к странице входа всем
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")  // URL выхода
//                        .logoutSuccessUrl("/login?logout=true")  // Перенаправление после выхода
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .deleteCookies("JSESSIONID")
//                        .permitAll()  // Разрешаем всем вызывать logout
//                );
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(csrf -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Генерация и хранение CSRF токена
//                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Разрешить доступ ко всем страницам
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login") // Страница входа
                        .defaultSuccessUrl("/welcome", true)
                        .permitAll() // Разрешить доступ к странице входа всем
                )
                .logout(logout -> logout
                .logoutUrl("/logout")  // URL выхода
                .logoutSuccessUrl("/login?logout=true")  // Перенаправление после выхода
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .permitAll()  // Разрешаем всем вызывать logout
        );

        return http.build();
    }

    // Определение PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Определение AuthenticationManager (нужно, если используется UserDetailsService)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

}

