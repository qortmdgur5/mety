package com.risingcraft.mety.controller.dto.org;

import com.risingcraft.mety.domain.organization.Organization;
import lombok.Data;

@Data
public class OrgUpdateDto {

    private String orgname; //아이디
    private String name;    //병원이름
    private String address; //병원주소
    private String phone;   //병원전화번호


    public Organization toEntity() {
        return Organization.builder()
                .orgname(orgname)
                .name(name)
                .address(address)
                .phone(phone)
                .build();
    }
}
