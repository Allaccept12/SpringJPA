package jpabasic.basic.jpql;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
