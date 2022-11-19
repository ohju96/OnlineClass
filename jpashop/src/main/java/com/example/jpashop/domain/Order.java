package com.example.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // 양방향 연관관계는 연관관계 주인을 정해줘야 한다.
    @ManyToOne(fetch = FetchType.LAZY) // n대1
    @JoinColumn(name = "member_id") // 매핑을 뭘로 할 것인가? 외래키 이름이 member_id가 된다.
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING) // 꼭 스트링으로 써야한다.
    private OrderStatus status;

}
