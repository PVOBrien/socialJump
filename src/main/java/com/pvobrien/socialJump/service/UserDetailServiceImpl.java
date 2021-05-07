package com.pvobrien.socialJump.service;

import com.pvobrien.socialJump.domain.User;
import com.pvobrien.socialJump.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUsername(username);
        return new org.springframework.security.core.
                userdetails.User(username, currentUser.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }
}