package com.risingcraft.mety.config.auth;

import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class OrganizationDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Organization org;
    private Map<String, Object> attributes;

    public OrganizationDetails(Organization org) {
        this.org = org;
    }

    public OrganizationDetails(Organization org, Map<String, Object> attributes) {
        this.org = org;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collector = new ArrayList<>();
        collector.add(() -> {return String.valueOf(org.getRole());});
        return collector;
    }

    @Override
    public String getUsername() {
        return org.getOrgname();
    }


    @Override
    public String getPassword() {
        return org.getPassword();
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
