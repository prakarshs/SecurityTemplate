package com.prakarshs.SecurityTemplate.Service.Impl;

import com.prakarshs.SecurityTemplate.Exceptions.ValueDoesntExist;
import com.prakarshs.SecurityTemplate.Repository.UserRepository;
import com.prakarshs.SecurityTemplate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetailsService userDetailService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws ValueDoesntExist {
                return userRepository.findByEmail(username).orElseThrow(()-> new ValueDoesntExist("The Entered Email Doesn't Exist","Try Signing Up With The Email First."));
            }
        };
    }
}
