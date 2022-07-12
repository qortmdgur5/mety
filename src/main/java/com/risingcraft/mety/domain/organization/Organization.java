package com.risingcraft.mety.domain.organization;

import com.risingcraft.mety.domain.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략을 데이터베이스에 맞춰 따라간다. 여기서 사용할 DB는 MariaDB
    private int id; // 기관 테이블 고유번호

    @Column(length = 100, unique = true, nullable = false)  //아이디 중복을 체크하자 DB에서 같은 아이디는 들어올 수 없다.
    private String orgname;   // 기관 아이디

    @Column(nullable = false)
    private String password;    // 기관 비밀번호

    @Column(nullable = false)
    private String name;     // 기관 이름 ex) 병원이름

    @Column(nullable = false)
    private String phone;       // 기관 전화번호

    @Column(nullable = false)
    private String address;     // 기관 주소

    @Enumerated(EnumType.STRING)
    private Role role;    //권한 ex) 환자, 기관, 관리자

    private boolean approve;    //가입승인되면 true값으로 바꿔줌

    private LocalDateTime createDate;   // 기관 가입날짜

    @PrePersist // DB에 INSERT되기 직전에 실행. 다른값들을 넣어주면 이 값은 자동으로 들어간다.
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }


}
