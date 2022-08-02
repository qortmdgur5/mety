package com.risingcraft.mety.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    //회원가입 기관별 코드 넣기
    @Transactional
    @Modifying
    @Query(value = "UPDATE user u SET u.orgId = (SELECT o.id FROM organization o WHERE o.name = :orgName) WHERE u.orgName = :orgName AND u.id = :id", nativeQuery = true)
    void mSignupOrgId(String orgName, int id);

    //기관 별 신청대기중인 환자 불러오기 (이름)
    @Query(value = "SELECT * FROM user WHERE NAME LIKE %:nameText% and medicalInfo LIKE %:medicalText% and orgId = :id and approve = '0' ORDER BY id DESC", nativeQuery = true)
    Page<User> mUserApproveList(int id, Pageable pageable, String nameText, String medicalText);

    //신청승인
    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET role='ROLE_USER', approve=1 WHERE id = :id", nativeQuery = true)
    void mApprove(int id);

    //기관 별 승인된 환자 리스트 불러오기
    @Query(value = "SELECT * FROM user WHERE NAME LIKE %:searchText% and medicalInfo LIKE %:medicalText% and orgId = :id and approve = '1' ORDER BY id DESC", nativeQuery = true)
    Page<User> mUserList(int id, Pageable pageable, String searchText, String medicalText);

    //환자 활성화
    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET activate = 1 WHERE id = :id", nativeQuery = true)
    void mActivate(int id);

    //환자 비활성화
    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET activate = 0 WHERE id = :id", nativeQuery = true)
    void mUnActivate(int id);
}