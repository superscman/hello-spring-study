package superscman.hellospring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import superscman.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
