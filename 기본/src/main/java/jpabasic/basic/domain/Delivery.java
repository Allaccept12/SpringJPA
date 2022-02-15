package jpabasic.basic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Delivery extends TimeStamped{

    @Id @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

}
