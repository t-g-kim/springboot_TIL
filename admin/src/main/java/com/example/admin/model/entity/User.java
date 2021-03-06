package com.example.admin.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Accessors(chain = true)
@Builder
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderGroup"})
@Data
@AllArgsConstructor
@NoArgsConstructor  // 기본생성
@Entity // ==table자
@Table(name = "user")   // table명과 클래스명이 같으면 없어도 된다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql을 사용하기 때문에 identity를 사용
    private Long id;

    @Column(name = "account")   // 없어도됨.
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

//    // 1:N
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private List<OrderDetail> orderDetailList;

}
