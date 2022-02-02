package jpabook.jpashop;


import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class initDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Member member = createMember();
            em.persist(member);

            Book book1 = createBook("JPA1", 10000);
            em.persist(book1);

            Book book2 = createBook("JPA2", 20000);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Delivery delivery = createDelivery(member);

            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Book createBook(String JPA1, int price) {
            Book book1 = new Book();
            book1.setName(JPA1);
            book1.setPrice(price);
            book1.setStockQuantity(300);
            return book1;
        }

        public void dbInit2() {
            Member member = getMember();
            em.persist(member);

            Book book1 = createBook("SPRING2", 30000);
            em.persist(book1);

            Book book2 = createBook("SPRING3", 30000);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Delivery delivery = createDelivery(member);

            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Delivery createDelivery(Member member) {
            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            return delivery;
        }

        private Member getMember() {
            Member member = new Member();
            member.setName("userB");
            member.setAddress(new Address("진주","11","111"));
            return member;
        }

        private Member createMember() {
            Member member = new Member();
            member.setName("userA");
            member.setAddress(new Address("서울","11","111"));
            return member;
        }
    }

}


