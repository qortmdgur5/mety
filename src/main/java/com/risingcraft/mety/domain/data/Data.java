package com.risingcraft.mety.domain.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.risingcraft.mety.domain.level.Level;
import com.risingcraft.mety.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략을 데이터베이스에 맞춰 따라간다. 여기서 사용할 DB는 MariaDB
    private int id; //program 테이블 고유번호

    @JsonIgnoreProperties({"data"})
    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;  //사용자 테이블 id

    @JoinColumn(name = "levelCode")
    @ManyToOne
    private Level level;    //프로그램 레벨 코드 ex) 레벨코드 1 = 1주차 1회차, 레벨코드2 = 1주차 2회차

    private int RMS_MAX1;    // 환자 근전도 최대값1

    private int RMS_MAX2;    // 환자 근전도 최대값2

    private int RMS_MAX3;    // 환자 근전도 최대값3

    private int exercise_1; // 운동 퀘스트 1 측정값

    private int exercise_2; // 운동 퀘스트 2 측정값

    private int exercise_3; // 운동 퀘스트 3 측정값

    private int recog_max_1;// 인지 퀘스트 1 최대시간

    private int recog_max_2;// 인지 퀘스트 2 최대시간

    private int recog_max_3;// 인지 퀘스트 3 최대시간

    private int recog_1;    // 인지 퀘스트 1 측정값

    private int recog_2;    // 인지 퀘스트 2 측정값

    private int recog_3;    // 인지 퀘스트 3 측정값

    private int vas;        // vas측정값

    private int orgId;      // 병원 기관코드



    private LocalDateTime createDate;   // 프로그램 데이터 생성 날짜 ex) 환자가 치료가 끝나고 난 뒤 데이터가 인서트 될 때 시간기록

    @PrePersist // DB에 INSERT되기 직전에 실행. 다른값들을 넣어주면 이 값은 자동으로 들어간다.
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }


}
