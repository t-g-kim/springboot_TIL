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
import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"itemList", "category"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    private String status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

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

    // Partner N : 1 Carteogry
    @ManyToOne
    private Category category;
//    private Long categoryId;

    // Partner 1 : N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;


}
