package com.samhyun.auth.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samhyun.auth.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class LoginUser extends org.springframework.security.core.userdetails.User {

    public LoginUser(User user) {
        this(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return super.getPassword();
    }
}
