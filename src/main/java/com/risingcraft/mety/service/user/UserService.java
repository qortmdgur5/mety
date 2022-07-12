package com.risingcraft.mety.service.user;

import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User 회원수정(int id, User user) {
        User userEntity = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 아닙니다."));

        userEntity.setUsername(user.getUsername());
        userEntity.setName(user.getName());
        userEntity.setBirth(user.getBirth());
        userEntity.setAddress(user.getAddress());
        userEntity.setGender(user.isGender());
        userEntity.setPhone(user.getPhone());
        userEntity.setEmail(user.getEmail());
        userEntity.setOrgId(user.getOrgId());
        userEntity.setMedicalInfo(user.getMedicalInfo());

        return userEntity;
    }
}
