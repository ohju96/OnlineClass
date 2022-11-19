package com.example.jpashop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable // JPA 어딘가에 내장이 될 수 있다.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 이렇게 사용해 줘야 한다.
public class Address {
    private String city;
    private String street;
    private String zipcode;


//    // 어노테이션 대신 이렇게 사용해도 된다.
//    protected  Address() {
//
//    }
}
