package jpabook.jpashop.controller;


import jpabook.jpashop.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
    //private List<Member> memberList;
}
