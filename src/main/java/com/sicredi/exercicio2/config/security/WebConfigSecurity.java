package com.sicredi.exercicio2.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfigSecurity {
    //"Teste" interno de segurança


//    //Descontinuado - fins de aprendizagem
//
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("senha").roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic()
                .and()
//                .authorizeRequests().antMatchers(HttpMethod.GET,"/**").hasRole("USER")
//                .and()
//                .authorizeRequests().antMatchers(HttpMethod.PUT,"/**").hasRole("USER")
//                .and()
//                .authorizeRequests().antMatchers(HttpMethod.POST,"/**").hasRole("USER")
//                .and()
//                .authorizeRequests().antMatchers(HttpMethod.DELETE,"/**").hasRole("USER")
//                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable(); //Para teste - Desabilita security de autorização de rotas como put,post e del

        return httpSecurity.build();
    }



}
