package superscman.hellospring.service;

import superscman.hellospring.Repository.MemberRepository;
import superscman.hellospring.Repository.MemoryMemberRepository;
import superscman.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public long join(Member member) {
        //같은 이름 있는 중복 회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(member1 -> {
            try {
                throw new IllegalAccessException("이미 존재하는 회원입니다.");
            } catch (IllegalAccessException e) {
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
