package com.example.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderGroup", "item"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@ToString(exclude = {"user", "item"})   //toString 때문에 overflow가 생긴다. orderdetail과 user가 상호참조
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrival_date;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;
    //OrderDetail N : 1 Item
    @ManyToOne
    private Item item;

    // OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;


//    // N:1
//    @ManyToOne
//    private User user;  // hibernate를 통한 연관관계를 설정시 객체 이름을 사용해야함
//
//    // N:1
//    @ManyToOne
//    private Item item;

}
