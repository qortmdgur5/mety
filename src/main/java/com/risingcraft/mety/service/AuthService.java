package com.risingcraft.mety.service;

import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.organization.OrganizationRepository;
import com.risingcraft.mety.domain.role.Role;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public User 유저회원가입(User user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(Role.ROLE_GUEST);
        User userEntity = userRepository.save(user);
        log.info("user={}", user);
        return userEntity;
    }

    public void 유저병원코드(String orgName, int id) {
        userRepository.mSignupOrgId(orgName, id);
    }

    public Organization 병원회원가입(Organization org) {
        String rawPassword = org.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        org.setPassword(encPassword);
        org.setRole(Role.ROLE_PREORG);
        Organization orgEntity = organizationRepository.save(org);
        log.info("org={}", org);
        return orgEntity;
    }
}
