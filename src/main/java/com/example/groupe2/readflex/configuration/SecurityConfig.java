package com.example.groupe2.readflex.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {


    /*   @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  //        http.csrf(AbstractHttpConfigurer::disable)
  //                .authorizeHttpRequests((requests) -> requests
  //                        .anyRequest().permitAll()
  //
  //                );
          //http.formLogin().disable();
          http.csrf(AbstractHttpConfigurer::disable)
                  .authorizeHttpRequests()
                  .anyRequest().permitAll()
                  .and().formLogin().disable()
                  .httpBasic().disable();
          rrn http.build();
      }
  /*        http.csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests()
              .anyRequest().permitAll()
              .and().formLogin().disable()
              .httpBasic().disable();
  */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//TODO : desactiver le password par defaut