package com.codegym.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // ko can dang nhap
                .antMatchers("/home", "/login").permitAll()
                // la user
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                // authen thanh cong
                .defaultSuccessUrl("/user/articles")
                // authen that bai
                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home").permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                ;
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(1*24*60*60);//24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
