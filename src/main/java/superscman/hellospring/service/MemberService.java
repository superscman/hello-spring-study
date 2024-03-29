package superscman.hellospring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import superscman.hellospring.Repository.MemberRepository;
import superscman.hellospring.Repository.MemoryMemberRepository;
import superscman.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public long join(Member member) { // 운영 말고 개발하고 싶다
        //같은 이름 있는 중복 회원 X
        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start ;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(member1 -> {
            try {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            } catch (IllegalStateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
