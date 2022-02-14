package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    private String name;

    @Embedded //내장 타입을 포함했음
    private Address address;

    @OneToMany(mappedBy = "member") //매핑 거울
    private List<Order> orders = new ArrayList<>();


}
