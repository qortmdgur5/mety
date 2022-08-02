package com.risingcraft.mety.service.org;

import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.organization.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class OrgService {

    private final OrganizationRepository organizationRepository;

    @Transactional
    public Organization 기관정보수정(int id, Organization organization) {
        Organization orgEntity = organizationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 아닙니다."));

        orgEntity.setOrgname(organization.getOrgname());
        orgEntity.setName(organization.getName());
        orgEntity.setAddress(orgEntity.getAddress());
        orgEntity.setPhone(orgEntity.getPhone());

        return orgEntity;
    }
}
