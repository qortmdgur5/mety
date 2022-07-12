package com.risingcraft.mety.config.auth;

import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.organization.OrganizationRepository;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrganizationDetailsService implements UserDetailsService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDetails loadUserByUsername(String orgname) throws UsernameNotFoundException {
        System.out.println("나 실행돼?");

        Organization orgEntity = organizationRepository.findByOrgname(orgname);
        log.info("orgEntity={}", orgEntity);

        if(orgEntity == null) {
            return null;
        }else{
            return new OrganizationDetails(orgEntity);
        }
    }
}
