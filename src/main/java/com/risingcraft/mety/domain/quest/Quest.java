package com.risingcraft.mety.domain.quest;

import com.risingcraft.mety.domain.level.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략을 데이터베이스에 맞춰 따라간다. 여기서 사용할 DB는 MariaDB
    private int id; // 퀘스트 테이블 고유번호

    private String name;    //퀘스트 이름

    private int round;      //라운드 횟수

    private int roundTime;  //라운드 당 최대 시간
}
