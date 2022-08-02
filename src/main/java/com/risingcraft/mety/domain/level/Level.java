package com.risingcraft.mety.domain.level;

import com.risingcraft.mety.domain.quest.Quest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략을 데이터베이스에 맞춰 따라간다. 여기서 사용할 DB는 MariaDB
    private int id;   //레벨 테이블 고유번호 (레벨코드) ex) 코드1 = 1주차 1회차 퀘스트1,2,3,4,5,6, 코드2 = 1주차 2회차 퀘스트1,2,3,4,5,6

    @JoinColumn(name = "quest1_code")
    @OneToOne
    private Quest quest1;

    @JoinColumn(name = "quest2_code")
    @OneToOne
    private Quest quest2;

    @JoinColumn(name = "quest3_code")
    @OneToOne
    private Quest quest3;

    @JoinColumn(name = "quest4_code")
    @OneToOne
    private Quest quest4;

    @JoinColumn(name = "quest5_code")
    @OneToOne
    private Quest quest5;

    @JoinColumn(name = "quest6_code")
    @OneToOne
    private Quest quest6;

}
