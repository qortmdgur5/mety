package com.risingcraft.mety.config.auth;

import com.risingcraft.mety.domain.organization.OrganizationRepository;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public PrincipalDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username);

        if(userEntity == null) {
            return null;
        }else{
            return new PrincipalDetails(userEntity);
        }
    }
}
