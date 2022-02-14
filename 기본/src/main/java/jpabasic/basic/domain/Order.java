package jpabasic.basic.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "ORDERS")
public class Order extends TimeStamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @Column(name = "MEMBER_ID")
    private Member member;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
