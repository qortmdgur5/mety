package com.risingcraft.mety.controller.dto.user;

import com.risingcraft.mety.domain.user.User;
import lombok.Data;

@Data
public class UserUpdateDto {
    private String username;    //아이디
    private String name;        //이름
    private String birth;       //생일
    private boolean gender;
    private String address;
    private String phone;
    private String email;
    private String orgName;
    private byte medicalInfo;

    public User toEntity() {
        return User.builder()
                .username(username)
                .name(name)
                .birth(birth)
                .gender(gender)
                .address(address)
                .phone(phone)
                .email(email)
                .orgName(orgName)
                .medicalInfo(medicalInfo)
                .build();
    }
}
