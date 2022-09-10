package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //저장
    Member save(Member member);

    //아이디 찾기
    Optional<Member> findbyId(Long id);

    //이름 찾기
    Optional<Member> findbyName(String name);

    //전부 찾기
    List<Member> findAll();

    void clearStore();
}
