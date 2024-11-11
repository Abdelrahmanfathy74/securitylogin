package com.driver.driver.config;

import java.util.Collection;
import java.util.Optional;

import com.driver.driver.Repo.UserRepo;
import com.driver.driver.model.User;
import com.driver.driver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userService.findByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Not found: " + username);
        }}

        private static Collection<? extends GrantedAuthority> getAuthorities (User user){
            String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
            Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
            return authorities;
        }


    }
