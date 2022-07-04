package com.risingcraft.mety.config.auth;

import com.risingcraft.mety.domain.organization.Organization;
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
public class OrganizationDetailsService implements UserDetailsService {

    private final OrganizationRepository organizationRepository;

    @Override
    public UserDetails loadUserByUsername(String orgname) throws UsernameNotFoundException {

        Organization orgEntity = organizationRepository.findByOrgname(orgname);

        if(orgEntity == null) {
            return null;
        }else{
            return new OrganizationDetails(orgEntity);
        }
    }
}
