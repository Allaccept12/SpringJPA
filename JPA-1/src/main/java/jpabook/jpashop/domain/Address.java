package jpabook.jpashop.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable // 내장 될수있는
@Getter
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }
}
