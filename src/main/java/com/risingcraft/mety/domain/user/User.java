package com.risingcraft.mety.domain.user;

import com.risingcraft.mety.domain.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략을 데이터베이스에 맞춰 따라간다. 여기서 사용할 DB는 MariaDB
    private int id; //유저 테이블 고유번호

    @Column(length = 100, unique = true)  //아이디 중복을 체크하자 DB에서 같은 아이디는 들어올 수 없다.
    private String username;  //유저 아이디

    @Column(nullable = false)
    private String password;    //유저 패스워드 암호화하여 넣을것

    @Column(nullable = false)
    private String name;    //유저 이름

    private String email;       //이메일

    private Date birth;         //생일

    private String phone;   //유저 핸드폰번호

    @Column(nullable = false)
    private byte gender;    //성별

    @Column(nullable = false)
    private byte medicalInfo;   //유저 환부위치 ex) 상지 좌완, 하치 우족

    @Column(nullable = false)
    private int orgId;  // 유저 해당병원 기관코드

    private Date startDate; // 치료 프로그램 시작 날짜

    private boolean activate;   // 기관측 환자 활성화 버튼, ex) 환자가 기관에 내방하였을 때 기관측에서 환자정보 활성화를 on하여 프로그램에 사용자정보가 올라가 프로그램 진행가능하도록 함.

    @Enumerated(EnumType.STRING)
    private Role role;    //권한 ex) 환자, 기관, 관리자

    private LocalDateTime createDate;   // 계정 생성 날짜

    @PrePersist // DB에 INSERT되기 직전에 실행. 다른값들을 넣어주면 이 값은 자동으로 들어간다.
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
