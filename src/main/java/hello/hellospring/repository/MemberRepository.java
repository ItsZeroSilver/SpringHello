package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //저장
    Member save(Member member);

    //아이디 찾기
    Optional<Member> findById(Long id);

    //이름 찾기
    Optional<Member> findByName(String name);

    //전부 찾기
    List<Member> findAll();

}
