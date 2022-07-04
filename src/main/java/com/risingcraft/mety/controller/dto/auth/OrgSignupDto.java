package com.risingcraft.mety.controller.dto.auth;

import com.risingcraft.mety.domain.organization.Organization;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrgSignupDto {

    @Size(min = 2, max = 20)
    @NotBlank
    private String orgname;   // 기관 아이디

    @NotBlank
    private String password;    // 기관 비밀번호

    @NotBlank
    private String name;     // 기관 이름 ex) 병원이름

    @NotBlank
    private String phone;       // 기관 번호

    public Organization toEntity() {
        return Organization.builder()
                .orgname(orgname)
                .password(password)
                .name(name)
                .phone(phone)
                .build();
    }
}
