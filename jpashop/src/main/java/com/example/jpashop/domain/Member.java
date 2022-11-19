package com.example.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //내장 타입이다. 라는 것을 명시(둘 중 하나만 있으면 되나 명시적으로 사용하기 위해 둘 다 사용)
    private Address address;

    @OneToMany(mappedBy = "member") // 1대n, 나는 저거에 맵핑된 거울일 뿐이야. 하는 인증이 맵드바이
    private List<Order> orders = new ArrayList<>();

//    @OneToMany(mappedBy = "order")
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//    private Delivery delivery;
//
//    private LocalDateTime orderDate; // 주문시간
//
//    @Enumerated(EnumType.STRING) // 꼭 스트링으로 써야한다.
//    private OrderStatus status; //주문 상태 [ORDER, CANCEL]
}
