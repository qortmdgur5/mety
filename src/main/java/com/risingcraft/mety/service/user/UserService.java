package com.risingcraft.mety.service.user;

import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //회원정보수정 서비스
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
        userEntity.setOrgName(user.getOrgName());
        userEntity.setMedicalInfo(user.getMedicalInfo());

        return userEntity;
    }

    //신청대기중인 환자리스트 가져오기 서비스
    public Page<User> 환자신청리스트(int id, Pageable pageable, String searchText, String medicalText) {
        Page<User> users = userRepository.mUserApproveList(id, pageable, searchText, medicalText);
        return users;
    }

    //신청승인 서비스
    @Transactional
    public void 신청승인(int id) {
        userRepository.mApprove(id);
    }

    @Transactional
    //승인된 환자리스트 가져오기 서비스
    public Page<User> 환자리스트(int id, Pageable pageable, String nameText, String medicalText) {
        return userRepository.mUserList(id, pageable, nameText, medicalText);
    }

    //환자 치료 활성화 서비스
    public void 환자활성화(int id) {
        userRepository.mActivate(id);
    }

    //환자 치료 비활성화 서비스
    public void 환자비활성화(int id) {
        userRepository.mUnActivate(id);
    }

}
