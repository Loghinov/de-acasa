package org.deacasa.configuration.security;

import org.deacasa.entity.Role;
import org.deacasa.entity.User;
import org.deacasa.repository.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepo.findByUserName(userName)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUserName(),
                        user.getUserPassword(),
                        getAuthorities(user)
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        // Получаем роль пользователя (не roleId)
        Role role = user.getRole();
        if (role == null) {
            throw new IllegalArgumentException("Use role is null for user: " + user.getUserName());
        }
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));

    }
}
