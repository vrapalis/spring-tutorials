package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public record AppUserDetails(AppUserEntity appUserEntity) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return appUserEntity
                .getAuthorities()
                .stream()
                .map(authorityEntity -> new SimpleGrantedAuthority(authorityEntity.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return appUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return appUserEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
