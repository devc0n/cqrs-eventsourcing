package com.springbank.user.core.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    READ_PRIVELEGE, WRITE_PRIVELEGE;

    @Override
    public String getAuthority() {
        return name();
    }
}
