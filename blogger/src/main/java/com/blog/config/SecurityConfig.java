package com.blog.config;


import com.blog.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetails userDetails;
    @Bean
    PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return  super.authenticationManagerBean();
    }
    @Override
    public  void configure(HttpSecurity http) throws Exception {
        http      .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").hasRole("Role.Admin")
                .antMatchers(HttpMethod.GET,"/api/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/user/**").permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {

        UserDetails user = User.builder().
                username("mahesh").password(passwordencoder().
                        encode("test")).roles("User").build();
        UserDetails admin = User.builder().username("Admin")
                .password(passwordencoder().encode("Admin")).roles("Admin").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails)
                .passwordEncoder(passwordencoder());
    }


}
