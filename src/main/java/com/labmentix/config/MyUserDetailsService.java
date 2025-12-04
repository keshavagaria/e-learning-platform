package com.labmentix.config;

import com.labmentix.entities.User;
import com.labmentix.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);
        Optional<User> user=repo.findByUsername(username);

        log.info(username);
        log.info("user details {}",user.get().getUsername());
        log.info("user details {}",user.get().getPassword());
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found "+username));
    }
}
