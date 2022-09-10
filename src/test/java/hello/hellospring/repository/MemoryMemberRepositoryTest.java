package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("Spring");
        //when
        memberRepository.save(member);
        //then
        Member result = memberRepository.findbyId(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findbyName(){
        //given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring1");
        memberRepository.save(member2);

        //when
        Member result = memberRepository.findbyName("Spring1").get();

        //then
        assertThat(result).isSameAs(member1);

    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring1");
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }
}