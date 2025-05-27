package com.api.PrePaymentAPI.security;

import com.api.PrePaymentAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class AuthenticationService implements UserDetailsService {
    // This service implements UserDetailsService to load user details by username for authentication purposes.

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            UserDetails userDetails = userRepository.findByLogin(username);
            if (userDetails == null) {
                throw new UsernameNotFoundException("User Not Found " + username);
            }
            return userDetails;
        } catch (Exception ex) {
            throw new UsernameNotFoundException("Error Search User !!");
        }


    }
}
