package jpabasic.basic.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Address homeAddress;

//    @ElementCollection
//    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
//    @JoinColumn(name = "MEMBER_ID")) //값 타입을 하나 이상 저장할때 사용, 컬렉션을 저장하기 위한 별도의 테이블
//    @Column(name = "FOOD_NAME") // 하나인 값일때 컬럼명 정할떄 사용
//    private Set<String> favoriteFood = new HashSet<>();
//
//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//    @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();
}









