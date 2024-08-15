package org.gsc.medha.service.impl;

import org.gsc.medha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GscSecurityUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found "+ username));
        

    }
    
}
