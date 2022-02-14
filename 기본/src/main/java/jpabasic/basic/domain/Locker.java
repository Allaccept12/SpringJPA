package jpabasic.basic.domain;


import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LACKER_ID")
    private Long id;

    private String name;


}
