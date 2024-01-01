package com.yanolja_final.domain.order.entity;

import com.yanolja_final.domain.packages.entity.Package;
import com.yanolja_final.domain.user.entity.User;
import com.yanolja_final.global.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity
@NoArgsConstructor
@Getter
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private Package aPackage;

    @Column(nullable = false)
    private Long availableDateId;

    @Column(name = "order_code", length = 100, nullable = false)
    private String code;

    @Column(name="detail_json",columnDefinition = "TEXT", nullable = false)
    private String detailInfo;
}
