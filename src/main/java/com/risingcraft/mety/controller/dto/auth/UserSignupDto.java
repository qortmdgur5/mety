package com.risingcraft.mety.controller.dto.auth;

import com.risingcraft.mety.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class UserSignupDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String email;

    private String phone;

    private boolean gender;

    private byte medicalInfo;

    @NotBlank
    private String address;

    private String birth;

    private int orgId;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .phone(phone)
                .gender(gender)
                .medicalInfo(medicalInfo)
                .address(address)
                .birth(birth)
                .orgId(orgId)
                .build();
    }
}
