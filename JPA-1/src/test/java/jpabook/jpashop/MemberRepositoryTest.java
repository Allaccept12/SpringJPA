package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;


    @AfterEach
    void afterEach() {

    }

    @Test
    @Transactional
//    @Rollback(false)
    void testMember() {
        //g
        Member member = new Member();
        member.setUsername("memberA");
        //w
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);
        //d
        assertThat(findMember.getId()).isEqualTo(saveId);
        assertThat(findMember).isEqualTo(member);
    }

}