package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity                     // 이 클래스는 DB테이블에 상승하는 엔티티다.
@Table(name = "Todo")       // 이 엔티티는 Todo 테이블에 매핑된다.
public class TodoEntity {
    @Id                     // 기본 키가 될 필드를 지정한다.
    @GeneratedValue(generator = "system-uuid")              // 해당 필드값을 자동으로 생성한다.
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String comment;
    private boolean done;
}
