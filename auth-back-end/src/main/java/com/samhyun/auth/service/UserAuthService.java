package com.samhyun.auth.service;

import com.samhyun.auth.repository.UserRepository;
import com.samhyun.auth.security.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new LoginUser(userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("not found user email %s", email))));
    }

    public UserDetails getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        assert auth != null;

        String email = (String) auth.getPrincipal();
        if (email.equals("anonymousUser")) {
            return null;
        }
        return loadUserByUsername(email);
    }
}
