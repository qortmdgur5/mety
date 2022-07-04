package com.risingcraft.mety.domain.organization;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization findByOrgname(String orgname);
}
