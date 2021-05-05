package com.example.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor     // 모든생성자
@NoArgsConstructor      // 기본생성자
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    private String status;

    private String title;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long partnerId;


    // 1:N
    /*
        LAZY = 지연로딩, EAGER = 즉시로딩

        LAZY = select * from item where id = ?
        EAGER =
        item_id = order_detail.item_id
        user_id = order_detail.user_id
        where item.id = ?
        left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?

        LAZY : orderDetailList에 대해 getMethod를 호출 하지 않는 이 연관관계가 설정된 테이블에 대해 select를 하지 않겠다.
        EAGER : 즉시 모든것을 로딩하겠다. 연관관계가 설정된 모든테이블에 대해 join을 한다. (모든 데이터를 가져오기때문에 성능 저하의 원인이 될수 있다) OneToOne, ManyToOne 한건일떄 사용하는것이 좋다.
    */
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;
}
