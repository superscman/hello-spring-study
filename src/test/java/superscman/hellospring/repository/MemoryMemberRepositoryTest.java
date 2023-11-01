package superscman.hellospring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import superscman.hellospring.Repository.MemberRepository;
import superscman.hellospring.Repository.MemoryMemberRepository;
import superscman.hellospring.domain.Member;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

       Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);
    }



}
