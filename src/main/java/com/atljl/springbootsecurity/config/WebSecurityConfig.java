package com.atljl.springbootsecurity.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().antMatchers("/","/logins").permitAll()
               .antMatchers("/emp").hasRole("emp")
               .antMatchers("/monitor").hasRole("monitor")
               .antMatchers("/boss").hasRole("boss");

       http.formLogin();

       http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("emp").password(new BCryptPasswordEncoder().encode("emp")).roles("emp")
                .and()
                .withUser("monitor").password(new BCryptPasswordEncoder().encode("monitor")).roles("monitor")
                .and()
                .withUser("boss").password(new BCryptPasswordEncoder().encode("boss")).roles("boss");
    }
}
