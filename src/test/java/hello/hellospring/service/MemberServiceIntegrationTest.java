package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional//Test 실행할때 transcation & rollback
class MemberServiceIntegrationTest {
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void join() throws Exception{
        Member member = new Member();
        member.setName("spring22");

        Long saveId = memberService.join(member);

        Member findMember = memberRepository.findById(saveId).get();
//        assertThat(findMember).isSameAs(member);
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void join_Exception() throws Exception{
        Member member1 = new Member();
        member1.setName("Spring1");
        Member member2 = new Member();
        member2.setName("Spring1");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        assertThat(e.getMessage().equals("이미 존재하는 회원입니다."));
    }


}